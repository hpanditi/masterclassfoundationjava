public class BreakLoopDemo {

    public static void main(String[] args) {

        // Initially loop is set to run from 0-9

        for (int i = 0; i < 15; i++) {

            // terminate loop when i is 5.

            if (i == 14)

                break;

            System.out.println("i: " + i);

        }

        System.out.println("Loop complete.");

        }
    }

