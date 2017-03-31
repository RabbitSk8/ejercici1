
package com.uniminuto.ejercicio1.dao;

import com.uniminuto.ejercicio1.entityEjb.Docente;
import com.uniminuto.ejercicio1.entityEjb.Materia;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class DocenteDaoImpl implements DocenteDao{

    @Override
    public String agregarDocente(Docente docente) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        String docenteId = null;
        try {
            tx = session.beginTransaction();
            docenteId = (String) session.save(docente);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return docenteId;
    }

    @Override
    public boolean borrarDocente(String codigo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
		Docente p = (Docente) session.load(Docente.class, new String(codigo));
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
