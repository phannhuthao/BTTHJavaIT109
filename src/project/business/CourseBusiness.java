package project.business;

import project.entity.Course;
import project.config.DatabaseConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseBusiness {

    public static void showInfoCourse() {
        try {
            Connection con = DatabaseConnect.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Course";
            ResultSet rs = st.executeQuery(sql);
            System.out.println("========== DANH SÁCH KHÓA HỌC ==========");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                Course course = new Course(id, name, description);
                System.out.println("ID: " + course.getId());
                System.out.println("Tên: " + course.getName());
                System.out.println("Mô tả: " + course.getDescription());
                System.out.println("-----------------------------------");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Không có khóa học nào trong danh sách: " + e.getMessage());
        }
    }

    public static void addCourse() {

    }
}
