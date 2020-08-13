package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            System.out.println("Creating new student object ");
            Student student = new Student("ReadStudent", "lname11", "email11");

            //start a transaction
            session.beginTransaction();
            //save object
            System.out.println("saving the student ");
            System.out.println(student);
            session.save(student);

            //commit
            session.getTransaction().commit();

            //New code

            //find out the student id: primary key
            System.out.println("saved student/ generated id " + student.getId());

            //get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            //retrieve student based on the id: primary key
            System.out.println("\ngetting student with id: " + student.getId());

            Student secondStudent = session.get(Student.class, student.getId());
            System.out.println("get complete: " + secondStudent);
            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
