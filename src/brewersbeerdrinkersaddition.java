/*
The next step would be to add the existing function that solves the problem into your loop (where you have your print statement) and modify it to:

take the depth variable as a maxDepth parameter,
include a currentDepth parameter that you would initialize with 0, and
increment the currentDepth variable each time you recursively call the function that solves the problem and add a condition to ensure you don't continue past the maxDepth.
 */

// Existing function that solves the problem

/*
public static void main(String[] args) {
        solve(brewers, beerDrinkers, true, "");
}

if(solve(newLeftBrewers, newLeftDrinkers, false, newSolution))
    return true;

if(solve(newLeftBrewers, newLeftDrinkers, true, newSolution))
    return true;
 */

// Alternate ideas

/*
(int maxDepth)
 */

public class brewersbeerdrinkersaddition {

    static void myMethod() {
        System.out.println("This is text from myMethod");
    }

    static void maxDepthMethod(int depth, int currentDepth) {
    }

    public static void main(String[] args) {

        myMethod();

        maxDepthMethod(0, 0);

        int maxDepth = 10;

        for (int currentDepth = 0; currentDepth <= maxDepth; currentDepth++) {
            if (currentDepth > maxDepth) {
                System.out.println("Error");
            } else {
                System.out.println("The values for current depth are: " + currentDepth);
            }
        }
    }
}


