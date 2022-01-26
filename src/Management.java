import model.Subject;
import model.Teacher;
import model.Teaching;
import service.ManagementService;

import java.util.Scanner;

public class Management implements ManagementService {

    int soLuongMh;
    int soLuongGv;

    private static Teacher[] teachers;
    private static Subject[] subjects;
    private Teaching[] teachings;

    static boolean check = true;

    @Override
    public void createTeacher() {
        System.out.println("Nhaạp số lượng gv: ");
        soLuongGv = new Scanner(System.in).nextInt();
        teachers = new Teacher[soLuongGv];
        for(int i=0; i < teachers.length;i++){
            Teacher teacher = new Teacher();
            teacher.inputInfo();
            teachers[i] = teacher;
        }
    }

    public void showInfoTeacher(){
        for(Teacher t: teachers){
            System.out.println(t);
        }
    }

    @Override
    public void createSubject() {
        System.out.println("Nhaạp số lượng môn học: ");
        soLuongMh = new Scanner(System.in).nextInt();
        subjects = new Subject[soLuongMh];
        for(int i=0; i < subjects.length;i++){
            Subject subject = new Subject();
            subject.inputInfoSubject();
            subjects[i] = subject;
        }
    }

    public void showInfoSubject(){
        for(Subject s: subjects){
            System.out.println(s);
        }
    }

    private static Subject getSubjectById(int subjectId) {
        for (Subject s : subjects) {
            if (s.getSubjectId() == subjectId) {
                return s;
            }
        }
        return null;
    }

    public static boolean checkExist(){
        return teachers != null && subjects != null && teachers.length != 0 && subjects.length != 0;
    }

    @Override
    public void management(){
        if(!checkExist()){
            System.out.println("Danh sách môn học hoặc gv rỗng");
            return;
        }

        teachings = new Teaching[soLuongGv];

        for (int i=0; i<teachings.length;i++){

            System.out.println("Kê khai cho gv " + teachers[i].getName());
            System.out.println("Nhập số môn dạy của "+teachers[i].getName());
            int soMon;
            do {
                soMon = new Scanner(System.in).nextInt();
                if(soMon <=0 || soMon > subjects.length) check = true;
            } while (!check);

            Subject[] listMonGvDay = new Subject[soMon];      // list này chứa các môn mà gv trên dạy
            int[] totalClassArray = new int[soMon];

            int tongSoTietCuaGv = 0;
            int tongSoLopCuaMon;
            int subjectId;

            for(int j=0;j<soMon;j++){
                System.out.print("Nhập id môn thứ " + (j + 1) + " mà giảng viên " + teachers[i].getName() + " dạy: ");
                subjectId = new Scanner(System.in).nextInt();

                // check xem neu subjectId đó tồn tại thì gán vào cho subject mới
                Subject subject = getSubjectById(subjectId);

                System.out.println("Nhập số lớp của môn thứ " + (j + 1) + " mà giảng viên " + teachers[i].getName() + " dạy:");
                do {
                      tongSoLopCuaMon = new Scanner(System.in).nextInt();
                    if (tongSoLopCuaMon <= 0 || tongSoLopCuaMon > 3) {
                        System.out.print("Một gv ko dạy quá 3 lớp! ");
                        check = false;
                    }
                } while (!check);

                // tổng số tiết của gv = số tiết môn * số lớp môn đó
                tongSoTietCuaGv =  subjects[j].getSoTiet() * tongSoLopCuaMon;
                if (tongSoTietCuaGv > 200) {
                    System.out.println("1 gv ko dạy quá 200 tiết!");
                    check = false;
                    break;
                } else check = true;

                float salary = subject.getMucKinhPhi() * tongSoTietCuaGv;
                teachers[j].setSalary(salary);

                listMonGvDay[j] = subject;
                totalClassArray[j] = tongSoLopCuaMon*subjects[j].getSoTiet();
                Teaching teaching = new Teaching(teachers[i],listMonGvDay, totalClassArray);
                teachings[i] = teaching;

            }

        } // end nhap thong tin
    }

    public void showManagement(){
        for (Teaching t: teachings){
            System.out.println(t);
        }
    }

    public void tinhLuong(){
        float sumSalary = 0;
        for(int i=0;i< teachers.length;i++){
            sumSalary += teachers[i].getSalary();
            System.out.println("Lương của gv "+teachers[i].getName()+" là: "+sumSalary);
        }
    }


}
