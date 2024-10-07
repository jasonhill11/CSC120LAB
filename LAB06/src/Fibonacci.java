import java.util.Scanner;

//=============================================================================

public class Fibonacci {


    //Static Variables------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    public static final int NUM_ELEMENTS = 10;



//Main Method
    public static void main(String[] args) {

        //Variables
        int number;
        boolean isFibonacci;
        boolean isPrime;
        int a;
        int b;


        //Inputs
        do {
            System.out.print("Please enter numbers (0 to stop): ");
            number = keyboard.nextInt();
        }
        while (number != 0);





    }


    public static boolean isFibonacci (int number, int a, int b)
    {
        if (number < 0) return false;
        a = 0;
        b = 1;
        while (b < number)

    }

    public static boolean isPrime (int number)
    {
        int i;

        if (number <= 1){
            b == false;
        }

        for (i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) {
                ;
            }
        }


    }


    //Output===========================================================
    public static void displayOutput (int number, boolean isFibonacci, boolean isPrime){
            if (System.out.println(arr[i] );
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
    }
}
}