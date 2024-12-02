import java.util.Scanner

public class HelpingDCF {

    private static final Scanner keyboard = new Scanner(System.in);
    private static final String SENTINEL = "STOP";

    public static void main(String[] args){
        Family myFamily = new Family();
        String name;
        int age;

        do {
            System.out.print("Enter name of next person : ");
            name = keyboard.nextLine();
            if (!name.equalsIgnoreCase(SENTINEL)){
                System.out.print("How old is that person    : ");
                age = keyboard.nextInt();
                keyboard.nextLine();
                if (!myFamily.addPerson(name, age)){
                    System.out.println("ERROR: Cannot add person");
                    name = SENTINEL;

                }
            }


        }
    }
}
