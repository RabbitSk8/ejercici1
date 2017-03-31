
package com.uniminuto.ejercicio1.entityEjb;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="docente")
public class Docente {
    
    @Id
    @Column(name="codigo_docente")
    private String codigoDocente;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="direccion")
    private String direccion;
    
    @Column(name="especializacion")
    private String especializacion;
    
    public Docente(){
        
    }

    public String getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(String codigoDocente) {
        this.codigoDocente = codigoDocente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
    
//    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private List<Materia> materias;
}
