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

        int boatCapacity = input.nextInt();

        System.out.println("You entered " + boatCapacity);

        input.close();

        boolean leftBoat = true;

        System.out.println("---------------------------");

    }
}

//    processPossibleMoves(brewers, drinkers, true, boatCapacity);

//    private static boolean processPossibleMoves(int leftBrewers, int leftDrinkers, boolean leftBoat, int boatCapacity) {

        // Check if valid state

        // Too many drinkers on the left side

//        if (leftBrewers > 0) {
//            if (leftDrinkers > leftBrewers)
//                System.out.println("This is not allowed!");
//            if (leftBrewers > leftDrinkers)
//                System.out.println("We're good to go!");
//        }

//        int rightDrinkers = drinkers - leftDrinkers;
//
//        int rightBrewers = brewers - leftBrewers;

        // Too many drinkers on the right side

//        if (rightBrewers > 0) {
//            if (rightDrinkers > rightBrewers)
//                System.out.println("This is not allowed!");
//            if (rightBrewers > rightDrinkers)
//                System.out.println("We're good to go!");
//        }

        // Large boat capacity

        // Too many drinkers on the left boat

//      if (leftBoatCapacity > 0) {
//            if (leftDrinkers > leftBrewers)
//                System.out.println("This is not allowed!");
//            if (leftBrewers > leftDrinkers)
//                System.out.println("We're good to go!");
//        }

//      int rightBoat = leftBoat - (leftDrinkers + leftBrewers)

        // Too many drinkers on the right boat

//       if (rightBoatCapacity > 0) {
//            if (rightDrinkers > rightBrewers)
//                System.out.println("This is not allowed!");
//            if (rightBrewers > rightDrinkers)
//                System.out.println("We're good to go!");
//        }

        // Check if repeated state

        // Check if goal (i.e., leftBrewers == 0 && leftDrinkers == 0)

        // Code here should list all possible moves
//
//        if (leftBrewers == 0 && leftDrinkers == 0) {
//
//            System.out.println("Great! We made it!");
//
//      }
//
        // For all possible moves:

        // apply move to newLeftBrewers, newLeftDrinkers, newLeftBoat

        //processPossibleMoves(newLeftBrewers, newLeftDrinkers, newLeftBoat, boatCapacity)

        // Code block to be executed
        // Code here should apply the move to transition brewers and drinkers from the left to the right side


//        if (leftBoat) {
//
//            for (leftBrewers = 0; leftBrewers <= brewers; leftBrewers++;) {
//
//                // inner loop
//
//                  System.out.println("B = " + leftBrewers);
//
//                  System.out.println("D = " + leftDrinkers);
//
//                for (newLeftDrinkers = 0; newLeftDrinkers <= drinkers; newLeftDrinkers++) {
//
//                    System.out.println("B = " + newLeftBrewers);
//
//                    System.out.println("D = " + newLeftDrinkers);
//
//                }
//            }
//
//        } else { //(rightBoat)

            // Code here should be the same as the code above but adopted to the right side
//
//            for (rightBrewers = 0; rightBrewers <= leftBrewers; rightBrewers++) {
//
//                // inner loop

//                    System.out.println("B = " + rightBrewers);
//
//                    System.out.println("D = " + rightDrinkers);
//
//                for (newRightDrinkers = 0; newRightDrinkers <= leftDrinkers; newRightDrinkers++) {
//
//                    System.out.println("B = " + newRightBrewers);
//
//                    System.out.println("D = " + newRightDrinkers);
//
//                }
//            }
//        }
//     }

//        return false;

//    }
//}


