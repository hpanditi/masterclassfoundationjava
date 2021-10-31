import java.util.HashSet;

    public class brewersbeerdrinkersprofessorscode {

        private static int capacity = 3;
        private static int brewers = 4;
        private static int beerDrinkers = 4;
        private static HashSet<String> previousStates = new HashSet<String>();

        public static void main(String[] args) {

            solve(brewers, beerDrinkers, true, "");
        }

        private static boolean solve(int leftBrewers, int leftDrinkers, boolean leftSide, String solution) {

            // Too many drinkers on the left side
            if(leftBrewers != 0 && leftBrewers < leftDrinkers)
                return false;

            int rightBrewers = brewers - leftBrewers;
            int rightDrinkers = beerDrinkers - leftDrinkers;

            // Too many drinkers on right side
            if(rightBrewers != 0 && rightBrewers < rightDrinkers)
                return false;

            // We made it to our goal!
            if(leftBrewers == 0 && leftDrinkers == 0) {
                System.out.println(solution);
                return true;
            }

            // Repeated State
            String uniqueStateID = leftBrewers + "," + leftDrinkers + "," + leftSide;
            if(previousStates.contains(uniqueStateID))
                return false;

            previousStates.add(uniqueStateID);

            if(leftSide) {

                for(int moveDrinkers = 0; moveDrinkers <= leftDrinkers; moveDrinkers++) {
                    for(int moveBrewers = 0; moveBrewers <= leftBrewers; moveBrewers++) {

                        // Can't move zero people
                        if(moveDrinkers == 0 && moveBrewers == 0)
                            continue;

                        // Too many drinkers
                        if(moveBrewers != 0 && moveBrewers < moveDrinkers)
                            continue;

                        // Too many people
                        if(moveBrewers + moveDrinkers > capacity)
                            continue;

                        int newLeftBrewers = leftBrewers - moveBrewers;
                        int newLeftDrinkers = leftDrinkers - moveDrinkers;
                        String newSolution = new String(solution + "B=" + moveBrewers + ", D=" + moveDrinkers + "\n");

                        if(solve(newLeftBrewers, newLeftDrinkers, false, newSolution))
                            return true;
                    }
                }
            } else { // !leftSide

                for(int moveDrinkers = 0; moveDrinkers <= rightDrinkers; moveDrinkers++) {
                    for(int moveBrewers = 0; moveBrewers <= rightBrewers; moveBrewers++) {

                        // Can't move zero people
                        if(moveDrinkers == 0 && moveBrewers == 0)
                            continue;

                        // Too many drinkers
                        if(moveBrewers != 0 && moveBrewers < moveDrinkers)
                            continue;

                        // Too many people
                        if(moveBrewers + moveDrinkers > capacity)
                            continue;

                        int newLeftBrewers = leftBrewers + moveBrewers;
                        int newLeftDrinkers = leftDrinkers + moveDrinkers;
                        String newSolution = new String(solution + "B=" + moveBrewers + ", D=" + moveDrinkers + "\n");

                        if(solve(newLeftBrewers, newLeftDrinkers, true, newSolution))
                            return true;
                    }
                }
            }

            return false;
        }
    }

