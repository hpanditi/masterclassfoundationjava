public class primitivetypeschallengeone {

    public static void main(String[] args) {

        byte myFirstByte = 25;

        short myFirstShort = 50;

        int myFirstInteger = 75;

        long myFirstLong = (50000L) + (10L * (myFirstByte + myFirstShort + myFirstInteger));

        System.out.println(myFirstLong);
    }
}
