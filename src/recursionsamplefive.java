public class recursionsamplefive {

    static int count = 0;

    static int factorial(int n) {

        if(n == 1)

            return 1;

        else

            return(n * factorial(n-1));

    }

    static void h() {

        count++;

        if (count <= 5) {

            System.out.println("Hello: " + count);

            h();

        }
    }

    public static void main(String[] args) {

        h();

        System.out.println("------------------------------------");

        System.out.println("Factorial of n is: " + factorial(10));

    }
}
