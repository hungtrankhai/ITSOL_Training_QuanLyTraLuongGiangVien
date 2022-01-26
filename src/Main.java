import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Management management = new Management();


            int choose;
            do{
                showMenu();
                choose = scanner.nextInt();

                switch(choose){
                    case 1:
                        management.createSubject();
                        management.showInfoSubject();
                        break;

                    case 2:
                        management.createTeacher();
                        management.showInfoTeacher();

                        break;

                    case 3:
                        management.management();
                        management.showManagement();

                        break;

                    case 4:

                        break;

                    case 5:
                        management.tinhLuong();
                        break;
                }
            }while( choose != 5);
        }


        static void showMenu(){
            System.out.println("1. Nhập ds môn học \n2. Nhập ds giáo viên \n3. Xem management \n4. Sort \n5.Bảng lương giáo viên.");
            System.out.println("__Bạn cần làm gì ?___");
        }

}
