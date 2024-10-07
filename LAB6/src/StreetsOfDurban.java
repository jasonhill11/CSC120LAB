import java.util.Scanner;

public class StreetsOfDurban {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main (String[] args) {
//Variables====================================================================================
        int numHouses;
        int numPeople;
        int totalAge = 0;
        int ageSum = 0;

//Input houses in Durban=========================================================================
        System.out.println("How many houses in the street?   : ");
        numHouses = keyboard.nextInt();

        int [] houseNumbers = new int[numHouses];

        System.out.println("");

        for (int row = 0; row < numHouses; row++){
            System.out.print("What is the next house number?   : ");
            houseNumbers[row] = keyboard.nextInt();
        }

        int houseAges[][] = new int[numHouses][];

//Input individuals in house==============================================================================
        for (int row = 0; row < numHouses; row ++){
            System.out.print ("\n How many people live in number " + houseNumbers[row] + " : ");
            numPeople = keyboard.nextInt();
            houseAges [row] = new int[numPeople];

//Input for age of individual=============================================================================
            for (int column = 0; column < numPeople; column++){
                System.out.print("What is the age of person " + (column + 1) + "      : ");
                houseAges[row][column] = keyboard.nextInt();
            }

        }
        System.out.println("");


//Output of ages houses and street=======================================================================
        for (int row = 0; row < houseNumbers.length; row++){

            for (int column = 0; column < houseAges[row].length; column++){
                ageSum = ageSum + houseAges[row][column];
            }
            System.out.println("House " + row + " has a total age of " + ageSum);
            totalAge = totalAge + ageSum;
        }
        System.out.print("\nThe street has a total age of " + totalAge);

    }























}
