package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateStudentImagesSortedMapDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try(Session session = sessionFactory.getCurrentSession()) {
            Student student = new Student("john", "doe", "johnd@dfs.dd");
            Map<String, String> images = student.getImages();
            images.put("photo1.jpg","photo1");
            images.put("photo5.jpg","photo5");
            images.put("photo3.jpg","photo3");
            images.put("photo4.jpg","photo4");

            session.beginTransaction();

            session.persist(student);

            session.getTransaction().commit();
        }
    }
}
