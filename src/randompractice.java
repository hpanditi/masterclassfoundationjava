import org.w3c.dom.ls.LSOutput;

import static java.lang.System.out;

public class randompractice {

    static void myMethod() {

        out.println("Here is a method that can be called");

    }

    public static void main(String[] args) {

        myMethod();

        int b = 3;

        int d = 3;

        int c = 2;

        out.println("The number of brewers are: " + b);

        out.println("The number of drinkers are: " + d);

        out.println("The boat capacity is: " + c);

        out.println("--------------------------------------");

        do {

            b--;
            d--;
            out.print("B=");
            out.println(b);
            out.print("D=");
            out.println(d);

        }

        while (b > 0 && d > 0 && c >= 0 && c <= c);

        int k = 10;

        if (k > 15)

            out.printf("10 is less than 15");

        out.println("I am Not in if");

        // outer loop

        for (int i = 1; i <= 5; i++) {
            // codes
            out.println(i);
            // inner loop
            for (int j = 1; j <= 2; j++) {
                out.println(j);
                // codes


            }
        }

        out.println("-----------------------------------------");

        out.println("Hello there");
    }
}

