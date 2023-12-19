package Hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "studentcourses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addCourse(Course course) {
        if (Objects.isNull(courses)) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }
}