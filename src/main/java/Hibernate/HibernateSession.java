package Hibernate;

import Hibernate.model.Course;
import Hibernate.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession implements AutoCloseable {
    private final SessionFactory sessionFactory;

    public HibernateSession() {
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg2.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
