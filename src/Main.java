import service.TeachManagement;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            TeachManagement teachManagement = new TeachManagement();

            int choose;
            do{
                showMenu();
                choose = scanner.nextInt();

                switch(choose){
                    case 1:
                        System.out.println("Nhập số lượng môn học: ");
                        int soLuongMh = scanner.nextInt();
                        for (int i=0; i <soLuongMh;i++){
                            teachManagement.inputInfoSubject();
                        }
                        teachManagement.showInfoSubject();

                        break;

                    case 2:
                        System.out.println("Nhập số lượng GV: ");
                        int soLuongGv = scanner.nextInt();
                        for (int i=0; i <soLuongGv;i++){
                            teachManagement.inputInfoTeacher();
                        }

                        teachManagement.showInfoTeacher();

                        break;

                    case 3:

                        teachManagement.management();
                        break;

                    case 4:

                        break;
                }
            }while( choose != 4);
        }


        static void showMenu(){
            System.out.println("1. Nhập ds môn học \n2. Nhập ds giáo viên \n3. Xem management \n4. Thoat");
            System.out.println("__Bạn cần làm gì ?___");
        }

}
