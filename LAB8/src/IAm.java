import java.util.Scanner;
//=================================================================================================
public class IAm {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String sentence = "";
    //Variable to store result--------------------------------------------------------------------------------------
        String quality = "";

        System.out.println("Please enter sentences, . to end.");

    //While loop until user enters "." ---------------------------------------------------------------------------------
        sentence = scan.nextLine();
        while(!(sentence.equals("."))){
    //If statement to check if line starts with "I am" -----------------------------------------------------------------
            if (sentence.startsWith("I am ")) {
                quality += (sentence.substring(5));
                quality += (", ");
                }
            sentence = scan.nextLine();
            }
    //Print result ----------------------------------------------------------------------------------------------------
        System.out.println("The qualities are " + quality);
            }



        }



