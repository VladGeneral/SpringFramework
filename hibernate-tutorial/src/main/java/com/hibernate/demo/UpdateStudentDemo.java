package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session;
        try {
            int stidentId = 1;

            //get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            //retrieve student based on the id: primary key
            System.out.println("\ngetting student with id: " + stidentId);

            Student secondStudent = session.get(Student.class, stidentId);
            System.out.println("updating student... ");
            secondStudent.setFirstName("Scooby");

            //commit transaction
            session.getTransaction().commit();


            //New CODE
            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            System.out.println("updating email for all students");

            session
                    .createQuery("update Student " +
                            "set email='foo@gmail.com'")
                    .executeUpdate();
            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
