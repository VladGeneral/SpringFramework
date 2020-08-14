package com.hibernate.demo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {

            //start a transaction
            session.beginTransaction();

            //get instructor from db
            Instructor instructor = session.get(Instructor.class, 4);
            System.out.println("||instructor " + instructor);

            System.out.println("||courses " + instructor.getCourses());

            //commit
            session.getTransaction().commit();
            //close the session
            session.close();

            System.out.println("\nclosing the session\n");
            //option 1 call getter method while session is open line 28 line 38 will work(уже в памяти)

            //get course
            System.out.println("||courses " + instructor.getCourses());

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
