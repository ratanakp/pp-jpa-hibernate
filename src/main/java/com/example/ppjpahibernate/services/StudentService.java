package com.example.ppjpahibernate.services;

import com.example.ppjpahibernate.models.Student;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    public StudentService() {
    }


    public void save(Student student) {
        entityManager.persist(student);
    }


    public Student findOne(Long id) {
        return entityManager.find(Student.class, id);
    }


    public Student getOne(Long id) {


        TypedQuery<Student> query = entityManager.createQuery("select se from Student_Entity se where id=:id", Student.class);

        query.setParameter("id", id);

        return query.getSingleResult();
    }



    public List<Student> getAll() {

        /*return entityManager.createQuery
                ("select se from Student_Entity " +
                        "se order by id desc", Student.class)
                .getResultList();*/


        return entityManager.createNamedQuery("getAllStudentNamedQuery").getResultList();
    }


}
