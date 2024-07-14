package StudentManagementSystem;

import java.util.Scanner;

public class Mains extends StudentDAO {
    static Student st = new Student(1, "hi", 23, "B", "dsjfsfj", "hi");

    public static void main(String[] args) {
        Mains m = new Mains();
        m.addStudent(9);
        
    }
}
