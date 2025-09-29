package propertyrentaapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Properties {
    private ArrayList<PropertyModel> propertyList = new ArrayList<>();//Written with the help of Recordings(2025)
    private Scanner scanner = new Scanner(System.in);

    public ArrayList<PropertyModel> getPropertyList() {
        return propertyList;
    }

    public void EnterProperty() {
        System.out.println("\nENTER A NEW PROPERTY FOR RENTAL");
        System.out.println("*************************");

        PropertyModel newProperty = new PropertyModel();

        System.out.print("Enter the property id: ");
        newProperty.PropertyId = scanner.nextLine();

        System.out.print("Enter the property address: ");
        newProperty.PropertyAddress = scanner.nextLine();

        newProperty.PropertyRentalAmount = propertyAmountValidation();

        System.out.print("Enter the property agent: ");
        newProperty.AgentName = scanner.nextLine();

        propertyList.add(newProperty);
        System.out.println("New property processed successfully!!!");

        ReturnToMenuPrompt();
    }

    public void SearchProperty() {
        System.out.print("Enter the property id to search: ");
        String theID = scanner.nextLine();

        PropertyModel property = searchPropertyById(theID);

        if (property != null) {
            System.out.println("-----------------------------------------");
            System.out.println("PROPERTY ID: " + property.PropertyId);
            System.out.println("PROPERTY ADDRESS: " + property.PropertyAddress);
            System.out.println("PROPERTY RENTAL AMOUNT: R" + property.PropertyRentalAmount);
            System.out.println("PROPERTY AGENT: " + property.AgentName);
            System.out.println("-----------------------------------------");
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("Rental property with ID: " + theID + " was not found!");
            System.out.println("-----------------------------------------");
        }

        ReturnToMenuPrompt();
    }

    public void UpdateProperty() {
        System.out.print("Enter the property id to update: ");
        String theID = scanner.nextLine();

        PropertyModel property = searchPropertyById(theID);

        if (property != null) {
            System.out.print("Enter the new property address: ");
            property.PropertyAddress = scanner.nextLine();

            System.out.print("Enter the new property rental amount: ");
            property.PropertyRentalAmount = propertyAmountValidation();

            System.out.print("Enter the new property agent: ");
            property.AgentName = scanner.nextLine();

            System.out.println("Property updated successfully!");
        } else {
            System.out.println("Property with ID " + theID + " was not found.");
        }

        ReturnToMenuPrompt();
    }

    public void DeleteProperty() {
        System.out.print("Enter the property id to delete: ");
        String theID = scanner.nextLine();

        PropertyModel property = searchPropertyById(theID);

        if (property != null) {
            System.out.print("Are you sure you want to delete property " + theID + "? Yes (y) to confirm: ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                propertyList.remove(property);
                System.out.println("Property with ID " + theID + " WAS deleted!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Property with ID " + theID + " was not found.");
        }//Written with the help of OpenAI(2025)

        ReturnToMenuPrompt();
    }

    public void PropertyRentalReport() {
        if (propertyList.isEmpty()) {
            System.out.println("No properties available to display.");
        } else {
            int propertyNumber = 1;
            for (PropertyModel property : propertyList) {
                System.out.println("Property " + propertyNumber);
                System.out.println("-----------------------------------------");
                System.out.println("PROPERTY ID: " + property.PropertyId);
                System.out.println("PROPERTY ADDRESS: " + property.PropertyAddress);
                System.out.println("PROPERTY RENTAL AMOUNT: R" + property.PropertyRentalAmount);
                System.out.println("PROPERTY AGENT: " + property.AgentName);
                System.out.println("-----------------------------------------");
                propertyNumber++;
            }//Written with the help of Recordings(2025)
        }

        ReturnToMenuPrompt();
    }

    public void ExitApplication() {
        System.out.println("Exiting application... Goodbye!");
        System.exit(0);
    }

    public void ReturnToMenuPrompt() {
        System.out.println("\nEnter (1) to launch menu or any other key to exit:");
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            ExitApplication();
        }//Written with the help of W3Schools(2025)
    }


    public PropertyModel searchPropertyById(String id) {
        for (PropertyModel property : propertyList) {
            if (property.PropertyId.equals(id)) {
                return property;
            }
        }
        return null;
    }

    public boolean updatePropertyById(String id, String address, double rentalAmount, String agentName) {
        PropertyModel property = searchPropertyById(id);
        if (property != null) {
            property.PropertyAddress = address;
            property.PropertyRentalAmount = rentalAmount;
            property.AgentName = agentName;
            return true;
        }
        return false;
    }

    public boolean deletePropertyById(String id) {
        PropertyModel property = searchPropertyById(id);
        if (property != null) {
            propertyList.remove(property);
            return true;
        }
        return false;
    }

    public double propertyAmountValidationTest(double theAmount) {
        if (theAmount < 1500) {
            throw new IllegalArgumentException("Amount must be >= 1500");
        }
        return theAmount;
    }//Written with the help of Recordings(2025)

    public double propertyAmountValidation() {
        double theAmount = 0;
        boolean valid = false;
        boolean firstAttempt = true;

        while (!valid) {
            if (firstAttempt) {
                System.out.print("Enter the property rental price per month: ");
                firstAttempt = false;
            } else {
                System.out.println("Please re-enter the property rental amount >>");
            }

            try {
                theAmount = Double.parseDouble(scanner.nextLine());
                if (theAmount >= 1500) {
                    valid = true;
                } else {
                    System.out.println("You have entered an invalid amount! Must be >= 1500.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numbers only.");
            }
        }// Written with the help of OpenAI(2025)

        return theAmount;
    }
}