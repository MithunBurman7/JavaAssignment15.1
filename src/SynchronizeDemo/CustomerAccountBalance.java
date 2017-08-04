package SynchronizeDemo;

import java.util.Scanner;


public class CustomerAccountBalance { 
	
	static double availableBalance;
	double newAvailableBalance;
	
	 public synchronized void withdraw(double amount)
	 {
		           // Here by declaring variables 
	 if(amount>availableBalance)
     {
                    //  Insufficient balance in your SB account
     System.out.println("Insufficent balance in your account"); 
     }
     else
     {
                       
    	 newAvailableBalance=availableBalance-amount;  //updating the account balance
         availableBalance = newAvailableBalance;
         System.out.println(amount+" amount was withdrawn from your account sucessfully.");
         System.out.println("Your Account Balance:"+newAvailableBalance);
     }
 }
	 
	                  
	    public synchronized void deposit(double amount)  //Depositing balance in the SB account
	    {
	    if(amount<0.0) //checking for negative values
	    {
	    System.out.println("Can not depoist negative amount"); // can't deposit a negative amount
	    }
	    else
	    {
	    	
	    //update the new account balance
	    	newAvailableBalance = availableBalance+amount;
	          availableBalance = newAvailableBalance;
	          System.out.println("Cash/balance for your SB Account Balance "+amount+" is successfully deposited and updated.");
	          System.out.println("Your SB Account Balance is : "+newAvailableBalance);
	         }
	     }
	    	 

	public static void main(String[] args) {
		
		
		CustomerAccountBalance obj= new CustomerAccountBalance(); //creating object for the account class
		    @SuppressWarnings("resource")
			Scanner scan= new Scanner(System.in);
		   
		    do
		    {
		    System.out.println("\nChoose Your choice:");
		    
		        System.out.println("1.Deposit");
		        System.out.println("2.Withdraw");
		        System.out.println("3.Press 'x' to quit");
		       
		        switch(scan.next().charAt(0))
		        {
		        case '1': System.out.println("Enter amount to be deposited");
		         double amount=scan.nextDouble();  
		         obj.deposit(amount);  
		         main(args);break;
		         
		         
		         case '2': System.out.println("Enter amount to withdraw");
		         double withDrawAmount=scan.nextDouble();
		         obj.withdraw(withDrawAmount);  
		         main(args);break; 
		          
		        case 'x': System.out.println("Thank you for quitting.");System.exit(0);
		        }
		      }
		         while(scan.next().charAt(0)=='x'||scan.next().charAt(0)=='X');

	}

}
