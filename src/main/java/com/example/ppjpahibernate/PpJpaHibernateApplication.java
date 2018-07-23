package com.example.ppjpahibernate;

import com.example.ppjpahibernate.models.Student;
import com.example.ppjpahibernate.repositories.StudentRepository;
import com.example.ppjpahibernate.services.StudentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class PpJpaHibernateApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(PpJpaHibernateApplication.class, args);
    }




//    private StudentService studentService;


    private StudentRepository studentRepository;

    public PpJpaHibernateApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //    public PpJpaHibernateApplication(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Student student = new Student("name", "male", 30.5);
        //studentService.save(student);

        Student student1 = new Student("a name1", "female", 10.5);
        Student student2 = new Student("som nak", "female", 12.5);
        //studentService.save(student1);


       /* System.out.println(studentService.findOne(10L));

        System.out.println(studentService.getAll());

        System.out.println(studentService.getOne(10L));*/


       this.studentRepository.save(student);
        this.studentRepository.save(student1);
        this.studentRepository.save(student2);


        System.out.println(this.studentRepository.count());

        System.out.println(this.studentRepository.findAll());

        System.out.println(this.studentRepository.findById(10L));


    }
}
