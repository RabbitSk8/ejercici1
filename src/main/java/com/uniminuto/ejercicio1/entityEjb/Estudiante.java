
package com.uniminuto.ejercicio1.entityEjb;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name="estudiante")
public class Estudiante {
    
    @Id
    @Column(name="codigo_estudiante")
    private String codigoEstudiante;
    
    @Column(name="cedula")
    private String cedula;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    public Estudiante(){
        
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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
    
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name="estudiante_has_materia",joinColumns = @JoinColumn(name="codigo_estudiante"),inverseJoinColumns = @JoinColumn(name="codigo_materia"))
//    private List<Materia> materias;
}
