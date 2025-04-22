package project.presentation;

import project.config.DatabaseConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCourse {
    public static void createTable() {
        try (Connection con = DatabaseConnect.getConnection()) {
            if (con != null) {
                Statement st = con.createStatement();
                String sqlCourse = "CREATE TABLE IF NOT EXISTS Course (" +
                        "id INT PRIMARY KEY," +
                        "name VARCHAR(100) NOT NULL," +
                        "description TEXT NOT NULL" +
                        ")";
                st.executeUpdate(sqlCourse);
                System.out.println("Tạo bảng Course thành công (nếu chưa tồn tại).");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Lỗi khi tạo bảng Course: " + e.getMessage());
        }
    }
}
