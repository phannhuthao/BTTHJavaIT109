package project.validate;

import java.util.regex.Pattern;

public class CourseValidator {
    private static final String NAME_REGEX = "^[a-zA-ZÀ-Ỹà-ỹ0-9\\s]+$";

    // Validate ID: chỉ được là số nguyên dương
    public static boolean isValidId(int id) {
        return id > 0;
    }

     //Validate tên khóa học: không được rỗng, không chứa ký tự đặc biệt. Chấp nhận chữ có dấu, số và khoảng trắng
    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        return Pattern.matches(NAME_REGEX, name);
    }

     //Validate mô tả: không được rỗng
    public static boolean isValidDescription(String description) {
        return description != null && !description.trim().isEmpty();
    }
}
