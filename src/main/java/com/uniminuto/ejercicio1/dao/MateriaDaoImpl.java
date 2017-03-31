/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.ejercicio1.dao;

import com.uniminuto.ejercicio1.entityEjb.Docente;
import com.uniminuto.ejercicio1.entityEjb.Estudiante;
import com.uniminuto.ejercicio1.entityEjb.Materia;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MateriaDaoImpl implements MateriaDao{
    
     @PersistenceContext(unitName = "movie-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

//    public List findAllServicios() {
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        List employees = session.createQuery("from Servicio ").list();
//        session.close();
//        return employees;
//    }
//
//    public Servicio findById(int id) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Servicio> cq = cb.createQuery(Servicio.class);
//        Root<Servicio> model = cq.from(Servicio.class);
//        cq.where(cb.equal(model.get("id"), id));
//        TypedQuery<Servicio> q = em.createQuery(cq);
//        return q.getSingleResult();
//    }
    
    
    @Override
    public String agregarMateria(Materia materia) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        String materiaId = null;
        try {
            tx = session.beginTransaction();
            materiaId = (String) session.save(materia);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return materiaId;
    }

    @Override
    public boolean borrarMateria(String codigo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
		Materia p = (Materia) session.load(Materia.class, new String(codigo));
		if(null != p){
			session.delete(p);
		}

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public void consultarMateriasAsignadas(String codigoDocente) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query=session.createQuery("from Materia M where M.docente.codigoDocente =:codigo");
        query.setParameter("codigo", codigoDocente);
        Docente docente =(Docente) query.getResultList();
        
        System.out.println("Apellido docente: "+docente.getApellido());
    }
    
    public void recorrerLista(List nombre){
        Iterator<String> it =nombre.iterator();
        int i=0;
        while(it.hasNext()){
            System.out.println("Dato"+(i++)+": "+it.next());
        }
    }
    
}
