package com.hibernate.demo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            int theId = 4;
            //start a transaction
            session.beginTransaction();

            //option 2 Hibernate query with HQL

            //get instructor from db
            Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id=:theInstructorId",
                    Instructor.class);

            //set parameter on query
            query.setParameter("theInstructorId", theId);

            //execute query
            Instructor instructor = query.getSingleResult();

            System.out.println("||instructor " + instructor);


            //commit
            session.getTransaction().commit();
            //close the session
            session.close();

            System.out.println("\nclosing the session\n");

            //get course
            System.out.println("||courses " + instructor.getCourses());

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
