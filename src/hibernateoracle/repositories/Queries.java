package hibernateoracle.repositories;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import hibernateoracle.Emp;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author elena
 */
public class Queries {

    private Session session;
    SessionFactory sessionFactory;

    public Queries() {
    }

    public Session getSession() {

        if (session == null) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
        }
        return session;
    }

       public <T> List<T> consulta(String ConsultaSQL) {
        Query query = getSession().createQuery(ConsultaSQL);
        return query.list();
    }
       
    public void altaEmpleado(Emp empleado) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(empleado);
        tx.commit();
        session.close();
    }

    public void bajaEmpleado(Emp empleado) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(empleado);
        tx.commit();
        session.close();
    }

 

}
