package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentImagesDemo {

    public static void main(String[] args) {



        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            int id = 1;
            Student student = session.get(Student.class,id);

            System.out.println("student details " + student);

            System.out.println("Images" + student.getImages());

            session.getTransaction().commit();

        }
    }
}
