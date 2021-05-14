// May 14, 2021

public class methodstwo {

    // method

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score is " + highScore);

        calculateScore(gameOver, score, levelCompleted, bonus);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score is " + highScore);

    }

    public static void displayHighScorePosition(String playerName, int highScorePosition) {
        System.out.println(playerName + " managed to get into position "
                + highScorePosition + " on the high score table");
    }

    public static int calculateHighScorePosition(int playerScore) {
        if (playerScore > 1000) {
            return 1;
        } else if (playerScore > 500 && playerScore < 1000) {
            return 2;
        } else if (playerScore > 100 && playerScore < 500) {
            return 3;
        } else {
            return 4;
        }

        /*

        int highScorePosition = calculateHighScorePosition(1500);

        displayHighScorePosition("Tim", highScorePosition);


        int highScorePosition = calculateHighScorePosition(900);

        displayHighScorePosition("Bob", highScorePosition);

        int highScorePosition = calculateHighScorePosition(400);

        displayHighScorePosition("Percy", highScorePosition);

        int highScorePosition = calculateHighScorePosition(50);

        displayHighScorePosition("Gilbert", highScorePosition);

         */

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if(gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score is: " + finalScore);
            return finalScore;
        } else {
            return -1;
        }
    }
}

