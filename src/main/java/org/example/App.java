package org.example;

import org.example.model.Item;
import org.example.model.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            Item item = new Item("new ITEM", person);

            person.getItems().add(item);

            session.save(item);

            Person newPerson = new Person("Test Person create", 20);

            Item newItem = new Item("Test new Item", newPerson);

            newPerson.setItems(new ArrayList<>(Collections.singletonList(newItem)));

            session.save(newPerson);
            session.save(newItem);

            session.getTransaction().commit();
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);
//
//            List<Item> list = person.getItems();
//            System.out.println(list);
//
//            Item item = session.get(Item.class, 3);
//            System.out.println(item);
//            Person p = item.getOwner();
//            System.out.println(p);


        }

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
//        try (sessionFactory) {
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//
//            Person person = session.get(Person.class, 2);
//            person.setName("Bob");
//
//            session.getTransaction().commit();
//        }
//        try (sessionFactory) {
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//
//            Person person = session.get(Person.class, 2);
//            session.delete(person);
//
//            session.getTransaction().commit();
//        }
//        try (sessionFactory) {
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            List<Person>people = session.createQuery("from Person").getResultList();
//            for (Person person : people)
//                System.out.println(person);
//            session.getTransaction().commit();
//        }
    }
}
