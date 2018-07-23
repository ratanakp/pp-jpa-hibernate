package com.example.ppjpahibernate.repositories;

import com.example.ppjpahibernate.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "student-api", collectionResourceRel = "data")
public interface StudentRepository extends JpaRepository<Student, Long> {

}
