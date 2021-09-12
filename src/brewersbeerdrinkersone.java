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

        System.out.println("---------------------------");

        processPossibleMoves(brewers, drinkers, true, boatcapacity);

    }

    private static void processPossibleMoves(int leftBrewers, int leftDrinkers, boolean leftBoat, int boatcapacity) {

        // Check if valid state

        if (leftBrewers > 0 && leftDrinkers > 0) {

            System.out.println("We need to move more brewers and drinkers to the other side!");

        }

        if (boatcapacity > 0 && boatcapacity < boatcapacity) {

            System.out.println("We can move people!");

        }



        // Check if repeated state

        // Note: Not sure what to write here

        // Check if goal (i.e., leftBrewers == 0 && leftDrinkers == 0)

        if (leftBrewers == 0 && leftDrinkers == 0) {

            System.out.println("B=0, D=0");
            System.out.println("Looks like we are done!");

        }

        // For all possible moves:
        // apply move to newLeftBrewers, newLeftDrinkers, newLeftBoat
        // call processPossibleMoves(newLeftBrewers, newLeftDrinkers, newLeftBoat, boatcapacity)

        do {

            // Code block to be executed
            // Code here should apply the move to transition brewers and drinkers from the left to the right side

            // System.out.println("B= "+ leftBrewers + ",D= " + leftDrinkers);

        }

        while (leftBrewers > 0 && leftDrinkers > 0);

    }
}
