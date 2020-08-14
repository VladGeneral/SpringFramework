package com.hibernate.demo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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
            Instructor instructor = session.get(Instructor.class,4);
            //create some courses
            Course course1 = new Course("air guitar");
            Course course2 = new Course("The pinball");
            //addcourses to instructor
            instructor.add(course1);
            instructor.add(course2);

            //save the courses
            session.save(course1);
            session.save(course2);
            //commit
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
