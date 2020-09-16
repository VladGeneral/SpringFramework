package com.hibernate.demo;


import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

public class CreateUserStudentInstructorDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();


        try(Session session = sessionFactory.getCurrentSession()) {
            Student student = new Student("john", "doe", "johnd@dfs.dd","hibernate course");
            Instructor instructor = new Instructor("joe", "moe", "joehnd@dfs.dd", 20000.00);




            session.beginTransaction();


            session.persist(student);
            session.persist(instructor);


            session.getTransaction().commit();
        }
    }
}
