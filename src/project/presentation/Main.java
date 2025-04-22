package project.presentation;

import project.business.CourseBusiness;
import project.config.DatabaseConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("|-------------------MENU-------------------|");
            System.out.println("|1. Hiển thị danh sách khóa học            |");
            System.out.println("|2. Thêm mới khóa học                      |");
            System.out.println("|3. Cập nhật khóa học                      |");
            System.out.println("|4. Xóa khóa học                           |");
            System.out.println("|5. Hiển thị danh sách sinh viên           |");
            System.out.println("|6. Thêm mới sinh viên                     |");
            System.out.println("|7. Cập nhật thông tin sinh viên           |");
            System.out.println("|8. Xóa thông tin sinh viên                |");
            System.out.println("|9. Tìm kiếm sinh viên theo tên            |");
            System.out.println("|-------------------====-------------------|");
            System.out.println();
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    CourseBusiness.showInfoCourse();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

            Connection con = DatabaseConnect.getConnection();
            if (con != null) {
                System.out.println("Kết nối thành công");
                try {
                    Statement st = con.createStatement();
                    String sqlCourse = "CREATE TABLE IF NOT EXISTS Course (" +
                            "id INT PRIMARY KEY," +
                            "name VARCHAR(100) NOT NULL," +
                            "description TEXT NOT NULL" +
                            ")";
                    st.executeUpdate(sqlCourse);

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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
