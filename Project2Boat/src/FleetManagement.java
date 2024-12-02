import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
   Program: FleetManagementSystem

   This program manages a fleet of boats, allowing users to add, remove, and track expenses
   for each boat in the fleet. The fleet data can be loaded from a CSV file or a serialized file
   and can be saved back to a serialized file.
*/

public class FleetManagement {

    /*
       Enum BoatType

       Defines the two types of boats: Sailing and Power.
    */
    enum BoatType {
        SAILING, POWER
    }

    /*
       Class Boat

       Represents a boat with properties such as name, year, make/model, length, purchase price,
       expenses, and type. Includes methods for adding expenses and checking if additional expenses
       can be added.
    */
    static class Boat {
        String name;
        int year;
        String makeModel;
        double length;
        double purchasePrice;
        double expenses;
        BoatType type;

        // Constructor to initialize boat properties
        Boat(String name, int year, String makeModel, double length, double purchasePrice, BoatType type) {
            this.name = name;
            this.year = year;
            this.makeModel = makeModel;
            this.length = length;
            this.purchasePrice = purchasePrice;
            this.expenses = 0; // Initialize expenses to zero
            this.type = type;
        }

        // Check if the boat can spend the specified amount
        boolean canSpend(double amount) {
            return (this.expenses + amount) <= this.purchasePrice;
        }

        // Add an expense to the boat
        void addExpense(double amount) {
            this.expenses += amount;
        }

        // Override toString method to provide a formatted boat description
        @Override
        public String toString() {
            return String.format("%-8s %-20s %-12d %-15s %-4.0f' : Paid $%-8.2f : Spent $%-8.2f",
                    type, name, year, makeModel, length, purchasePrice, expenses);
        }
    }

    // Constants for file paths
    private static final String FLEET_DATA_FILE = "FleetData.db";
    private static final String CSV_FILE = "FleetData.csv";

    // List to hold the fleet of boats
    private static List<Boat> fleet = new ArrayList<>();

    /*
       Main method to run the Fleet Management System.
       It handles the user interface and input processing.
    */
    public static void main(String[] args) {
        // Load fleet data based on input file or default to serialized file

        fleet.add(new Boat("Big Brother", 2019, "Mako", 20, 12989.56, BoatType.POWER));
        fleet.add(new Boat("Moon Glow", 1973, "Bristol", 30, 5500.00, BoatType.SAILING));
        fleet.add(new Boat("Osita", 1988, "Tartan", 40, 11500.07, BoatType.SAILING));
        fleet.add(new Boat("Rescue II", 2016, "Zodiac", 12, 8900.00, BoatType.POWER));


        // Scanner for reading user input
        final Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Fleet Management System");
        System.out.println("--------------------------------------");

        // Main loop for user interaction
        while (true) {
            System.out.print("\n(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
            char choice = keyboard.next().toLowerCase().charAt(0);
            keyboard.nextLine(); // Consume the newline character

            switch (choice) {
                case 'p':
                    printFleetReport();
                    break;
                case 'a':
                    addBoat(keyboard);
                    break;
                case 'r':
                    removeBoat(keyboard);
                    break;
                case 'e':
                    addExpense(keyboard);
                    break;
                case 'x':
                    saveToSerializedFile();
                    System.out.println("\nExiting the Fleet Management System");
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void saveToSerializedFile() {
    }

    private static void loadFromSerializedFile() {

    }

    /*
       Load fleet data from a CSV file.
       Each line in the CSV is expected to have the format:
       BoatType,name,year,makeModel,length,purchasePrice
    */
    private static void loadFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 6) continue;  // Skip invalid lines

                BoatType type = BoatType.valueOf(parts[0].toUpperCase());
                String name = parts[1];
                int year = Integer.parseInt(parts[2]);
                String makeModel = parts[3];
                double length = Double.parseDouble(parts[4]);
                double purchasePrice = Double.parseDouble(parts[5]);

                Boat boat = new Boat(name, year, makeModel, length, purchasePrice, type);
                fleet.add(boat);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    /*
       Load fleet data from a serialized file.
       If no data is found, start with an empty fleet.
    */

    private static void loadFromSerializedFile(String fileName) throws IOException, ClassNotFoundException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FLEET_DATA_FILE))) {
            Object loaded = in.readObject();
            if (loaded instanceof List) {
                fleet = (List<Boat>) loaded;
            } else {
                fleet = new ArrayList<>();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found, starting fresh.");
        }
    }
    private static void saveToSerializedFile(String fileName) throws IOException, ClassNotFoundException{
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FLEET_DATA_FILE))) {
            out.writeObject(fleet);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    /*
       Print a report of the fleet including each boat's details and the total paid/spent.
    */
    private static void printFleetReport() {
        System.out.println("\nFleet report:");
        double totalPaid = 0;
        double totalSpent = 0;

        for (Boat boat : fleet) {
            System.out.println(boat);
            totalPaid += boat.purchasePrice;
            totalSpent += boat.expenses;
        }

        System.out.printf("Total                                             : Paid $%-8.2f : Spent $%-8.2f\n", totalPaid, totalSpent);
    }

    /*
       Add a new boat to the fleet from user input in CSV format.
    */
    private static void addBoat(Scanner scanner) {
        System.out.print("Please enter the new boat CSV data (type,name,year,makeModel,length,purchasePrice): ");
        String boatData = scanner.nextLine();
        String[] parts = boatData.split(",");
        if (parts.length != 6) {
            System.out.println("Invalid format, please try again.");
            return;
        }

        BoatType type = BoatType.valueOf(parts[0].toUpperCase());
        String name = parts[1];
        int year = Integer.parseInt(parts[2]);
        String makeModel = parts[3];
        double length = Double.parseDouble(parts[4]);
        double purchasePrice = Double.parseDouble(parts[5]);

        Boat boat = new Boat(name, year, makeModel, length, purchasePrice, type);
        fleet.add(boat);
        System.out.println("Boat added successfully.");
    }

    /*
       Remove a boat from the fleet by its name.
    */
    private static void removeBoat(Scanner scanner) {
        System.out.print("Which boat do you want to remove?           : ");
        String nameToRemove = scanner.nextLine();
        boolean removed = fleet.removeIf(boat -> boat.name.equalsIgnoreCase(nameToRemove));

        if (removed) {
            System.out.println("Boat removed successfully.");
        } else {
            System.out.println("Cannot find boat " + nameToRemove);
        }
    }

    /*
       Add an expense to a specific boat, checking if it can afford the expense.
    */
    private static void addExpense(Scanner scanner) {
        System.out.print("Which boat do you want to spend on?         : ");
        String nameToSpend = scanner.nextLine();

        Boat boat = fleet.stream()
                .filter(b -> b.name.equalsIgnoreCase(nameToSpend))
                .findFirst()
                .orElse(null);

        if (boat == null) {
            System.out.println("Cannot find boat " + nameToSpend);
            return;
        }

        System.out.print("How much do you want to spend?              : ");
        double expenseAmount = scanner.nextDouble();

        if (boat.canSpend(expenseAmount)) {
            boat.addExpense(expenseAmount);
            System.out.printf("Expense authorized, $%.2f spent.\n", expenseAmount);
        } else {
            double remaining = boat.purchasePrice - boat.expenses;
            System.out.printf("Expense not permitted, only $%.2f left to spend.\n", remaining);
        }
    }
}
