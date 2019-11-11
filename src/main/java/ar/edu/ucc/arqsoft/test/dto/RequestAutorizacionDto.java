package ar.edu.ucc.arqsoft.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestAutorizacionDto {

    @JsonProperty("tarjeta")
    private TarjetaTransacionDto tarjeta;

    private Double monto;

    public TarjetaTransacionDto getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaTransacionDto tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

}
