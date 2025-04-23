package project.entity;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String email;
    private String phone;
    private boolean sex;
    private Date bod;
    private int courseId;
    private String avatar;
    private boolean status;

    public Student(int id, String name, String email, String phone, boolean sex, Date bod, int courseId, String avatar, boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.bod = bod;
        this.courseId = courseId;
        this.avatar = avatar;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public boolean getSex() {
        return sex;
    }
    public java.sql.Date getBod() {
        return (java.sql.Date) bod;
    }
    public int getCourseId() {
        return courseId;
    }
    public String getAvatar() {
        return avatar;
    }
    public boolean getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public void setBod(Date bod) {
        this.bod = bod;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
