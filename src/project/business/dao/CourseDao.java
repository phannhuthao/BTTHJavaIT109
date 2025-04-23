package project.business.dao;

import project.config.DatabaseConnect;
import project.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    public static List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        try {
            Connection con = DatabaseConnect.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Course";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Course course = new Course(id, name, description);
                list.add(course);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi truy xuất khóa học: " + e.getMessage());
        }
        return list;
    }

    public static boolean addCourse(Course course) {
        try {
            Connection con = DatabaseConnect.getConnection();
            String sql = "INSERT INTO Course (id, name, description) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, course.getId());
            ps.setString(2, course.getName());
            ps.setString(3, course.getDescription());
            int rows = ps.executeUpdate();
            con.close();
            return rows > 0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi khi thêm khóa học: " + e.getMessage());
            return false;
        }
    }

    public static boolean updateCourse(Course course) {
        try {
            Connection con = DatabaseConnect.getConnection();
            String sql = "UPDATE Course SET name = ?, description = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, course.getName());
            ps.setString(2, course.getDescription());
            ps.setInt(3, course.getId());
            int rows = ps.executeUpdate();
            con.close();
            return rows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Lỗi khi cập nhật khóa học: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteCourse(int id) {
        try {
            Connection con = DatabaseConnect.getConnection();
            String checkSql = "SELECT COUNT(*) FROM Student WHERE course_id = ?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setInt(1, id);
            ResultSet rs = checkPs.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Không thể xóa khóa học vì có sinh viên đang đăng ký.");
                return false;
            }

            String deleteSql = "DELETE FROM Course WHERE id = ?";
            PreparedStatement deletePs = con.prepareStatement(deleteSql);
            deletePs.setInt(1, id);
            int rows = deletePs.executeUpdate();

            checkPs.close();
            deletePs.close();
            con.close();
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa khóa học: " + e.getMessage());
            return false;
        }
    }
}
