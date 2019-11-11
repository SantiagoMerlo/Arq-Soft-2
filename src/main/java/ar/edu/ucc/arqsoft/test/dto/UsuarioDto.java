package ar.edu.ucc.arqsoft.test.dto;

public class UsuarioDto {

    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    public UsuarioDto(){

    }

    public UsuarioDto(Long id, String nombre, String apellido, String dni) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
