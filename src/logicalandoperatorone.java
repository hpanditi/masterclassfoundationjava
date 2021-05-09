// May 9, 2021

public class logicalandoperatorone {
    public static void main(String[] args) {

        int topScore = 80;
        if (topScore < 100) {
            System.out.println("Congratulations. You got the high score!");
        }

        int secondTopScore = 95;
        if ((topScore > secondTopScore) && (topScore < 100)) {
            System.out.println("Greater than second top score and less than 100");
        }

        if ((topScore > 90) || (secondTopScore <= 90)) {
            System.out.println("Either or both of the conditions are true");
        }

        int newValue = 50;
        if (newValue == 50) {
            System.out.println("This is an error");
        }

        boolean isCar = false;
        if (isCar == true) {
            System.out.println("This is not supposed to happen");
        }

        boolean wasCar = isCar ? true : false;
        isCar = true;
        if (wasCar) {
            System.out.println("wasCar is true");
        }
    }
}
