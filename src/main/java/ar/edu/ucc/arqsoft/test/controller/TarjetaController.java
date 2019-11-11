package ar.edu.ucc.arqsoft.test.controller;

import ar.edu.ucc.arqsoft.test.dto.RequestAutorizacionDto;
import ar.edu.ucc.arqsoft.test.dto.ResponseAutorizacionDto;
import ar.edu.ucc.arqsoft.test.dto.TarjetaDto;
import ar.edu.ucc.arqsoft.test.dto.TransaccionDto;
import ar.edu.ucc.arqsoft.test.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class TarjetaController {

    @Autowired
    TarjetaService servicio;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> holaMundo() throws Exception {

        String holaMundo = "<h1>Trabajo Practico Evaluatico</h1><br>"+
                "<h2>Por Merlo Santiago y Misa Carolina</h2><br>";
        return new ResponseEntity(holaMundo, HttpStatus.OK);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/tarjeta", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> crearTarjeta(@RequestBody TarjetaDto dto) throws Exception {

       TarjetaDto creado = servicio.crearTarjeta(dto);

        return new ResponseEntity(creado, HttpStatus.CREATED);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/tarjetas/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> mostrarTarjeta(@PathVariable("id") Long id) throws Exception {

        TarjetaDto dto = servicio.mostrarTarjeta(id);

        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/tarjetas/{id}/transaciones", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> mostrarTransaciones(@PathVariable("id") Long id) throws Exception {

        Set<TransaccionDto> dto  = servicio.mostrarTransaciones(id);

        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/Endpoint/carga", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> cargarSaldo(@RequestBody RequestAutorizacionDto dto) throws Exception {

        ResponseAutorizacionDto respuesta = servicio.cargarSaldo(dto);

        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/Endpoint/descarga", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> descontarSaldo(@RequestBody RequestAutorizacionDto dto) throws Exception {

        ResponseAutorizacionDto respuesta = servicio.descontarSaldo(dto);

        return new ResponseEntity(respuesta, HttpStatus.OK);
    }
}
