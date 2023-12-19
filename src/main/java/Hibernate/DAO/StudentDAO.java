package Hibernate.DAO;

import Hibernate.exeption.StudentNotFoundException;
import Hibernate.model.Student;
import lombok.AllArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@AllArgsConstructor
public class StudentDAO implements DAO<Student> {

    private final Session session;

    @Override
    public Student findById(long id) {
        Student student = session.get(Student.class, id);
        if (student == null) {
            throw new StudentNotFoundException("Student with id doesn't exist!");
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return session.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public void add(Student entity) {
        session.persist(entity);
    }

    @Override
    public void updateById(Student entity, long id) {
        Student studentToUpdate = session.get(Student.class, id);
        if (studentToUpdate == null) {
            throw new StudentNotFoundException("Student with id doesn't exist!");
        }
        studentToUpdate.setEmail(entity.getEmail());
        studentToUpdate.setName(entity.getName());
    }

    @Override
    public void deleteById(long id) {
        Student studentToDelete = session.get(Student.class, id);
        if (studentToDelete == null) {
            throw new StudentNotFoundException("Student with id doesn't exist!");
        }
        session.remove(studentToDelete);
    }
}
