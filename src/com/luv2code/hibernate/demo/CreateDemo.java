package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory theSessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session theSession = theSessionFactory.getCurrentSession();

        try {

            // Create the object
            Instructor tempInstructor = new Instructor("Ting001", "Zheng", "Ting@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.ting.com", "love you");
            tempInstructor.setInstructorDetail(tempInstructorDetail);


            // associate the object

            // start a transaction
            theSession.beginTransaction();
            // save the student object
            theSession.save(tempInstructor);
            System.out.println("Saving the Instructor ...");
            // commit transaction
            theSession.getTransaction().commit();

            theSession.close();


        } finally {
            theSessionFactory.close();
        }

    }

}
