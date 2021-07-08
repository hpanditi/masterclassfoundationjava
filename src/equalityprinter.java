public class equalityprinter {

    public static void printEqual(int num1, int num2, int num3) {

        if(num1 < 0 || num2 < 0 || num3 < 0) {

            System.out.println("This is an invalid value");

        } else if (num1 == num2 && num1 == num3) {

            System.out.println("All numbers are equal");

        } else if(num1 != num2 && num2 != num3 && num1 != num3) {

            System.out.println("All numbers are different");

        } else {

            System.out.println("Numbers are neither equal or different");
        }

    }

}
