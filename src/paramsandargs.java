// May 19, 2021

public class paramsandargs {
    static void myMethod(String fname, int age) {
        System.out.println(fname + " is " + age);
    }

    public static void main(String[] args) {
        myMethod("Michael", 45);
        myMethod("Dwight", 42);
        myMethod("Jim", 31);
    }
}

