package model;

public class Teacher {
    private int teacherId;
    private String teacherName, address, phoneNumber;
    private Level level;

    private static int id=100;

    public Teacher(){

    }

    public Teacher(String teacherName, String address, String phoneNumber, Level level) {
        this.teacherId = id++;
        this.teacherName = teacherName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.level = level;
    }



    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public String getLevel() {
//        return level;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Teacher.id = id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
