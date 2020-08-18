package com.hibernate.demo;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {

            //start a transaction
            session.beginTransaction();

            //create a course
            Course course = new Course("Pacman");

            System.out.println("saving the course " + course);

            session.save(course);

            System.out.println("saved the course " + course);

            //create the students

            Student student1 = new Student("john","doe", "john@luv2code.com");
            Student student2 = new Student("mary","public", "mary@luv2code.com");

            //add students course
            course.addStudent(student1);
            course.addStudent(student2);

            //save the students
            System.out.println("saving students ");
            session.save(student1);
            session.save(student2);
            System.out.println("saved student - " + course.getStudents());

            //commit
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
