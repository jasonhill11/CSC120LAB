import java.util.Scanner;

//=============================================================================

public class TaxTime {


//Static Variables------------------------------------------------------------------------------
    private static final int STINKING_RICH = 500000;
    private static final int QUITE_RICH = 200000;
    private static final int MIAMI_POOR = 100000;
    private static final int AVERAGE = 50000;
    private static final int REALISTIC = 20000;
    private static final int POOR = 0;
    private static final double HIGH_RATE = 0.25;
    private static final double MEDIUM_RATE = 0.10;
    private static final double LOW_RATE = 0.03;
    private static final double NO_RATE = 0.0;
    private static final Scanner keyboard = new Scanner(System.in);



//Main Method
        public static void main (String[] args) {


            //Variables
            double finances;
            double income = 0;
            double deduction = 0;
            double taxableIncome;
            char taxGroup;
            double taxOwed;

            //Inputs
            do {
                System.out.println("Enter next amount: ");
                finances = keyboard.nextDouble();
                if (finances > 0)
                    income = income + finances;
                if (finances < 0)
                    deduction = Math.abs(deduction - finances);
            }
            while (finances != 0);

            //functions
            taxableIncome = computeTaxableIncome(income, deduction);
            taxGroup = chooseTaxGroup(taxableIncome);
            taxOwed = computeTax(taxableIncome, taxGroup);
            displayOutput(income, deduction, taxableIncome, taxGroup, taxOwed);
        }

        //Compute Taxable Income
        public static double computeTaxableIncome (double income, double deduction) {
            if (income >= deduction) {
                return (income - deduction);
            } else {
                return 0.0;
            }

        }

        //Decide Tax Group
        public static char chooseTaxGroup (double taxableIncome) {
            if (taxableIncome >= STINKING_RICH)
                return 'S';
            else if (taxableIncome >= QUITE_RICH)
                return 'Q';
            else if (taxableIncome >= MIAMI_POOR)
                return 'M';
            else if (taxableIncome >= AVERAGE)
                return 'A';
            else if (taxableIncome >= REALISTIC)
                return 'R';
            else
                return 'P';

            }




        //Compute Tax
        public static double computeTax (double taxableIncome, char taxGroup) {
            if (taxGroup == 'S' || taxGroup =='Q')
                return taxableIncome * HIGH_RATE;
            else if (taxGroup == 'M')
                return taxableIncome * MEDIUM_RATE;
            else if (taxGroup == 'A' || taxGroup == 'R')
                return taxableIncome * LOW_RATE;
            else if (taxGroup == 'P')
                return taxableIncome * NO_RATE;
            else
                System.out.println("Error!");
            return 0;

        }



//Output------------------------------------------------------------------------------
        public static void displayOutput (double income, double deduction, double taxableIncome,
        char taxGroup, double taxOwed){
            System.out.println("Deductions     = $"+ income);
            System.out.println("Deductions     = $" + deduction);
            System.out.println("Taxable income = $" + taxableIncome);
            System.out.println("Tax group      = " + taxGroup);
            System.out.println("Tax owed       = $" + taxOwed);
        }



    }

