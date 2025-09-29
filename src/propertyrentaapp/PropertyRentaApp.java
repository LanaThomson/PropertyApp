package propertyrentaapp;

import java.util.Scanner;

public class PropertyRentaApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Properties theMainPropertyApp = new Properties();

        int differentChoices;

        do {
            System.out.println("\nPROPERTY RENTALS - 2025");
            System.out.println("**************************************");
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Enter new property.");
            System.out.println("(2) Search for property.");
            System.out.println("(3) Update property.");
            System.out.println("(4) Delete a property.");
            System.out.println("(5) Print property report - 2025.");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter your choice: ");

            try {
                differentChoices = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                differentChoices = -1;
            }//Written with the help of W3Schools(2025)

            switch (differentChoices) {
                case 1:
                    theMainPropertyApp.EnterProperty();
                    break;
                case 2:
                    theMainPropertyApp.SearchProperty();
                    break;
                case 3:
                    theMainPropertyApp.UpdateProperty();
                    break;
                case 4:
                    theMainPropertyApp.DeleteProperty();
                    break;
                case 5:
                    theMainPropertyApp.PropertyRentalReport();
                    break;
                case 6:
                    theMainPropertyApp.ExitApplication();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }//Written with the help of Recordings(2025)

        } while (differentChoices != 6);
    }
}