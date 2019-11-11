package ar.edu.ucc.arqsoft.test.dto;

import ar.edu.ucc.arqsoft.test.model.Transaccion;
import ar.edu.ucc.arqsoft.test.model.Usuario;

import java.util.HashSet;
import java.util.Set;

public class TarjetaDto {

    private Long id;

    private String numero;

    private Double saldo;

    private Set<Transaccion> transaciones = new HashSet<Transaccion>();

    private Usuario usuario;

    public TarjetaDto(){

    }

    public TarjetaDto(Long id, String numero, Double saldo, Set<Transaccion> transaciones, Usuario usuario) {
        super();
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.transaciones = transaciones;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Set<Transaccion> getTransaciones() {
        return transaciones;
    }

    public void setTransaciones(Set<Transaccion> transaciones) {
        this.transaciones = transaciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
