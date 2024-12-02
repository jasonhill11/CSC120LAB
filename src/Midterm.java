import java.util.Scanner;

public class Midterm {
    private static final Scanner keyboard = new Scanner(System.in);

    public static int main (String[]args){
        int number1;
        int number2;
        double average;

        number1 = keyboard.nextInt();
        number2 = keyboard.nextInt();

        average = (number1 + number2) / 2;

        System.out.println(average);
        return (int) average;
    }
}
