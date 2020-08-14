package com.hibernate.demo;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            //create the objects
//            Instructor instructor = new Instructor("Chad","Darby", "darby@luv2code.com");
//
//            InstructorDetail instructorDetail = new InstructorDetail("http://luv2code.com/youtube", "Luv 2 code");

            //create the objects
            Instructor instructor = new Instructor("madhu","rby", "madu@luv2code.com");

            InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com", "Guitar");

            //associate the objects
            instructor.setInstructorDetail(instructorDetail);

            //start a transaction
            session.beginTransaction();

            //save the instructor
            //this will also save the details objects
            //because of CascadeType.All
            System.out.println("saving instructor " + instructor);
            session.save(instructor);

            //commit
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
