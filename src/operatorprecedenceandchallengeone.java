public class operatorprecedenceandchallengeone {

    public static void main(String[] args) {

        double variableOne = 20.00d;

        double variableTwo = 80.00d;

        double answerOne = (variableOne + variableTwo) * 100.00d;

        System.out.println("The value for answerOne is: " + answerOne);

        double variableRemainder = answerOne % 40.00d;

        System.out.println("The value of variableRemainder is: " + variableRemainder);

        boolean variableBoolean = (variableRemainder == 0) ? true : false;

        System.out.println("The value of variableBoolean is" + variableBoolean);

        if (!variableBoolean) {

            System.out.println("Got some remainder");
        }
    }
}
