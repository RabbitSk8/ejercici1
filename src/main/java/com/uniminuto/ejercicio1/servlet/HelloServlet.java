/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.ejercicio1.servlet;

import com.uniminuto.ejercicio1.dao.DocenteDaoImpl;
import com.uniminuto.ejercicio1.dao.EstudianteDaoImpl;
import com.uniminuto.ejercicio1.dao.MateriaDaoImpl;
import com.uniminuto.ejercicio1.entityEjb.Docente;
import com.uniminuto.ejercicio1.entityEjb.Estudiante;
import com.uniminuto.ejercicio1.entityEjb.Materia;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filtro = request.getParameter("campoOculto");

        EstudianteDaoImpl estudianteDao = new EstudianteDaoImpl();
        DocenteDaoImpl docenteDao = new DocenteDaoImpl();
        MateriaDaoImpl materiaDao = new MateriaDaoImpl();

        //*********************insertar estudiante******************************
        if (filtro.equals("studentAgregar")) {
            String nombreVariable = request.getParameter("nombreEstudiante");
            String apellidoVariable = request.getParameter("apellidoEstudiante");
            String cedulaVariable = request.getParameter("cedulaEstudiante");

            Estudiante estudiantePojo = crearEstudiantePojo(nombreVariable, apellidoVariable, cedulaVariable);
            String idEstudiante = estudianteDao.agregarEstudiante(estudiantePojo);
            request.getRequestDispatcher("/index.jsp").include(request, response);
        }

        //*********************eliminar estudiante******************************
        if (filtro.equals("studentEliminar")) {
            boolean isDelete = estudianteDao.borrarEstudiante("E00001");
            request.getRequestDispatcher("/eliminar.jsp").include(request, response);
        }

        //*********************insertar docente******************************
        if (filtro.equals("teacherAgregar")) {
            String nombreVariable = request.getParameter("nombreDocente");
            String apellidoVariable = request.getParameter("apellidoDocente");
            String direccionVariable = request.getParameter("direccionDocente");
            String especializacionVariable = request.getParameter("especializacionDocente");

            Docente docentePojo = crearDocentePojo(nombreVariable, apellidoVariable, direccionVariable, especializacionVariable);
            String idDocente = docenteDao.agregarDocente(docentePojo);
            request.getRequestDispatcher("/index.jsp").include(request, response);
        }

        //*********************eliminar docente******************************
        if (filtro.equals("teacherEliminar")) {
            boolean isDelete = docenteDao.borrarDocente("D00001");
            request.getRequestDispatcher("/eliminar.jsp").include(request, response);
        }

        //*********************insertar materia******************************
        if (filtro.equals("subjectAgregar")) {
            String codigoDocenteVariable = request.getParameter("codigoDocente");
            String nombreVariable = request.getParameter("nombreMateria");
            String numeroCreditosVariable = request.getParameter("creditosMateria");

            Materia materiaPojo = crearMateriaPojo(codigoDocenteVariable, nombreVariable, numeroCreditosVariable);
            String idMateria = materiaDao.agregarMateria(materiaPojo);
            request.getRequestDispatcher("/index.jsp").include(request, response);
        }

        //*********************consultar materias******************************
        if (filtro.equals("subjectConsultar")) {
            String codigoDocenteVariable = request.getParameter("codigoDocente");
            materiaDao.consultarMateriasAsignadas(codigoDocenteVariable);
        }

        //*********************eliminar materia******************************
        if (filtro.equals("subjectEliminar")) {
            boolean isDelete = materiaDao.borrarMateria("M00001");
            request.getRequestDispatcher("/eliminar.jsp").include(request, response);
        }

    }

    public Estudiante crearEstudiantePojo(String nombre, String apellido, String cedula) {
        Estudiante estudiante = new Estudiante();
        int contador = 0;
        estudiante.setCodigoEstudiante(String.valueOf(contador++));
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setCedula(cedula);
        return estudiante;
    }

    public Docente crearDocentePojo(String nombre, String apeliido, String direccion, String especializacion) {
        Docente docente = new Docente();
        int contador = 0;
        docente.setCodigoDocente(String.valueOf(contador++));
        docente.setNombre(nombre);
        docente.setApellido(apeliido);
        docente.setDireccion(direccion);
        docente.setEspecializacion(especializacion);
        return docente;
    }

    public Materia crearMateriaPojo(String codigoDocente, String nombre, String numeroCreditos) {
        Materia materia = new Materia();
        int contador = 0;
        materia.setCodigoMateria(String.valueOf(contador++));
        materia.setCodigoDocente(codigoDocente);
        materia.setNombre(nombre);
        materia.setNumeroCreditos(numeroCreditos);
        return materia;
    }

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
