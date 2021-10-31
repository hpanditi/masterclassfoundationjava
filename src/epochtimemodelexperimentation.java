/*
Epochal Time Model:

Value: An immutable magnitude, quantity, number... or immutable composite thereof

State: Value of an identity at a moment in time

Identity: A putative entity we associate with a series of casually related values (states) over time

Time: Relative before/ after ordering of causal values

Update your design to fit the time model presented,
Identify what parts of your design (likely class/objects or functions) act as each of the terms defined (value, state, identity, process events, observers),
Ensure your solution returns the shortest set of moves, and
Discuss how this impacted your original design (improvements or parts made worse).
 */
import java.text.SimpleDateFormat;
import java.time.LocalDate; //imports the LocalDate class
import java.time.LocalTime; // imports the LocalTime class
import java.time.LocalDateTime; //imports the LocalDateTime class
import java.time.format.DateTimeFormatter; // Formats Date and Time to remove the 'T' and nanoseconds
import java.util.Date;

public class epochtimemodelexperimentation {

    public static void main(String[] args) {

        LocalDate myFirstObject = LocalDate.now();

        LocalTime mySecondObject = LocalTime.now();

        LocalDateTime myThirdObject = LocalDateTime.now();

        DateTimeFormatter myFormattedDateObject = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

        String myFourthObject = myFormattedDateObject.format(myThirdObject);

        System.out.println("The current date is: " + myFirstObject);

        System.out.println();

        System.out.println("The current time is: " + mySecondObject);

        System.out.println();

        System.out.println("The current date and time is: " + myThirdObject);

        System.out.println();

        System.out.println("The formatted date is: " + myFourthObject);

        System.out.println();

        String greetings = "Hello World!";

        System.out.println(greetings);

        System.out.println();

        Date date = new Date();

        System.out.printf("%1$s %2$tB %2$td, %2$tY", "Current date: " , date);

        System.out.println("\n");

        Date d = new Date();

        SimpleDateFormat ft = new SimpleDateFormat("E MM-dd-yyyy 'at' hh:mm:ss a zzz");

        System.out.println("Current Date and Time: " + ft.format(d));

        System.out.println();

        Date d2 = new Date();

        String str = String.format("Current Date and Time: %tc", d2);

        System.out.println(str);

        System.out.println();

        String epochString = "1549499024";

        long epoch = Long.parseLong(epochString);

        System.out.println("Convert Epoch " + epoch + " to date: ");

        Date d1= new Date(epoch * 1000);

        System.out.println(d1);

        System.out.println();

        // Starting with a long number epoch

        long epoch2 = 1550544173;

        System.out.println("Converting Epoch by starting with long number:");

        System.out.println(new Date(epoch2 * 1000));

        System.out.println();

        Date currentDate = new Date();

        long epochOne = currentDate.getTime() / 1000;

        System.out.println("Epoch: " + epochOne);

        // Using a string format to format to unix timestamp

        System.out.println();

        Date dateOne = new Date();

        String strOne = String.format("Epoch using string format: %ts", dateOne);

        System.out.printf(strOne);

    }
}

