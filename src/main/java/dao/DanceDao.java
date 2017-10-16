package dao;

import entity.Dance;
import entity.Man;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

/**
 * Created by icebotari on 10/11/2017.
 */
public class DanceDao {
    private static Session session;

    public static void addDance(Dance dance){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.persist(dance);
        session.getTransaction().commit();
        session.close();
    }
    public static void editDance(String style, Dance dance){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(style, dance);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteDance(Dance dance){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(dance);
        session.getTransaction().commit();
        session.close();
    }
    public static Dance getDanceById(int id){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        return session.get(Dance.class, id);
    }
    public static List<Dance> getAllDance(){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        return session.createQuery("FROM Dance").list();
    }
}
