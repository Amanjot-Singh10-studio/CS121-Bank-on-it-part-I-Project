import java.io.*; 
import java.util.*; 

public class Customer extends User { 
	Scanner input = new Scanner(System.in); 
	private CheckingAccount checking; 
	private SavingsAccount savings; 

	public static void main(String[] args) { 
		new Customer(); 
	} 
	public Customer() { 
		checking = new CheckingAccount(); 
		savings = new SavingsAccount(); 

		setUserName("admin"); 
		setPIN("0000"); 

		if (login()) { 
			System.out.print("Login Sucessful"); 
			start(); 
		} 
		else { 
			System.out.println("Login Failed"); 
		} 
	} 
	public Customer(String userName, String PIN) {
		checking = new CheckingAccount(); 
		savings = new SavingsAccount(); 
		setUserName(userName); 
		setPIN(PIN); 
	} 
	public String menu() { 
		 System.out.println();
        	System.out.println("Customer Menu");
        	System.out.println("0) Exit");
        	System.out.println("1) Manage Checking Account");
        	System.out.println("2) Manage Savings Account");
        	System.out.println("3) Change PIN");
        	System.out.print("Action (0-3): ");

        	return input.next();
	} 

	public void start() { 
		String choice = ""; 
		while (!choice.equals("0")) { 
			choice = menu(); 

			if (choice.equals("1")) { 
				System.out.println("Checking Account"); 
				checking.start(); 
			} 
			else if (choice.equals("2")) { 
				System.out.println("Savings Account"); 
				savings.start(); 
			} 
			else if (choice.equals("3")) { 
				changePIN(); 
			} 
			else if (choice.equals("0")) { 
				System.out.println("Have a great day"); 
			} 
			else { 
				System.out.println("Invalid choice"); 
			} 
		} 
	} 

	public void changePIN() { 
		System.out.print("Enter new PIN: "); 
		String newPIN = input.next(); 
		setPIN(newPIN); 
		System.out.println("PIN Changed Sucessfully"); 
	} 

	public String getReport() { 
		String report = "Customer: " + getUserName(); 
		report = report + "\nChecking: " + checking.getBalanceString(); 
		report = report + "\nSavings: " + savings.getBalanceString(); 

		return report; 
	} 
} 
