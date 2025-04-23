package project.business.dao;

import project.config.DatabaseConnect;
import project.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDao {

    // Lấy danh sách tất cả sinh viên
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Connection con = DatabaseConnect.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Student";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                boolean sex = rs.getBoolean("sex");
                Date bod = rs.getDate("bod");
                int courseId = rs.getInt("course_id");
                String avatar = rs.getString("avatar");
                boolean status = rs.getBoolean("status");

                Student student = new Student(id, name, email, phone, sex, bod, courseId, avatar, status);
                list.add(student);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi truy xuất sinh viên: " + e.getMessage());
        }
        return list;
    }

    // Thêm sinh viên mới
    public boolean addStudent(Student student) {
        try {
            Connection con = DatabaseConnect.getConnection();
            String sql = "INSERT INTO Student (id, name, email, phone, sex, bod, course_id, avatar, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setBoolean(5, student.getSex());
            ps.setDate(6, new java.sql.Date(student.getBod().getTime()));
            ps.setInt(7, student.getCourseId());
            ps.setString(8, student.getAvatar());
            ps.setBoolean(9, student.getStatus());

            int rowsInserted = ps.executeUpdate();
            ps.close();
            con.close();
            return rowsInserted > 0;
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm sinh viên: " + e.getMessage());
            return false;
        }
    }

}
