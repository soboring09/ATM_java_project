// CashDispenser.java
// Represents the cash dispenser of the ATM

public class CashDispenser 
{
   // the default initial number of bills in the cash dispenser
   private final static int INITIAL_COUNT = 500;
   private int $100count; // number of $100 bills remaining
   private int $500count; // number of $500 bills remaining
   private int $1000count; // number of $1000 bills remaining
   private int $100billsRequired; // number of $100 bills required
   private int $500billsRequired; // number of $500 bills required
   private int $1000billsRequired; // number of $1000 bills required
   
   
   
   // no-argument CashDispenser constructor initializes count to default
   public CashDispenser()
   {
      $100count = INITIAL_COUNT; // set count attribute to default
      $500count = INITIAL_COUNT;
      $1000count = INITIAL_COUNT;
   } // end CashDispenser constructor

   // simulates dispensing of specified amount of cash
   public void dispenseCash( int amount )
   {
       $100billsRequired = 0;
       $500billsRequired = 0;
       $1000billsRequired = 0; //initialize
       
       int needed$1000 = amount / 1000;
       if ($1000count >= needed$1000){
           $1000billsRequired = needed$1000; //If $1000 bills are enough, dispense all needed $1000 bills.
           $1000count -= $1000billsRequired; //update the count of $1000 bills
           amount %= 1000; //Remaining amount after dispensing $1000 bills
       } else{
           $1000billsRequired = $1000count; //If not enough, dispense all remaining $1000 bills in ATM.
           amount -= $1000count * 1000; //Remaining amount after dispensing $1000 bills
           $1000count = 0; // All $1000 bills in ATM run out.
       }
       
       int needed$500 = amount / 500;
       if ($500count >= needed$500){
           $500billsRequired = needed$500; //If $500 bills are enough, dispense all needed $500 bills.
           $500count -= $500billsRequired; // update the count of $500 bills
           amount %= 500; //Remaining amount after allocating $500 bills
       } else{
           $500billsRequired = $500count;//If not enough, dispense all remaining $500 bills in ATM.
           amount -= $500count * 500; //Remaining amount after dispensing $500 bills
           $500count = 0;// All $500 bills in ATM run out.
       }
       
       int needed$100 = amount / 100;
       if ($100count >= needed$100){
           $100billsRequired = needed$100; //If $100 bills are enough, dispense all needed $100 bills.
           $100count -= $100billsRequired; // update the count of $100 bills
           amount %= 100; //Remaining amount after allocating $100 bills
       } else{
           $100billsRequired = $100count;//If not enough, dispense all remaining $100 bills in ATM.
           amount -= $100count * 100;//Remaining amount after dispensing $100 bills
           $100count = 0;// All $100 bills in ATM run out.
       }
   } // end method dispenseCash

   // indicates whether cash dispenser can dispense desired amount
   public boolean isSufficientCashAvailable( int amount )
   {
       int temp$1000count = $1000count;
       int temp$500count = $500count;
       int temp$100count = $100count; //Copies of bills counts, avoiding affecting the original bills counts in ATM
       
       int needed$1000 = amount / 1000;
       if(temp$1000count >= needed$1000){
           temp$1000count -= needed$1000;
           amount %= 1000;
       } else{
           amount -= temp$1000count * 1000;
           temp$1000count = 0;
       } //Allocating $1000 bills
       
       int needed$500 = amount / 500;
       if(temp$500count >= needed$500){
           temp$500count -= needed$500;
           amount %= 500;
       } else{
           amount -= temp$500count * 500;
           temp$500count = 0;
       }//Allocating $500 bills
       
       int needed$100 = amount / 100;
       if(temp$100count >= needed$100){
           temp$100count -= needed$100;
           amount %= 100;
       } else{
           amount -= temp$100count * 100;
           temp$100count = 0;
       }//Allocating $100 bills
       
       return (amount == 0); //If remaining amount is not zero, the bills in ATM are not enough to withdraw, return false; Instead, if 0, return ture.
   } // end method isSufficientCashAvailable
} // end class CashDispenser



/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
