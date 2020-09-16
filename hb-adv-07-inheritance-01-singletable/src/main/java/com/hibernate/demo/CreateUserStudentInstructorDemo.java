package com.hibernate.demo;


import com.hibernate.demo.entity.Status;
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
                .buildSessionFactory();


        try(Session session = sessionFactory.getCurrentSession()) {
            Student student = new Student("john", "doe", "johnd@dfs.dd", Status.ACTIVE);
            Student student1 = new Student("joe", "moe", "joehnd@dfs.dd", Status.INACTIVE);



            session.beginTransaction();


            session.persist(student);
            session.persist(student1);


            session.persist(student);

            session.getTransaction().commit();
        }
    }
}
