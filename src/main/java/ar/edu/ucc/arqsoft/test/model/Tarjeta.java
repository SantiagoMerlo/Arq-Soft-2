package ar.edu.ucc.arqsoft.test.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="TARJETA")
public class Tarjeta extends ObjetoGenerico {

    @Column(name="NUMERO", nullable= false)
    private String numero;

    @Column(name="SALDO", nullable= false)
    private double saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USUARIO_ID", nullable=false)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="tarjeta")
    private Set<Transaccion> transacciones = new HashSet<Transaccion>();

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Set<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}