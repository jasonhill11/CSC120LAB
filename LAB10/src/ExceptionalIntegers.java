import java.util.ArrayList;

public class ExceptionalIntegers {
    public static void main (String[] args){
        ArrayList<Integer> intArray = new ArrayList<>();
        int index;
        for (index = 0; index < args.length; index++){
            try{
                intArray.add(integerConverter(args, index));
            } catch (NumberFormatException e){
                System.out.println("Catch block says the argument " + args[index] + " is ignored because " + args[index]);
            }
        }
        System.out.println("\nVector contents are: ");
        for (index = 0; index < intArray.size(); index++){
            System.out.println("Item " + index + " is " + intArray.get(index));
        }
    }

    public static int integerConverter (String[] args, int index) throws NumberFormatException{
        int intValue = Integer.parseInt(args[index]);
        System.out.println("Converter method says integer OK - " + intValue);
        return intValue;
    }
}
