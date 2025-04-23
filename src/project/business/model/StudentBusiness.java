package project.business.model;

import project.business.dao.StudentDao;
import project.entity.Student;

import java.util.List;

public class StudentBusiness {
    private static StudentDao studentDao = new StudentDao();

    public static List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public static boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }
}
