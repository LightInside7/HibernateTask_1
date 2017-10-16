package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by icebotari on 10/9/2017.
 */
public class HibernateUtils {
    private static Session session;
    private static Configuration configuration;

    static {
        configuration = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/taskscheme")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "j30n28B78584")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addAnnotatedClass(entity.Man.class)
                .addAnnotatedClass(entity.Woman.class)
                .addAnnotatedClass(entity.Dance.class);
    }

    public static Session getSession() {
        SessionFactory factory = configuration.buildSessionFactory();
        session = factory.openSession();
        return session;
    }
}

