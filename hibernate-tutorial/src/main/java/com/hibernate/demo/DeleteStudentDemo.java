package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
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

            //delete the student
//            System.out.println("deleting student " + secondStudent);
//            session.delete(secondStudent);

            //delete student id=2
            System.out.println("deleting student id2");
            session
                    .createQuery("delete from Student s " +
                            "where s.id=2")
                    .executeUpdate();
            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
