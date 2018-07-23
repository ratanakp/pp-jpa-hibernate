package com.example.ppjpahibernate.models;


import javax.persistence.*;

@Entity(name = "Student_Entity")
@Table(name = "tb_student")

@NamedQuery(name = "getAllStudentNamedQuery", query = "select se from Student_Entity se order by id desc")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_gen")
    @SequenceGenerator(name = "my_gen", initialValue = 10, sequenceName = "stu_seq")
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(10)")
    private String gender;

    @Column(columnDefinition = "decimal(10,2)")
    private Double score;

    @OneToOne
    private Role role;

    public Student() {
    }

    public Student(String name, String gender, Double score) {
        this.name = name;
        this.gender = gender;
        this.score = score;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                '}';
    }
}
