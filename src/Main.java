// Program to learn about classes/objects

/*
Epochal Time Model:

Value: An immutable magnitude, quantity, number... or immutable composite thereof

State: Value of an identity at a moment in time

Identity: A putative entity we associate with a series of casually related values (states) over time

Time: Relative before/ after ordering of causal values

Update your design to fit the time model presented,
Identify what parts of your design (likely class/objects or functions) act as each of the terms defined (value, state, identity, process events, observers),
Ensure your solution returns the shortest set of moves, and
Discuss how this impacted your original design (improvements or parts made worse).
 */

public class Main {
    int a = 5;
    int b = 10;
    int c = a + b;
    int d = a * b;
}

class Second {

    public static void main(String[] args) {

        Main myFirstObject = new Main();
        Main mySecondObject = new Main();
        Main myThirdObject = new Main();
        Main myFourthObject = new Main();
        System.out.println("The value of object 1 is: " + myFirstObject.a);
        System.out.println("The value of object 2 is: " + mySecondObject.b);
        System.out.println("The value of object 3 is: " + myThirdObject.c);
        System.out.println("The value of object 4 is: " + myFourthObject.d);

    }
}

