package dao;

import entity.Man;
import entity.Woman;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

/**
 * Created by icebotari on 10/11/2017.
 */
public class WomanDao {
    private static Session session;

    public static void addWoman(Woman woman){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.persist(woman);
        session.getTransaction().commit();
        session.close();
    }
    public static void editWoman(String name, Woman woman){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(name, woman);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteWoman(Woman woman){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(woman);
        session.getTransaction().commit();
        session.close();
    }
    public static Woman getWomanById(int id){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        return session.get(Woman.class, id);
    }
    public static List<Woman> getAllWomans(){
        session = HibernateUtils.getSession();
        session.beginTransaction();
        return session.createQuery("FROM Woman").list();
    }
}
