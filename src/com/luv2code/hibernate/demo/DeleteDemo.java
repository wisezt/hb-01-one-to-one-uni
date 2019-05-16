package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {

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


            // associate the object

            // start a transaction
            theSession.beginTransaction();

            // save the student object
            theSession.createQuery("delete from Instructor where id = 1").executeUpdate();

            // commit transaction
            theSession.getTransaction().commit();

            theSession.close();


        } finally {
            theSessionFactory.close();
        }

    }

}
