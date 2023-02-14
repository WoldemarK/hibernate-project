package org.example.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActorMovie {
    public static void main(String[] args) {
        var configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Movie hotHeads = new Movie("Hot heads", 1991);

            Actor actor = session.get(Actor.class, 1);

            hotHeads.addActor(actor);

            actor.addMovie(hotHeads);

            session.save(hotHeads);


//            Movie movie = new Movie("Операция Ы", 2000);
//
//            Actor nikulin = new Actor("Юрий Никулин", 1921);
//            Actor mihail = new Actor("Михаил Пуговкин", 1923);
//
//            movie.addActor(nikulin);
//            movie.addActor(mihail);
//
//            nikulin.addMovie(movie);
//            mihail.addMovie(movie);
//
//            session.save(movie);
//
//            session.save(nikulin);
//            session.save(mihail);
//
//            Movie movie1 = session.get(Movie.class, 1);
//            System.out.println(movie1.getActors());

            session.getTransaction().commit();
        }
    }


}
