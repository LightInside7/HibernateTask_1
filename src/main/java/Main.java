import dao.DanceDao;
import dao.ManDao;
import dao.WomanDao;
import entity.Dance;
import entity.Man;
import entity.Woman;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Map;

/**
 * Created by icebotari on 10/9/2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        Man man = ManDao.getManById(4);
        Man man2 = ManDao.getManById(5);
//        ManDao.addMan(man);
//        ManDao.addMan(man2);
//        man.setName("Stas");
//        System.out.println(man.getId());
//        ManDao.editMan("Fedea", man);
//        ManDao.deleteMan(man2);
//        System.out.println(ManDao.getManById(1).getName());
//        for(Man a: ManDao.getAllMans()){
//            System.out.println(a.getName().toString());
//        }
        Woman woman = WomanDao.getWomanById(1);
        Woman woman2 = WomanDao.getWomanById(2);
//        WomanDao.addWoman(woman);
//        WomanDao.addWoman(woman2);
//        WomanDao.editWoman("Nastya", woman);
//        WomanDao.deleteWoman(woman2);
//        System.out.println(WomanDao.getWomanById(1).getName());
//        for(Woman a: WomanDao.getAllWomans()){
//            System.out.println(a.getName().toString());
//        }
//        Dance dance = new Dance(man, woman, "Tango");
          Dance dance = DanceDao.getDanceById(8);
//        Dance dance2 = new Dance(man2, woman2, "Vals");
//        DanceDao.addDance(dance);
//        DanceDao.addDance(dance2);
        dance.setStyle("Polka");
        System.out.println(dance.getStyle().toString());
        DanceDao.editDance("Tango", dance);
//        DanceDao.deleteDance(dance);
    }
}