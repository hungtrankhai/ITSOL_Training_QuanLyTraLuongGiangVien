package service;

import model.Level;
import model.Subject;
import model.TeachStatement;
import model.Teacher;

import java.util.Scanner;

public class TeachManagement implements ITeachManagement{
Scanner scanner = new Scanner(System.in);

    private Teacher[] teachers;
    private Subject[] subjects;
    private TeachStatement[] teachStatements;
    public int soLuongDanhSach ;

    public int soMon=0;
    public int soGV=0;

    Level level_enum;

    @Override
    public void inputInfoSubject() {
        System.out.println("Nhập tên môn:");
        String subjectName =scanner.nextLine();
        System.out.println("Nhập số tiết:");
        int soTiet =Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap so tiet ly thuyet:");
        int soTietLyThuyet = Integer.parseInt(scanner.nextLine());
        System.out.println("Muc kinh phi:");
        int mucKinhPhi = Integer.parseInt(scanner.nextLine());

        // tao moi 1 obj luu gia tri vao
        Subject subject = new Subject(subjectName, soTiet, soTietLyThuyet,mucKinhPhi);
        Subject[] tempSubjects =new Subject[soMon+1];
        // ???
        if(subjects!=null){
            System.arraycopy(subjects, 0, tempSubjects, 0, soMon);
        }
        subjects=tempSubjects;
        subjects[soMon]= subject;
        soMon++;

        for(int i=0;i<soMon;i++){
            System.out.println(subjects[i].toString());
        }
    }

    @Override
    public void inputInfoTeacher() {
        System.out.println("Nhập họ tên:");
        String teacherName =scanner.nextLine();
        System.out.println("Nhap dia chi:");
        String address =scanner.nextLine();
        System.out.println("Nhap so dien thoai:");
        String phoneNumber =scanner.nextLine();
        System.out.print("\n Nhập trình độ: \n 1: là GS-TS \n 2: là PGS-TS \n 3: là GIANGVIENCHINH \n 4: là THACSI");
        int nhapLevel = scanner.nextInt();

        do {
            switch (nhapLevel) {
                case 1:
                    level_enum = Level.GSTS;
                    break;
                case 2:
                    level_enum = Level.PGSTS;
                    break;
                case 3:
                    level_enum = Level.GIANGVIENCHINH;
                    break;
                case 4:
                    level_enum = Level.THACSI;
                    break;
            }
        }while (nhapLevel < 0 && nhapLevel >4);

        Teacher teacher = new Teacher(teacherName, address, phoneNumber, level_enum);

        Teacher[] temptTeacher = new Teacher[soGV+1];
        if(teachers!=null){
            System.arraycopy(teachers, 0, temptTeacher, 0, soGV);
        }

        teachers=temptTeacher;
        teachers[soGV]=teacher;
        soGV++;

        for(int i=0;i<soGV;i++){
            System.out.println(teachers[i].toString());
        }
    }

    //
    public Subject getSubject(int id){
        for (int i=0;i<soMon;i++){
            if(subjects[i].getSubjectId() == id){
                return subjects[i];
            }
        }
        return null;
    }

    public Teacher getTeacher(int id){
        for (int i=0;i<soGV;i++){
            if(teachers[i].getTeacherId() == id){
                return teachers[i];
            }
        }
        return null;
    }

    public boolean checkTrungId(int teacherId, int subjectId){
          for (int i=0; i<soLuongDanhSach;i++){
              if(teachStatements[i].getTeacher().getTeacherId() == teacherId && teachStatements[i].getSubject().getSubjectId() == subjectId){
                  return true;
              }
          }
          return false;
    }

    public int getSoTietDayCuaGiaoVien(int teacherId){
        int demSoTietDay=0;
        for (int i=0; i<soLuongDanhSach;i++){
            if(teachStatements[i].getTeacher().getTeacherId() == teacherId){
                demSoTietDay= demSoTietDay+ teachStatements[i].getSoLopGiangVienDay()*teachStatements[i].getSubject().getTongSoTiet();
            }
        }
        return demSoTietDay;
    }

    @Override
    public void management(){
        System.out.println("Nhập mã GV");
        int teacherId = scanner.nextInt();
        System.out.println("Nhập mã môn");
        int subjectId = scanner.nextInt();
        System.out.println("Nhập số lớp GV này dạy:");
        int soLopDay =scanner.nextInt();

        if(checkTrungId(teacherId, subjectId)){
            return;
        }
        if(soLopDay>3){
            System.out.println("GV ko dạy quá 3 lớp của 1 môn");
        }
        if(getSoTietDayCuaGiaoVien(teacherId)+soLopDay*getSubject(subjectId).getTongSoTiet() >200 ){

            System.out.println("GV ko dạy quá 200 tiết");
            return;
        }

        TeachStatement teachStatement = new TeachStatement(getSubject(subjectId), getTeacher(teacherId), soLopDay);
        TeachStatement[] tempTeacheStatement = new TeachStatement[soLuongDanhSach+1];
        if (teachStatements != null){
            System.arraycopy(teachStatements, 0, tempTeacheStatement, 0, soLuongDanhSach);
        }

        teachStatements[soLuongDanhSach] = teachStatement;
        soLuongDanhSach++;
        for(int i=0;i<soLuongDanhSach;i++){
            System.out.println(teachStatements[i].toString());
        }

    }

    @Override
    public void sortTeacherList() {

    }

    @Override
    public void sortSoTietGiangDay() {

    }
}
