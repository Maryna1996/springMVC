package Hibernate.DAO;

import Hibernate.exeption.CourseNotFoundException;
import Hibernate.model.Course;
import lombok.AllArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@AllArgsConstructor
public class CourseDao implements DAO<Course> {

    private final Session session;

    @Override
    public Course findById(long id) {
        Course course = session.get(Course.class, id);
        if (course == null) {
            throw new CourseNotFoundException("Course with id doesn't exist!");
        }
        return course;
    }

    @Override
    public List<Course> findAll() {
        return session.createQuery("FROM Course", Course.class).getResultList();
    }

    @Override
    public void add(Course entity) {
        session.persist(entity);
    }

    @Override
    public void updateById(Course entity, long id) {
        Course courseToUpdate = session.get(Course.class, id);
        if (courseToUpdate == null) {
            throw new CourseNotFoundException("Course with id doesn't exist!");
        }
        courseToUpdate.setName(entity.getName());
    }

    @Override
    public void deleteById(long id) {
        Course courseToDelete = session.get(Course.class, id);
        if (courseToDelete == null) {
            throw new CourseNotFoundException("Course with id doesn't exist!");
        }
        session.remove(courseToDelete);
    }
}
