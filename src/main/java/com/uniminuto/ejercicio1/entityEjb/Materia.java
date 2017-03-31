/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.ejercicio1.entityEjb;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="materia")
public class Materia {
    
    @Id
    @Column(name="codigo_materia")
    private String codigoMateria;
    
    @Column(name="codigo_docente")
    private String codigoDocente;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="numero_creditos")
    private String numeroCreditos;
    
    
    public Materia(){
        
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
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

    public String getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(String numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="codigo_docente")
//    private Docente docente;
//    
//    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "materias")
//    private List<Estudiante> estudiantes;
}
