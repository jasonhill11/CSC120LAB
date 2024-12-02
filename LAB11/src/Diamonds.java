import java.util.Scanner;

public class Diamonds {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){

        System.out.print("Enter the name of the girl : ");
        String name = keyboard.nextLine();
        Girl girl = new Girl(name);

        while (true){
            System.out.println(girl.getDiamondInfo());

            System.out.print("Enter carats and value     : ");
            int carats = keyboard.nextInt();
            int value = keyboard.nextInt();

            if (carats < 1){
                break;
            }

            Diamond diamond = new Diamond(carats, value);
            girl.acceptDiamond(diamond);

        }

        System.out.println(girl.getDiamondInfo());
        keyboard.close();


        }



    }
class Diamond{
    private int carats;
    private int value;


    public Diamond(int carats, int value){
        this.carats = carats;
        this.value = value;

    }

    public int getCarats(){
        return carats;

    }

    public int getValue(){
        return value;

    }
}

class Girl {
    private Diamond diamond;
    private String name;

    public Girl (String name) {
        this.name = name;
        this.diamond = null;
    }

    public String getName(){
        return name;
    }

    public void acceptDiamond(Diamond d){
        if (diamond == null || d.getValue() > diamond.getValue()){
            diamond = d;
            System.out.println("Woohoo, the girl took the diamond");
        }
        else{
            System.out.println("Aaargh, the diamond was rejected");
        }
    }
    public String getDiamondInfo(){
        if (diamond != null){
            return name + " has a diamond, " + diamond.getCarats() + " carats, worth $" + diamond.getValue();
        }
        else{
            return name + " has no best friend";
        }
    }
}