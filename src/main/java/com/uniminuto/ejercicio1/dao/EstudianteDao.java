/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.ejercicio1.dao;

import com.uniminuto.ejercicio1.entityEjb.Estudiante;

public interface EstudianteDao {

    String agregarEstudiante(Estudiante estudiante);
    boolean borrarEstudiante(String codigo);
}
