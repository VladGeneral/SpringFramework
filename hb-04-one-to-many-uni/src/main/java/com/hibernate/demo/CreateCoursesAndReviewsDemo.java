package com.hibernate.demo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {

            //start a transaction
            session.beginTransaction();

            //create a course
            Course course = new Course("Pacman");

            //and some reviews
            course.addReview(new Review("great review1"));
            course.addReview(new Review("grgreat review2"));
            course.addReview(new Review("bad reviewreview3"));
            // save the course
            System.out.println("saving course");
            System.out.println(course);
            System.out.println(course.getReviews());
            session.save(course);

            //commit
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
