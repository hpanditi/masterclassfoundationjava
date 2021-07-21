public class sumthreeandfivechallenge {

    public static void main(String[] args) {

        System.out.println("Hi");

        int count = 0;
        int sum = 0;

        for(int i = 1; i <= 1000; i++) {

            if ((i % 3 ==0) && (i % 5 == 0)) {

                count++;

                sum += i;

                System.out.println("Found number = " + i);
            }

            if(count == 5) {

                break;

            }
        }

        System.out.println("Sum = " + sum);

    }
}
