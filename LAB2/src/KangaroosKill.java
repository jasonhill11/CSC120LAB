import java.util.Scanner;
//=============================================================================
public class KangaroosKill {
    //-----------------------------------------------------------------------------
    private static final Scanner scnr = new Scanner(System.in);
    //-----------------------------------------------------------------------------

    //Constants
    private static final double ROAD_WIDTH = 10.0 / 1000.0; // 10 meters in kilometers
    private static final double ROADKILL_PROBABILITY_CONSTANT = 1.47;

    //-----------------------------------------------------------------------------
    public static void main (String[] args) {

//Variables
        double lengthSquare;
        double lengthRoads;
        int numKangaroos;

        double areaOfSquare;
        double kangarooDensity;
        double roadSurfaceArea;

        double killsAndInjuries;
        int kills;
        int injuries;


//Input collection
        System.out.print("Enter side of square in km : ");
        lengthSquare = scnr.nextDouble ();

        System.out.print("Enter roads length in km : ");
        lengthRoads = scnr.nextDouble ();

        System.out.print("Enter number of 'roos : ");
        numKangaroos = scnr.nextInt ();


//Calculations
        areaOfSquare = Math.pow (lengthSquare, 2);
        kangarooDensity = numKangaroos / areaOfSquare;

        roadSurfaceArea = lengthRoads * ROAD_WIDTH;
        killsAndInjuries = roadSurfaceArea * kangarooDensity * ROADKILL_PROBABILITY_CONSTANT;

        kills = (int) killsAndInjuries;

        injuries = (int)Math.ceil(killsAndInjuries%1);

//Output
        System.out.println("Expected number of kills is : " + kills);
        System.out.println("Expected number of injuries : " + injuries);

    } // end of main method

} // end of the KangaroosKill class
