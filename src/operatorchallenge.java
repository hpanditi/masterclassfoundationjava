// May 9, 2021

public class operatorchallenge {
    public static void main(String[] args) {

        double variableOne = 20.00d;

        double variableTwo = 80.00d;

        double answerOne = (variableOne + variableTwo) * 100.00d;

        System.out.println("The value of variableOne is: " + variableOne);
        System.out.println("The value of variableTwo is: " + variableTwo);
        System.out.println("The value of answerOne is: " + answerOne);

        double remainderOne = answerOne % 40.00d;

        System.out.println("The value of remainderOne is: " + remainderOne);

        boolean valueVerification = true;

        if (remainderOne == 0) {
            System.out.println("True: the value of remainderOne is: " + remainderOne);
        }
        else {
            System.out.println("False: the value of remainderOne is: " + remainderOne);
        }
    }
}
