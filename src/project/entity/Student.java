package project.entity;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String email;
    private String phone;
    private boolean sex;
    private Date bod;
    private int course_id;
    private String avatar;
    private boolean status;

    public Student(int id, String name, String email, String phone, boolean sex, Date bod, int course_id, String avatar, boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.bod = bod;
        this.course_id = course_id;
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
    public Date getBod() {
        return bod;
    }
    public int getCourse_id() {
        return course_id;
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
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
