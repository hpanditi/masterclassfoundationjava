import java.util.Scanner; // Import the scanner class

public class userinputpractice {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in); // This creates a Scanner object

        System.out.println("Please enter the username: ");

        String userName = myObj.nextLine(); // Reads user input

        System.out.println("The username is: " + userName);

    }
}
