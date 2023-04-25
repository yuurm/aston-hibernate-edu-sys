package org.example.repositories;

import lombok.RequiredArgsConstructor;
import org.example.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import static org.example.util.HibernateUtil.getSession;


@Repository
public class CoursesRepositoryImpl implements CoursesRepository {

    @Override
    public Course getById(Long id) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session.get(Course.class, id);
    }


}
