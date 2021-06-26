public class ifthenelserecapone {

    public static void main(String[] args) {

        int score = 6000;

        if (score >= 5000) {

            System.out.println("Your score is >= 5000");

        } else if (score < 1000 && score >= 500) {

            System.out.println("Your score is < 1000 but >= 500");

        } else {

            System.out.println("Your score is < 500");
        }
    }
}
