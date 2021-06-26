public class codeblocksandtheifthenelsecontrolstatements {

    public static void main(String[] args) {

        boolean gameOver = true;

        boolean gameOverTwo = true;

        int score = 400;

        int levelCompleted = 5;

        int bonus = 100;

        int scoreTwo = 10000;

        int levelCompletedTwo = 8;

        int bonusTwo = 200;

//        if (score < 5000 && score >1000) {
//
//            System.out.println("Your score was less than 5000 but greater than 1000");
//
//        } else if (score < 1000) {
//
//            System.out.println("Your score was less than 1000");
//
//        } else {
//
//            System.out.println("Got here");
//
//        }

        if(gameOver) {

            int finalScore = score + (levelCompleted * bonus);

            System.out.println("Your final score is " + finalScore);
        }

        if(gameOverTwo) {

            int finalScoreTwo = scoreTwo + (levelCompletedTwo * bonusTwo);

            System.out.println("Your second final score is " + finalScoreTwo);

        }
    }
}
