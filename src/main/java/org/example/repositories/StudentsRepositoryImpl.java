package org.example.repositories;

import org.example.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class StudentsRepositoryImpl implements StudentsRepository {
    @Override
    public List<Student> findAll() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("SELECT * FROM Student").addEntity(Student.class);
        List<Student> students = query.list();
        return students;
    }


    @Override
    public void save(Student newStudent) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(newStudent);
        session.flush();
    }


    @Override
    public Student getById(Long id) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session.get(Student.class, id);
    }

}
