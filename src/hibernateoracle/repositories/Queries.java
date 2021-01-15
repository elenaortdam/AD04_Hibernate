package hibernateoracle.repositories;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import hibernateoracle.Dept;
import hibernateoracle.Emp;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author elena
 */
public class Queries {
    
     public void Altaempleado(Emp empleado) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(empleado);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Insertado correctamente");
    }

    public void Bajaempleado(Emp empleado) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(empleado);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Borrado correctamente");
    }

    public void ConsultaSQL(String ConsultaSQL) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery(ConsultaSQL);
        List<Object[]> listaSQL = query.list();
        for (Object[] objecto : listaSQL) {
            Emp empleado = (Emp) objecto[0];
            Dept departamente = (Dept) objecto[1];  
            System.out.println("Nombre de empleado :"+empleado.getEname()+" || Número de empleado: "+empleado.getEmpno()
            +" || Salario: "+empleado.getSal()+" || Departamento: "+departamente.getDname()+" || Localización departamento: "+departamente.getLoc());
        }
        
        sesion.close();
    
    }
    
}
