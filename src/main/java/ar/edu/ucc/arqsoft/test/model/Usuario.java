package ar.edu.ucc.arqsoft.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario extends ObjetoGenerico{

    @Column(name="NOMBRE", length=300, nullable= false)
    private String nombre;

    @Column(name="APELLIDO", length=200, nullable= false)
    private String apellido;

    @Column(name="DNI", length=200, nullable= false)
    private String dni;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() { return dni; }

    public void setDni(String dni) { this.dni = dni; }
}

