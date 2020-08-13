package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            //create 3 student objects
            System.out.println("Creating 3 student objects ");
            Student student1 = new Student("john", "doe", "ejomail1");
            Student student2 = new Student("mary", "public", "maryemail1");
            Student student3 = new Student("bonita", "applebum", "applebumemail1");

            //start a transaction
            session.beginTransaction();
            //save object
            System.out.println("saving the students ");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            //commit
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
