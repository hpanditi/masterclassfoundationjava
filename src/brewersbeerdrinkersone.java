import java.util.Scanner;

public class brewersbeerdrinkersone {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of brewers: ");

        int brewers = input.nextInt();

        System.out.println("You entered " + brewers);

        System.out.print("Enter the number of drinkers: ");

        int drinkers = input.nextInt();

        System.out.println("You entered " + drinkers);

        System.out.println("Enter the boat capacity: ");

        int boatcapacity = input.nextInt();

        System.out.println("You entered " + boatcapacity);

        input.close();

        System.out.println("Hello");

        }
    }

