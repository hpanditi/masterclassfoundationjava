/*
Epochal Time Model:

Value: An immutable magnitude, quantity, number... or immutable composite thereof

State: Value of an identity at a moment in time

Identity: A putative entity we associate with a series of casually related values (states) over time

Time: Relative before/ after ordering of causal values

Update your design to fit the time model presented,
Identify what parts of your design (likely class/objects or functions) act as each of the terms defined (value, state, identity, process events, observers),
Ensure your solution returns the shortest set of moves, and
Discuss how this impacted your original design (improvements or parts made worse).
 */

/*
The next step would be to add the existing function that solves the problem into your loop (where you have your print statement) and modify it to:

take the depth variable as a maxDepth parameter, (Is maxDepth a method that needs to be written?)
include a currentDepth parameter that you would initialize with 0, and (int currentDepth = 0)
increment the currentDepth variable each time you recursively call the function that solves the problem and add a condition to ensure you don't continue past the maxDepth.

(Add a for loop. Add an if condition to ensure that it does not go past the maxDepth. (if currentDepth > maxDepth, return false))
 */

/*
The depth needs to be a parameter that is given to the existing solve function, as mentioned in the previous e-mail.
Any check to ensure you don't go past the maxdepth(maxDepth?) needs to be in the existing solution code I provided as part of the assignment.
Right now, you still haven't integrated that existing solution code into your loop. That would be the next necessary step.
 */

import java.text.SimpleDateFormat;
import java.time.LocalDate; //imports the LocalDate class
import java.time.LocalTime; // imports the LocalTime class
import java.time.LocalDateTime; //imports the LocalDateTime class
import java.time.format.DateTimeFormatter; // Formats Date and Time to remove the 'T' and nanoseconds
import java.util.Date;

import java.util.HashSet;

public class brewersbeerdrinkersprofessorcodeexperimentation {

    // These are the values of the program

    private static int capacity = 3;
    private static int brewers = 4;
    private static int beerDrinkers = 4;

    // The code below is the identity

    private static HashSet<String> previousStates = new HashSet<String>();

    public static void main(String[] args) {
        solve(brewers, beerDrinkers, true, "", 0);
    }

    private static boolean solve(int leftBrewers, int leftDrinkers, boolean leftSide, String solution, int depth) {

        // Initialization of the depth variable

        int maxDepth = 5;

        // Include a currentDepth parameter that you would initialize with 0

        for (int currentDepth = 0; currentDepth <= maxDepth; currentDepth++) {
            if (currentDepth > maxDepth) {
                return false;
            } else {
                System.out.println("The values for current depth are: " + currentDepth);
            }

            // The code below contains the observers/perception

            // Too many drinkers on the left side
            if (leftBrewers != 0 && leftBrewers < leftDrinkers)
                return false;

            // The code below is the process events

            int rightBrewers = brewers - leftBrewers;
            int rightDrinkers = beerDrinkers - leftDrinkers;

            // Too many drinkers on right side
            if (rightBrewers != 0 && rightBrewers < rightDrinkers)
                return false;

            // The code below contains the state

            // We made it to our goal!
            if (leftBrewers == 0 && leftDrinkers == 0) {
                System.out.println(solution);
                return true;
            }

            // Repeated State
            String uniqueStateID = leftBrewers + "," + leftDrinkers + "," + leftSide;
            if (previousStates.contains(uniqueStateID))
                return false;

            previousStates.add(uniqueStateID);

            if (leftSide) {

                for (int moveDrinkers = 0; moveDrinkers <= leftDrinkers; moveDrinkers++) {
                    for (int moveBrewers = 0; moveBrewers <= leftBrewers; moveBrewers++) {

                        // Can't move zero people
                        if (moveDrinkers == 0 && moveBrewers == 0)
                            continue;

                        // Too many drinkers
                        if (moveBrewers != 0 && moveBrewers < moveDrinkers)
                            continue;

                        // Too many people
                        if (moveBrewers + moveDrinkers > capacity)
                            continue;

                        // The code below is the process events

                        int newLeftBrewers = leftBrewers - moveBrewers;
                        int newLeftDrinkers = leftDrinkers - moveDrinkers;

                        // The code below is the identity

                        String newSolution = new String(solution + "B=" + moveBrewers + ", D=" + moveDrinkers + "\n");

                        // The code below is the state

                        if (solve(newLeftBrewers, newLeftDrinkers, false, newSolution, 1))
                            return true;
                    }
                }
            } else { // !leftSide

                for (int moveDrinkers = 0; moveDrinkers <= rightDrinkers; moveDrinkers++) {
                    for (int moveBrewers = 0; moveBrewers <= rightBrewers; moveBrewers++) {

                        // Can't move zero people
                        if (moveDrinkers == 0 && moveBrewers == 0)
                            continue;

                        // Too many drinkers
                        if (moveBrewers != 0 && moveBrewers < moveDrinkers)
                            continue;

                        // Too many people
                        if (moveBrewers + moveDrinkers > capacity)
                            continue;

                        // The code below are the process events

                        int newLeftBrewers = leftBrewers + moveBrewers;
                        int newLeftDrinkers = leftDrinkers + moveDrinkers;

                        // The code below is the identity

                        String newSolution = new String(solution + "B=" + moveBrewers + ", D=" + moveDrinkers + "\n");

                        // The code below is the state

                        if (solve(newLeftBrewers, newLeftDrinkers, true, newSolution, 0))
                            return true;
                    }
                }
            }
            return false;
        }
        return leftSide;
    }
}

