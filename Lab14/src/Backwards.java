import java.util.ArrayList;
import java.util.Scanner;

public class Backwards {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String word;
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Please enter a backwards sentence: ");
        while (true) {
            word = keyboard.next();
            if(word.endsWith(".")) {
                list.add(0, word.substring(0, word.length()-1));
                break;
            }
            list.add(0, word);
        }
        System.out.println("\nForward it is: ");
        for(int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i));
            if(i == list.size() - 1) {
                System.out.println(".");
            } else {
                System.out.print(" ");
            }
        }

    }

}