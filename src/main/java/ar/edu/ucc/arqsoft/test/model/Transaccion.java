package ar.edu.ucc.arqsoft.test.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TRANSACCION")
public class Transaccion extends ObjetoGenerico{

    @Column(name="FECHA", nullable=false)
    private Date fecha;

    @Column(name="MONTO", nullable=true)
    private double monto;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="OPERACION", nullable=false)
    private Operacion operacion;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity= Tarjeta.class)
    @JoinColumn(name="TARJETA_ID", nullable=false)
    private Tarjeta tarjeta;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
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

