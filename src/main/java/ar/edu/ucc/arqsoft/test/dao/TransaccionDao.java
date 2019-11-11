package ar.edu.ucc.arqsoft.test.dao;

import ar.edu.ucc.arqsoft.test.model.Operacion;
import ar.edu.ucc.arqsoft.test.model.Transaccion;

import java.util.List;

public interface TransaccionDao extends DaoGenerico<Transaccion,Long> {

    public List<Transaccion> getTransaccion(Operacion operacion);

}
