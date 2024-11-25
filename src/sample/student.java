package sample;

public class student {
    int mark;
    String name;
    static int id = 0;

    student() {
        this.mark = 90;
        this.name = "harish";
        id = id + 1;
    }

    void setDetails(int mark, String name) {
        this.mark = mark;
        this.name = name;
    }

}
