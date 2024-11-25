package sample;

import java.util.*;

public class Main {
    static List<student> l = new ArrayList<>();
    public static void main(String[] args) {
        student s = new student();
        s.setDetails(89, "job");        
        l.add(s);       
        student ss = new student();
        //ss.setDetails(20, "hob"); 
        l.add(ss);
        for(student i : l){
            System.out.println(i.mark+" "+student.id+" "+i.name);
        }
    }
}
