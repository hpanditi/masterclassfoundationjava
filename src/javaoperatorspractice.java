public class javaoperatorspractice {

    public static void main(String[] args) {

        int x = 100 + 50;

        System.out.println("The value of x is: " + x);

        int sum1 = 100 + 50;

        int sum2 = sum1 + 250;

        int sum3 = sum2 + sum2;

        System.out.println("The value of sum1 is: " + sum1);

        System.out.println("The value of sum2 is: " + sum2);

        System.out.println("The value of sum3 is: " + sum3);

        System.out.println("The product of 10 and 5 is: " + (10 * 5));

        // The code below will contain practice of Java concepts

        System.out.println("Hello World");

        String name = "John";

        System.out.println(name);

        int myNum = 15;

        System.out.println("The value of my number is: " + myNum);

        String carName = "Volvo";

        System.out.println("My car is a: " + carName);

        byte myByteNumber = 100;

        System.out.println("The value of myByteNumber is: " + myByteNumber);

        short myShortNumber = 5000;

        System.out.println("The value of myShortNumber is: " + myShortNumber);

        long myLongNumber = 15000000L;

        System.out.println("The value of myLongNumber is: " + myLongNumber);

        float myFloatNumber = 5.75f;

        System.out.println("The value of myFloatNumber is: " + myFloatNumber);

        double myDoubleNumber = 19.99d;

        System.out.println("The value of myDoubleNumber is: " + myDoubleNumber);

        boolean isJavaFun = true;

        boolean isFishTasty = false;

        System.out.println(isJavaFun);

        System.out.println(isFishTasty);

        int a = 0;

        do {
            System.out.println("The values for a are: " + a);
            a++;
        }

        while (a < 5);

        for (int b = 0; b < 10; b++) {

            System.out.println("The values for b are: " + b);

        }

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        for (int i = 0; i < cars.length; i ++) {

            System.out.println("The brand names of the cars are: " + cars[i]);
        }

        String[] colors = {"Blue", "Yellow", "Green", "Purple"};

        for (String c : colors) {
            System.out.println("The value of the colors are: " + c);
        }
    }
}
