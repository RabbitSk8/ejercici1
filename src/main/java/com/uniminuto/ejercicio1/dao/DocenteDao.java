
package com.uniminuto.ejercicio1.dao;

import com.uniminuto.ejercicio1.entityEjb.Docente;

public interface DocenteDao {
    
    String agregarDocente(Docente docente);
    boolean borrarDocente(String codigo);
    
}
