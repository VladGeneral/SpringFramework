package com.hibernate.demo;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            //start a transaction
            session.beginTransaction();

            //get instructor pk
            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println("Found " + instructor);

            //delete instructor
            if (instructor != null){
                System.out.println("deleting " + instructor);

                session.delete(instructor);
            }
            //commit
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
