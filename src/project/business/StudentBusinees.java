package project.business;

import project.config.DatabaseConnect;
import project.entity.Course;
import project.entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentBusinees {
    public static List<Student> getAllStudents(){
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
                int course_id = rs.getInt("course_id");
                String avatar = rs.getString("avatar");
                boolean status = rs.getBoolean("status");

                Student student = new Student(id, name, email, phone, sex, bod, course_id, avatar, status);
                list.add(student);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi truy xuất sinh viên: " + e.getMessage());
        }
        return list;
    }
}
