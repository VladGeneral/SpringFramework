package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            //start a transaction
            session.beginTransaction();

            //query students  // work with java classes and fields
            List<Student> studentList = session
                    .createQuery("from Student")
                    .getResultList();
            //display the students
            displayTheStudents(studentList);

            //query students lastname='doe'
            studentList = session
                    .createQuery("from Student s where s.lastName='doe'")
                    .getResultList();
            System.out.println("\nStudent last name equals doe");
            displayTheStudents(studentList);

            //query students lastname='doe' or firstname ='bonita'
            studentList = session
                    .createQuery("from Student s " +
                            "where s.lastName='doe' " +
                            "or s.firstName='bonita'")
                    .getResultList();
            System.out.println("\nquery students lastname='doe' or firstname ='bonita'");
            displayTheStudents(studentList);

            //query students where email LIKE '%l2c'
            studentList = session
                    .createQuery("from Student s " +
                            "where s.email " +
                            "like '%l2c'")
                    .getResultList();
            System.out.println("\nquery students where email LIKE '%l2c'");
            displayTheStudents(studentList);

            //commit
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }

    private static void displayTheStudents(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
