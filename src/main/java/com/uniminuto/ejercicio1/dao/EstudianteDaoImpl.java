
package com.uniminuto.ejercicio1.dao;

import com.uniminuto.ejercicio1.entityEjb.Estudiante;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EstudianteDaoImpl implements EstudianteDao {
    
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
    public String agregarEstudiante(Estudiante estudiante) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        String estudianteId = null;
        try {
            tx = session.beginTransaction();
            estudianteId = (String) session.save(estudiante);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return estudianteId;
    }

    @Override
    public boolean borrarEstudiante(String codigo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
		Estudiante p = (Estudiante) session.load(Estudiante.class, new String(codigo));
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

    
}
