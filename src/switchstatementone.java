public class switchstatementone {

    public static void main(String[] args) {

        /*

        int value = 2;
        if(value == 1) {
            System.out.println("Value was 1");
        } else if (value == 2) {
            System.out.println("Value was 2");
        } else {
            System.out.println("Was not 1 or 2");
        }

         */

        int switchValue = 6;

        switch(switchValue) {

            case 1:
                System.out.println("Value was 1");
                break;

            case 2:
                System.out.println("Value was 2");
                break;

            case 3: case 4: case 5:
                System.out.println("Was a 3, or a 4, or a 5");
                System.out.println("Actually it was a " + switchValue);
                break;

            default:
                System.out.println("Was not 1, 2, 3, 4, or 5");
            //    break;
        }

        char myLetter = 'A';

        switch(myLetter) {

            case 'A':
                System.out.println("Value is A");
                break;

            case 'B':
                System.out.println("Value is B");
                break;

            case 'C':
                System.out.println("Value is C");
                break;

            case 'D':
                System.out.println("Value is D");
                break;

            case 'E':
                System.out.println("Value is E");
                break;

            default:
                System.out.println("Was not A, B, C, D or E");
                break;
        }

        String month = "JANUARy";

        switch(month.toLowerCase()) {

            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
        }
    }
}
