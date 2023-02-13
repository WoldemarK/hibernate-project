package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        try (sessionFactory) {
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//
//            Person ivan = Person.builder()
//                    .name("Ivan")
//                    .age(22)
//                    .build();
//            Person tom = Person.builder()
//                    .name("Tom")
//                    .age(23)
//                    .build();
//            Person jeri = Person.builder()
//                    .name("Jeri")
//                    .age(25)
//                    .build();
//
//            session.save(ivan);
//            session.save(tom);
//            session.save(jeri);
//
//            session.getTransaction().commit();
//        }
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 2);
            person.setName("Bob");

            session.getTransaction().commit();
        }
    }
}
