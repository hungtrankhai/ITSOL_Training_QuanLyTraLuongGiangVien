package model;

public class Subject {
    private int subjectId;
    private String subjectName;
    private int tongSoTiet,soTietLyThuyet,mucKinhPhi;
    private static int id=100;

    public Subject(){}


    public Subject(String subjectName, int tongSoTiet, int soTietLyThuyet, int mucKinhPhi) {
        this.subjectId = id++;
        this.tongSoTiet = tongSoTiet;
        this.soTietLyThuyet = soTietLyThuyet;
        this.mucKinhPhi = mucKinhPhi;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public int getMucKinhPhi() {
        return mucKinhPhi;
    }

    public void setMucKinhPhi(int mucKinhPhi) {
        this.mucKinhPhi = mucKinhPhi;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Subject.id = id;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", tongSoTiet=" + tongSoTiet +
                ", soTietLyThuyet=" + soTietLyThuyet +
                ", mucKinhPhi=" + mucKinhPhi +
                '}';
    }
}
