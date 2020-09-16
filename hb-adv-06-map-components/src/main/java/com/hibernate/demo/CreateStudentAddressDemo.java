package com.hibernate.demo;

import com.hibernate.demo.entity.Address;
import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

public class CreateStudentAddressDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();


        try(Session session = sessionFactory.getCurrentSession()) {
            Student student = new Student("john", "doe", "johnd@dfs.dd");

            Address address = new Address("some street","some sity", "600222");

            session.beginTransaction();


            student.setHomeAddress(address);


            session.persist(student);

            session.getTransaction().commit();
        }
    }
}
