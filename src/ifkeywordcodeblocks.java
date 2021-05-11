// May 10, 2021

import java.sql.SQLOutput;

public class ifkeywordcodeblocks {

    public static void main(String[] args) {

        boolean gameOver = true;

        int score = 5000;

        int levelCompleted = 5;

        int bonus = 100;
/*
        if(score < 5000 && score > 1000) {

            System.out.println("Your score is less than 5000 but is greater than 1000");

        } else if (score < 1000) {
            System.out.println("Your score is less than 1000");
        } else {
            System.out.println("Got here");
        }
 */

        if(gameOver == true ) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score is " + finalScore);
        }

        boolean newGameOver = true;

        int newScore = 10000;

        int newLevelCompleted = 8;

        int newBonus = 200;

        if(newGameOver == true ) {
            int newFinalScore = newScore + (newLevelCompleted * newBonus);
            System.out.println("Your final score is " + newFinalScore);
        }

        }
    }

