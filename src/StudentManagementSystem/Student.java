package StudentManagementSystem;

public class Student {
    private int rollno;
    private String name;
    private int mark1, mark2, mark3, mark4;
    private String username, password;

    public Student(int rollno, String name, int mark1, int mark2, int mark3, int mark4) {
        this.rollno = rollno;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    static Student st = new Student(45, "hh", 1, 2, 3, 4),
            stt = new Student(34, "djsjf", 3, 5, 6, 7);
}
