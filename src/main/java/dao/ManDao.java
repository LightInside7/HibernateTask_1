package dao;

import entity.Man;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

/**
 * Created by icebotari on 10/9/2017.
 */
public class ManDao {
    private static Session session;

    public static void addMan(Man man){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.persist(man);
        session.getTransaction().commit();
        session.close();
    }
    public static void editMan(String name, Man man){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(name, man);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteMan(Man man){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(man);
        session.getTransaction().commit();
        session.close();
    }
    public static Man getManById(int id){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        return session.get(Man.class, id);
    }
    public static List<Man> getAllMans(){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        return session.createQuery("FROM Man").list();
    }
}
