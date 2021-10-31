public class looppractice {

    public static void main(String[] args) {

        int x = 1;

        //Exit when x becomes greater than 4

        while (x<=5) {

            System.out.println("Value of x: " + x);

            // Increment the value of x for
            // next iteration

            x++;

        }

        System.out.println("-----------------------------"); {
        }

        // for loop begins when x = 2
        // and runs till x <= 4

        for (int y = 2; y <= 4; y++)
            System.out.println("Value of y: " + y);

        System.out.println("----------------------------"); {
        }

        String array[] = {"Ron", "Harry", "Hermione"};

        //enhanced for loop

        for (String z:array) {

            System.out.println(z);
        }

        System.out.println("--------------------------"); {
        }

        int a = 25;

        do {

            System.out.println("Value of a: " + a);

            a++;
        }

        while (a <= 30);
    }
}
