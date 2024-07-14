package StudentManagementSystem;

import java.util.*;
import java.util.Scanner;

public class StudentDAO {
    int id, age;
    String name, email, grade, password;

    void addStudent(int x) {
        Scanner s = new Scanner(System.in);
        List<Student> stud = new ArrayList<>();


        for (int i = 0; i < 2; i++) {
            System.out.println("enter student details");

            id = s.nextInt();
            name = s.nextLine();
            s.nextLine();
            age = s.nextInt();
            grade = s.next();
            email = s.next();
            password = s.next();
            stud.add(i,new Student(id, name, age, grade, email, password));
            s.nextLine();
            System.out.println("continue?... yes or no?");
            if (s.next().equals("no")) {
                break;
            }
        }
        System.out.println();
        System.out.println(stud.get(0));

    }

    void deleteStudent(Student st) {

    }

    void updateStudent(Student st) {

    }

    void getStudent(int id) {

    }
}
