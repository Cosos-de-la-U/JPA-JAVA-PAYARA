package models;

import jakarta.persistence.*;

@Table(name="persona")
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Contacto.buscarTodos", query = "SELECT p from persona p order by p.id"),
})
public class persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String sexo;

    public persona(int id, String nombre, String apellido, String correo, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.sexo = sexo;
    }

    public persona(String nombre, String apellido, String correo, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.sexo = sexo;
    }

    public persona(int id) {
        this.id = id;
    }

    public persona() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
