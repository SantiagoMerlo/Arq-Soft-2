package ar.edu.ucc.arqsoft.test.dto;

import ar.edu.ucc.arqsoft.test.model.Operacion;
import ar.edu.ucc.arqsoft.test.model.Tarjeta;

import java.util.Date;

public class TransaccionDto{
    private Long id;

    private Date fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Double monto;

    private Operacion operacion;

    private Tarjeta tarjeta;

    public TransaccionDto() {

    }

    public TransaccionDto(Long id, Date fecha, Double monto, Operacion operacion, Tarjeta tarjeta) {
        super();
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.operacion = operacion;
        this.tarjeta = tarjeta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
