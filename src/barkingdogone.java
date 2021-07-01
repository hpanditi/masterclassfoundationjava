public class barkingdogone {

    public static boolean shouldWakeUp (boolean dogBarking, int hourOfDay) {

        if (hourOfDay < 0 || hourOfDay > 23) {

            return false;
        }

        if (dogBarking == true && hourOfDay < 8 || hourOfDay > 22) {

            return true;

        } else {

            return false;
        }

    }

}
