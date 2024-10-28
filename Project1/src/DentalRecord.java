import java.util.Scanner;

/**
 * DentalRecord is a program allowing the user to input a family's tooth information. From the menu
 * they are able to print the records, tooth extractions, and calculate root canals.
 *
 * @author jasonhill
 */

public class DentalRecord {
    private static final Scanner keyboard = new Scanner(System.in);
    //Static Variables------------------------------------------

    private static final int MIN_FAMILY = 1;
    private static final int MAX_FAMILY = 6;
    private static final int MAX_ROWS = 2;
    private static final int MAX_TEETH = 8;

    /**
     * Main method - this collects user input for the number of family members, their names, and tooth information.
     * There are menu options for printing the information, extracting a tooth, calculating root canals, or to exit.
     *
     */

    public static void main (String[] args) {
    //Family size variable, teeth and family array variables, and option variable essential for functions
        int numberFamily;
        String[] familyNames;
        int [][] teethLength;
        char [][][] teethInfo;
        char option;

        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");
    //User assigns family size
        numberFamily = GetNumberFamily();

    //Creates family name array, teeth quantify array, and teeth information array
        familyNames = new String[numberFamily];
        teethLength = new int [MAX_ROWS][numberFamily];
        teethInfo = new char[numberFamily][MAX_ROWS][MAX_TEETH];

    //Fills the arrays with data from the user as prompted
        GetFamilyData (numberFamily, familyNames, teethInfo, teethLength);

    //Reads user's choice from menu
        System.out.print("\n (P)rint, (E)xtract, (R)oot, e(X)it          : ");
        option = keyboard.next().charAt(0);

    //Performs the function requested by the user, or exits program if option is chosen
        while (option != 'X' && option != 'x'){
            switch (option){
                case 'P' :
                case 'p' :
                    PrintRecord (numberFamily, familyNames, teethInfo, teethLength);
                    System.out.print("\n (P)rint, (E)xtract, (R)oot, e(X)it          : ");
                    break;
                case 'E' :
                case 'e' :
                    ExtractTooth (numberFamily, familyNames, teethInfo, teethLength);
                    System.out.print("\n (P)rint, (E)xtract, (R)oot, e(X)it          : ");
                    break;
                case 'R' :
                case 'r' :
                    RootCanal (numberFamily, teethInfo, teethLength);
                    System.out.print("\n (P)rint, (E)xtract, (R)oot, e(X)it          : ");
                    break;
                default:
                    System.out.print("Invalid menu option, try again              : ");
            }
            option = keyboard.next().charAt(0);
        }
    //Goodbye message and exits program
        System.out.print("\n Exiting the Floridian Tooth Records :-)");

    }
    //Reads family quantity

    /**
     * Method reads the amount of families, and will give an error if it exceeds the max.
     *
     */

    public static int GetNumberFamily(){
        int numberFamily;
        System.out.print("Please enter number of people in the family : ");
        numberFamily = keyboard.nextInt();

        while (numberFamily < MIN_FAMILY || numberFamily > MAX_FAMILY) {
            System.out.print("Invalid number of people, try again         : ");

            numberFamily = keyboard.nextInt();
        }

        return numberFamily;
    }
    //Accepts family data necessary for program function

    /**
     * Method collects data about the family including the names, amount of uppers, and amount of lowers.
     *
     */

    public static void GetFamilyData(int numberFamily, String[] familyNames, char[][][] teethInfo, int[][] teethLength){
        String upperRow;
        String lowerRow;

    // Accepts family members' names and teeth orientation and checks the validity of responses
        for (int familyIndex = 0; familyIndex < numberFamily; familyIndex++){
            System.out.print("Please enter the name for family member " + (familyIndex + 1) + "   : ");
            familyNames[familyIndex] = keyboard.next();

            System.out.printf("Please enter the uppers for %-15s : ", familyNames[familyIndex]);
            upperRow = getToothRow();
            teethLength[0][familyIndex] = upperRow.length();
            for (int toothIndex = 0; toothIndex < upperRow.length(); toothIndex++){
                teethInfo[familyIndex][0][toothIndex] = upperRow.charAt(toothIndex);
            }

            System.out.printf("Please enter the lowers for %-15s : ", familyNames[familyIndex]);
            lowerRow = getToothRow();
            teethLength[1][familyIndex] = lowerRow.length();
            for (int toothIndex = 0; toothIndex < lowerRow.length(); toothIndex++){
                teethInfo[familyIndex][1][toothIndex] = lowerRow.charAt(toothIndex);
            }
        }
    }

    //Accepts the specific tooth row as inputted by the user and checks its validity

    /**
     * Method checks to make sure the number of teeth in a row does not exceed the max.
     *
     */

    public static String getToothRow(){
        String upperRow = keyboard.next();
        boolean correctTooth = LetterCheck(upperRow);
        while (upperRow.length() > MAX_TEETH || !correctTooth){
            if (!correctTooth){
                System.out.print("Invalid teeth types, try again              : ");
            }else {
                System.out.print("Too many teeth, try again                   : ");
            }
            upperRow = keyboard.next();
            correctTooth = LetterCheck(upperRow);
        }
        upperRow = upperRow.toUpperCase();
        return upperRow;
    }
    //Checks the validity of a user's tooth row input

    /**
     * Method makes sure that the tooth categories are entered into the right categories.
     *
     */

    public static boolean LetterCheck (String toothRow){

        boolean correctTooth = false;

        for (int index = 0; index < toothRow.length(); index++){
            switch (toothRow.charAt(index)){
                case 'I' :
                case 'i' :
                case 'B' :
                case 'b' :
                case 'M' :
                case 'm' :
                    correctTooth = true;
                    break;
                default:
                    return false;
            }
        }
        return correctTooth;
    }

    //Prints each family member's dental information

    /**
     * Method prints the family's dental information including the uppers, lowers for each member.
     *
     */

    public static void PrintRecord (int numberFamily, String[] familyNames, char[][][] teethInfo, int [][] teethLength) {
        System.out.println();
        for (int familyIndex = 0; familyIndex < numberFamily; familyIndex++){
            System.out.println(familyNames[familyIndex]);
            System.out.print("  Uppers:  ");
            for (int toothIndex = 0; toothIndex < teethLength[0] [familyIndex]; toothIndex++){
                System.out.print((toothIndex + 1) + ":" + teethInfo[familyIndex][0][toothIndex] + "  ");
            }
            System.out.println();

            System.out.print("  Lowers:  ");
            for (int toothIndex = 0; toothIndex < teethLength[1] [familyIndex]; toothIndex++){
                System.out.print((toothIndex + 1) + ":" + teethInfo[familyIndex][1][toothIndex] + "  ");
            }
            System.out.println();
        }
    }
    //Extracts one single tooth from a single family member

    /**
     * Method checks single tooth information for each family member.
     *
     */

    public static void ExtractTooth (int numberFamily, String[] familyNames, char[][][] teethInfo, int [][] teethLength) {
    //Variables for saving individual family and tooth information
        String name;
        int nameIndex = 0;
        char toothLayer;
        int toothRow = 0;
        int toothNumber;
        boolean realFamilyMember = false;
        boolean realLayer = false;

    //Gets family member's name
        System.out.print("Which family member                         : ");
        name = keyboard.next();

    //Checks if the name is a family member
        while (!realFamilyMember){
            for (int familyIndex = 0; familyIndex < numberFamily; familyIndex++){
                if (name.equalsIgnoreCase(familyNames[familyIndex])){
                    realFamilyMember = true;
                    nameIndex = familyIndex;
                }
            }
            if (!realFamilyMember){
                System.out.print("Invalid family member, try again            : ");
                name = keyboard.next();
            }
        }
    //Gets tooth layer
        System.out.print("Which tooth layer (U)pper or (L)ower        : ");
        toothLayer = keyboard.next().charAt(0);

    //Checks to see if tooth layer is a real tooth layer
        while (!realLayer){
            switch (toothLayer){
                case 'U' :
                case 'u' :
                    realLayer = true;
                    break;
                case 'L' :
                case 'l' :
                    toothRow = 1;
                    realLayer = true;
                    break;
                default:
                    System.out.print("Invalid layer, try again                    : ");
                    toothLayer = keyboard.next().charAt(0);

            }
        }
    //Gets tooth number
        System.out.print("Which tooth number                          : ");
        toothNumber = keyboard.nextInt();

    //Checks to see if tooth is either a valid response or if a tooth is present in the given index
        while (toothNumber > teethLength[toothRow][nameIndex] || toothNumber < 0 || teethInfo[nameIndex][toothRow][toothNumber - 1] == 'M') {
            if (toothNumber > teethLength[toothRow][nameIndex] || toothNumber < 0) {
                System.out.print("Invalid tooth number, try again             : ");

            }else if (teethInfo[nameIndex][toothRow][toothNumber - 1] == 'M'){
                System.out.print("Missing tooth, try again                    : ");
            }
            toothNumber = keyboard.nextInt();

        }
    //Replaces index with 'M' to indicate that the tooth has been extracted
        teethInfo[nameIndex][toothRow][toothNumber - 1] = 'M';
    }

    /**
     * Method calculates and prints out the number of root canals.
     *
     */

    public static void RootCanal (int numberFamily, char[][][] teethInfo, int [][] teethLength){
    //Math variables representing Ix^2 + Bx - M, the determinant, and the function's roots
        double i = 0;
        double b = 0;
        double m = 0;
        double determinant;
        double root;
        double root2;

    //Counts all instances of 'I', 'B', and 'M'
        for (int familyIndex = 0; familyIndex < numberFamily; familyIndex++){
            for (int rowsIndex = 0; rowsIndex < MAX_ROWS; rowsIndex++){
                for (int toothIndex = 0; toothIndex < teethLength[rowsIndex][familyIndex]; toothIndex++){
                    switch (teethInfo[familyIndex][rowsIndex][toothIndex]){
                        case 'I':
                            i = i + 1;
                            break;
                        case 'B':
                            b = b + 1;
                            break;
                        case 'M':
                            m = m - 1;
                            break;
                        default:
                            System.out.print("Error in root calculation");
                    }
                }
            }
        }
    //Calculated the determinant, which is helpful to see how many roots the function has
        determinant = b * b - 4 * i * m;

    //Calculates and displays the roots
        if (determinant > 0){
            root = (-b + Math.sqrt(determinant)) / (2 * i);
            root2 = (-b - Math.sqrt(determinant)) / (2 * i);
            System.out.printf("\nAnother root canal at %.2f", root);
            System.out.printf("\nAnother root canal at %.2f", root2);
        } else if (determinant == 0) {
            root = -b / (2 * i);
            System.out.printf("One root canal at     %.2f", root);
        } else
            System.out.println("Congrats, no root canals!");
        System.out.println();
    }
}
