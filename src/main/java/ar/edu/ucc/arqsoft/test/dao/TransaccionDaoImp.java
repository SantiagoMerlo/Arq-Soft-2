package ar.edu.ucc.arqsoft.test.dao;

import ar.edu.ucc.arqsoft.test.model.Operacion;
import ar.edu.ucc.arqsoft.test.model.Transaccion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TransaccionDaoImp extends DaoGenericoImp<Transaccion,Long> implements TransaccionDao{

    public List<Transaccion> getTransaccion(Operacion operacion) {

        List<Transaccion> transiciones = null;

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("OperacionNueva", operacion);

        transiciones = this.getByProperties(properties);

        return transiciones;
    }
}
