package Hibernate;

import Hibernate.DAO.CourseDao;
import Hibernate.DAO.StudentDAO;
import Hibernate.model.Course;
import Hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try (HibernateSession hibernateSession = new HibernateSession()) {
            SessionFactory sessionFactory = hibernateSession.getSessionFactory();
            try (Session session = sessionFactory.getCurrentSession()) {
                session.beginTransaction();

                StudentDAO studentDAO = new StudentDAO(session);
                CourseDao courseDao = new CourseDao(session);

                long studentId = 1;
                Student student = studentDAO.findById(studentId);
                logger.info("Found student: {}", student);

                Course course = courseDao.findById(2);
                studentDAO.findById(2).addCourse(course);

                Student studentToAdd = studentDAO.findById(3);
                courseDao.findById(2).addStudent(studentToAdd);

                // [Student(id=3, name=Maryna, email=maryalex.m96@gmail.com)]
                logger.info("Students in course: {}", courseDao.findById(2).getStudents());
                // [Course(courseId=4, name=Innovative entrepreneurship and startup project management), Course(courseId=3, name=Anti-crisis management of the enterprise)]
                logger.info("Courses for student 2: {}", studentDAO.findById(2).getCourses());
                // [Course(courseId=2, name=Anti-crisis management of the enterprise)]
                logger.info("Courses for student 3: {}", studentDAO.findById(3).getCourses());

                session.getTransaction().commit();
            }
        } catch (Exception e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }
}
