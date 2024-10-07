import java.util.Scanner;
//=============================================================================
public class NitroxScuba {
    //=============================================================================
    private static final Scanner scnr = new Scanner(System.in);

//Constants

    private static final int FEET_PER_ATM = 33;
    private static final double MAX_O2_Pressure = 1.4;
    private static final double CONTINGENCY_O2_PRESSURE = 1.6;

    public static void main (String[] args) {

// Variables

        int depthDive;
        int percentageOxygen;

        double ambientPressure;
        double o2Pressure;
        char o2Group;

        boolean exceedsMaxO2;
        boolean exceedsContingencyO2;


//INPUT

        System.out.print ("Enter depth and percentage O2 : ");
        depthDive = scnr.nextInt ();
        percentageOxygen = scnr.nextInt ();

//CALCULATIONS:

        ambientPressure = ((double) depthDive / FEET_PER_ATM) + 1;
        o2Pressure = (percentageOxygen / 100.0) * ambientPressure;
        o2Group = (char) ((int)(o2Pressure * 10) + (int) 'A');

        exceedsMaxO2 = (o2Pressure > MAX_O2_Pressure);
        exceedsContingencyO2 = (o2Pressure > CONTINGENCY_O2_PRESSURE);

    //OUTPUTS:
        System.out.println ("Ambient pressure : " + ambientPressure);
        System.out.println ("O2 pressure : " + o2Pressure);
        System.out.println ("O2 group : " + o2Group);
        System.out.println ("Exceeds maximal O2 pressure : " + exceedsMaxO2);
        System.out.println ("Exceeds contingency O2 pressure : " + exceedsContingencyO2);
    }


}
