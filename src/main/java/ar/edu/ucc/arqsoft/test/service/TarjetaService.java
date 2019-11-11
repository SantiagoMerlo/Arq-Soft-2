package ar.edu.ucc.arqsoft.test.service;

import ar.edu.ucc.arqsoft.test.dao.DaoGenerico;
import ar.edu.ucc.arqsoft.test.dto.*;
import ar.edu.ucc.arqsoft.test.model.Operacion;
import ar.edu.ucc.arqsoft.test.model.Tarjeta;
import ar.edu.ucc.arqsoft.test.model.Transaccion;
import ar.edu.ucc.arqsoft.test.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Transactional
public class TarjetaService {

    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    DaoGenerico<Tarjeta,Long> dao;

    @Autowired
    DaoGenerico<Usuario,Long> usuarioDao;

    @Autowired
    DaoGenerico<Transaccion,Long> transaccionDao;

    public TarjetaDto crearTarjeta(TarjetaDto dto){

        if(usuarioDao.load(dto.getUsuario().getId()) == null){

            log.info("El usuario no existe");

            return dto;

        } else {

            Tarjeta tarjeta = new Tarjeta();

            tarjeta.setNumero(dto.getNumero());
            tarjeta.setSaldo(0);
            tarjeta.setTransacciones(null);
            tarjeta.setUsuario(dto.getUsuario());

            dao.saveOrUpdate(tarjeta);

            dto.setId(tarjeta.getId());

            return dto;
        }
    }
    public TarjetaDto mostrarTarjeta(Long id){

        if(usuarioDao.load(id) == null){

            log.info("la tarjeta no existe");
            return new TarjetaDto();

        } else {
            Tarjeta t = dao.load(id);

            return new TarjetaDto(id,t.getNumero(),t.getSaldo(), t.getTransacciones(), t.getUsuario());
        }
    }
    /*
    @Funcion template que guarda la transaccion y actualiza el monto de la tarjeta
     */
    void transaccionar(Tarjeta tarjeta, Double monto){

        Date fecha = Calendar.getInstance().getTime();

        Transaccion transaccion = new Transaccion();
        transaccion.setFecha(fecha);
        transaccion.setMonto(monto);
        transaccion.setTarjeta(tarjeta);
        if(Operacion.CREDITO == transaccion.getOperacion()){
            transaccion.setOperacion(Operacion.CREDITO);
            tarjeta.setSaldo(monto);
        } else {
            transaccion.setOperacion(Operacion.DEBITO);
            tarjeta.setSaldo(monto);
        }
        transaccionDao.insert(transaccion);

        Set<Transaccion> transaciones = tarjeta.getTransacciones();
        transaciones.add(transaccion);

        tarjeta.setTransacciones(transaciones);
        dao.update(tarjeta);

    }

    public ResponseAutorizacionDto cargarSaldo(RequestAutorizacionDto dto){

        final String uri = "https://iua-service.herokuapp.com/autorizar";

        Tarjeta tarjeta = dao.load(dto.getTarjeta().getNumber());

        if(tarjeta == null){

            log.info("no existe la tarjeta");
            return new ResponseAutorizacionDto(dto.getTarjeta().getNumber().toString(),"ERROR","2");

        } else {

            transaccionar(tarjeta,dto.getMonto()+tarjeta.getSaldo());
            return new RestTemplate().postForObject(uri,dto,ResponseAutorizacionDto.class);

        }

    }
    
    public ResponseAutorizacionDto descontarSaldo(RequestAutorizacionDto dto){


        Tarjeta tarjeta = dao.load(dto.getTarjeta().getNumber());
        if(tarjeta == null){

            log.info("no existe la tarjeta");
            return new ResponseAutorizacionDto(dto.getTarjeta().getNumber().toString(),"RECHAZADA","2");

        } else {

            Double saldo = tarjeta.getSaldo() - dto.getMonto();

            if (saldo > 0) {

                transaccionar(tarjeta,saldo);
                return new ResponseAutorizacionDto(dto.getTarjeta().getNumber().toString(),"APROBADO","2");

            }else{
                log.info("La tarjeta no tiene saldo suficiente");
                return new ResponseAutorizacionDto(dto.getTarjeta().getNumber().toString(),"RECHAZADA","2");

            }
        }
    }
    public Set<TransaccionDto> mostrarTransaciones(Long id){
        Tarjeta tarjeta = dao.load(id);
        if( tarjeta == null) {
            log.info("la tarjeta no existe");
            return null;
        } else {

            Set<Transaccion> transacciones = tarjeta.getTransacciones();

            Set<TransaccionDto> transaccionDtos = new HashSet<TransaccionDto>();

            for (Transaccion t: transacciones){
                transaccionDtos.add(new TransaccionDto(t.getId(),t.getFecha(),t.getMonto(),t.getOperacion(),t.getTarjeta()));
            }

            return transaccionDtos;
        }
    }


}

