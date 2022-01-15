package model;

public class TeachStatement {
    private Subject subject;
    private Teacher teacher;
    private int soLopGiangVienDay;

    public TeachStatement(){

    }

    public TeachStatement(Subject subject, Teacher teacher, int soLopGiangVienDay) {
        this.subject = subject;
        this.teacher = teacher;
        this.soLopGiangVienDay = soLopGiangVienDay;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getSoLopGiangVienDay() {
        return soLopGiangVienDay;
    }

    public void setSoLopGiangVienDay(int soLopGiangVienDay) {
        this.soLopGiangVienDay = soLopGiangVienDay;
    }

    @Override
    public String toString() {
        return "TeachStatement{" +
                "subject=" + subject +
                ", teacher=" + teacher +
                ", soLopGiangVienDay=" + soLopGiangVienDay +
                '}';
    }
}
