package project.business.model;

import project.business.dao.CourseDao;
import project.entity.Course;

import java.util.List;

public class CourseBusiness {
    public static List<Course> getAllCourses() {
        return CourseDao.getAllCourses();
    }

    public static boolean addCourse(Course course) {
        return CourseDao.addCourse(course);
    }

    public static boolean updateCourse(Course course) {
        return CourseDao.updateCourse(course);
    }

    public static boolean deleteCourse(int id) {
        return CourseDao.deleteCourse(id);
    }
}
