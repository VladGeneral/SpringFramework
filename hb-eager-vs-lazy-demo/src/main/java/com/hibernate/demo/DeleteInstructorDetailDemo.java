package com.hibernate.demo;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        try (Session session = factory.getCurrentSession()){
            //start a transaction
            session.beginTransaction();

            //get instructor detail object
            InstructorDetail instructorDetail = session.get(InstructorDetail.class,3);
            //print inDet
            System.out.println(instructorDetail);
            //print associated instructor
            System.out.println(instructorDetail.getInstructor());
            //delete instructor detail
            System.out.println("deleting instructorDetail " + instructorDetail);
            session.delete(instructorDetail);

            //REMOVE the associated object reference
            //break bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);
            //commit
            session.getTransaction().commit();

            System.out.println("Done");

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
