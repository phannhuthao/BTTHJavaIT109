package project.presentation;

import project.config.DatabaseConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableStudent {
    public static void createTable() {
        try (Connection con = DatabaseConnect.getConnection()) {
            if (con != null) {
                Statement st = con.createStatement();
                String sqlStudent = "CREATE TABLE IF NOT EXISTS Student (" +
                        "id INT PRIMARY KEY," +
                        "name VARCHAR(200) NOT NULL," +
                        "email TEXT NOT NULL," +
                        "phone VARCHAR(10) NOT NULL," +
                        "sex BIT NOT NULL," +
                        "bod DATE NOT NULL," +
                        "course_id INT," +
                        "avatar TEXT," +
                        "status BIT NOT NULL," +
                        "FOREIGN KEY (course_id) REFERENCES Course(id)" +
                        ")";
                st.executeUpdate(sqlStudent);
                System.out.println("Tạo bảng Student thành công (nếu chưa tồn tại).");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Lỗi khi tạo bảng Student: " + e.getMessage());
        }
    }
}
