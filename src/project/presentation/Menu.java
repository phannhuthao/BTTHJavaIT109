package project.presentation;

import project.business.CourseBusiness;
import project.business.StudentBusiness;
import project.entity.Course;
import project.entity.Student;
import project.validate.CourseValidator;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void run() throws SQLException, ClassNotFoundException {
        TableCourse.createTable();
        TableStudent.createTable();
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
                    showInfoCourse();
                    break;
                case 2:
                    addNewCourse(sc);
                    break;
                case 3:
                    updateCourse(sc);
                    break;
                case 4:
                    deleteCourse(sc);
                    break;
                case 5:
                    showInfoStudent();
                    break;
                case 6:
                    addNewStudent(sc);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public static void showInfoCourse() {
        List<Course> courses = CourseBusiness.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("Không có khóa học nào.");
            return;
        }
        System.out.println("|---------------------------------------DANH SÁCH KHÓA HỌC------------------------------------|");
        String leftAlignFormat = "| %-5s | %-30s | %-50s |%n";
        System.out.format("|-------|--------------------------------|----------------------------------------------------|%n");
        System.out.format("| ID    | Tên Khóa Học                   | Mô Tả                                              |%n");
        System.out.format("|-------|--------------------------------|----------------------------------------------------|%n");

        // In từng dòng dữ liệu
        for (Course course : courses) {
            System.out.format(leftAlignFormat, course.getId(), course.getName(), course.getDescription());
        }
        System.out.format("|-------|--------------------------------|----------------------------------------------------|%n");
        System.out.println(" ");
    }


    public static void addNewCourse(Scanner sc) {
        sc.nextLine();
        try {
            System.out.println("========== THÊM DANH SÁCH KHÓA HỌC ==========");
            System.out.print("Nhập ID khóa học: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập tên khóa học: ");
            String name = sc.nextLine();

            System.out.print("Nhập mô tả khóa học: ");
            String description = sc.nextLine();

            // Kiểm tra dữ liệu nhập vào
            if (!CourseValidator.isValidId(id)) {
                System.out.println("ID không hợp lệ. Vui lòng nhập số nguyên dương.");
                return;
            }

            if (!CourseValidator.isValidName(name)) {
                System.out.println("Tên khóa học không hợp lệ. Không được chứa ký tự đặc biệt.");
                return;
            }

            if (!CourseValidator.isValidDescription(description)) {
                System.out.println("Mô tả không được để trống.");
                return;
            }

            Course course = new Course(id, name, description);
            boolean success = CourseBusiness.addCourse(course);
            if (success) {
                System.out.println("Thêm khóa học thành công");
            } else {
                System.out.println("Thêm khóa học thất bại (có thể ID đã tồn tại)");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID phải là số nguyên.");
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
    }

    // cập nhật khóa học
    public static void updateCourse(Scanner sc) {
        sc.nextLine();
        try {
            System.out.println("========== CẬP NHẬT DANH SÁCH KHÓA HỌC ==========");

            System.out.print("Nhập ID khóa học cần sửa: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập tên khóa học mới: ");
            String name = sc.nextLine();

            System.out.print("Nhập mô tả khóa học mới: ");
            String description = sc.nextLine();

            // Validate
            if (!CourseValidator.isValidId(id)) {
                System.out.println("ID không hợp lệ. Vui lòng nhập số nguyên dương.");
                return;
            }

            if (!CourseValidator.isValidName(name)) {
                System.out.println("Tên khóa học không hợp lệ. Không được chứa ký tự đặc biệt.");
                return;
            }

            if (!CourseValidator.isValidDescription(description)) {
                System.out.println("Mô tả không được để trống.");
                return;
            }

            Course course = new Course(id, name, description);
            boolean success = CourseBusiness.updateCourse(course);
            if (success) {
                System.out.println("Cập nhật khóa học thành công.");
            } else {
                System.out.println("Không tìm thấy khóa học với ID này hoặc cập nhật thất bại.");
            }

        } catch (NumberFormatException e) {
            System.out.println("ID phải là số nguyên.");
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
    }

    // xóa khóa học
    public static void deleteCourse(Scanner sc) {
        sc.nextLine();
        try {
            System.out.print("Nhập ID khóa học cần xóa: ");
            int id = Integer.parseInt(sc.nextLine());

            if (!CourseValidator.isValidId(id)) {
                System.out.println("ID không hợp lệ. Vui lòng nhập số nguyên dương.");
                return;
            }

            boolean success = CourseBusiness.deleteCourse(id);
            if (success) {
                System.out.println("Xóa khóa học thành công.");
            } else {
                System.out.println("Không thể xóa khóa học (có thể khóa học không tồn tại hoặc đang có sinh viên đăng ký).");
            }

        } catch (NumberFormatException e) {
            System.out.println("ID phải là số nguyên.");
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
    }

    public static void showInfoStudent() {
        List<Student> students = StudentBusiness.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("Không có sinh viên nào");
            return;
        }

        System.out.println("|--------------------------------------------------------------------DANH SÁCH SINH VIÊN------------------------------------------------------------------|");
        String headerFormat = "| %-5s | %-20s | %-25s | %-12s | %-6s | %-10s | %-10s | %-20s | %-10s |%n";
        String rowFormat =    "| %-5d | %-20s | %-25s | %-12s | %-6s | %-10s | %-10d | %-20s | %-10s |%n";

        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------------------------------|%n");
        System.out.format(headerFormat, "ID", "Tên Sinh Viên", "Email", "Phone", "Giới tính", "Ngày sinh", "Khóa học", "Avatar", "Trạng thái");
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------------------------------|%n");

        for (Student student : students) {
            String sexStr = student.getSex() ? "Nam" : "Nữ";
            String statusStr = student.getStatus() ? "Đang học" : "Nghỉ học";

            System.out.format(rowFormat,
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getPhone(),
                    sexStr,
                    student.getBod().toString(),
                    student.getCourseId(),
                    student.getAvatar(),
                    statusStr
            );
        }

        System.out.format("----------------------------------------------------------------------------------------------------------------------------------------------------------|%n");
    }

    public static void addNewStudent(Scanner sc) {
        sc.nextLine();
        try {
            System.out.println("========== THÊM DANH SÁCH SINH VIÊN ==========");

            System.out.print("Nhập ID sinh viên: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập tên sinh viên: ");
            String name = sc.nextLine();

            System.out.print("Nhập email: ");
            String email = sc.nextLine();

            System.out.print("Nhập SĐT: ");
            String phone = sc.nextLine();

            System.out.print("Nhập giới tính (true = Nam, false = Nữ): ");
            boolean sex = Boolean.parseBoolean(sc.nextLine());

            System.out.print("Nhập ngày sinh (yyyy-mm-dd): ");
            Date bod = java.sql.Date.valueOf(sc.nextLine());

            System.out.print("Nhập id khóa học của sinh viên: ");
            int courseId = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập avatar: ");
            String avatar = sc.nextLine();

            System.out.print("Nhập trạng thái (true = Đang học, false = Nghỉ học): ");
            boolean status = Boolean.parseBoolean(sc.nextLine());

            Student student = new Student(id, name, email, phone, sex, bod, courseId, avatar, status);
            boolean success = StudentBusiness.addStudent(student);
            if (success) {
                System.out.println("Thêm sinh viên thành công.");
            } else {
                System.out.println("Thêm sinh viên thất bại.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập sinh viên: " + e.getMessage());
        }
    }


}
