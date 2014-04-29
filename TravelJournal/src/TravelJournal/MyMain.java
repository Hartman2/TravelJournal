package TravelJournal;

import java.util.Date;
import java.util.Scanner;

public class MyMain {

	// This will be the class to call controller and be the actualy program
	public static void main(String[] args){
		
		
		
		
		MyTravelController controller = new MyTravelController();
		
		controller.addUser("Andrew", "Hartman");
//		controller.login("Andrew", "Hartman");
//		controller.addAttributes("I'm Fun");
//		controller.createJournal();
//		MyJournal journal = (MyJournal) controller.createJournal();
//		Date date = new Date();
//		date.setMonth(6);
//		date.setYear(2015);
//		journal.createLog("Ames",date);
		
		Scanner scanner = new Scanner(System.in);
		int exit = 1;
		while(exit != 0){
			System.out.println("Welcome to the Travel Log System Create by Andrew Hartman and Ryan Dincher");
			System.out.println("No one is currently Logged in");
			System.out.println("If you want to log in press 1");
			System.out.println("If you want to sign up and register press 2");
			System.out.println("If you want to exit the program press 0");
			String temp = scanner.next();
			if(Integer.parseInt(temp) == 0 ){
				System.out.println("Exiting the program....");
				exit = 0;
			}
			if(Integer.parseInt(temp) == 1){
			
				System.out.println("Type your Username");
				String username = scanner.next();
				System.out.println("Type your Password");
				String password = scanner.next();
				
				if(!controller.login(username, password)){
					System.out.println("Could Not Log in");
				}
				else{
					System.out.println("You Are Logged In");
				}
				
			}
			
			if(Integer.parseInt(temp) == 2){
				
				System.out.println("Type your Username");
				String username = scanner.next();
				System.out.println("Type your Password");
				String password = scanner.next();
				
				controller.addUser(username, password);
				System.out.println("You Are Registered");
				
			}
			while(controller.keeper.currentLoggedIn !=null){
				
				
				
				System.out.println("What Would you Like to Do?");
				System.out.println("To create a travel log press 1");
				System.out.println("To modify a travel log press 2");
				System.out.println("To delete a travel log press 3");
				System.out.println("To view all travel logs press 4");
				System.out.println("To view all distance traveled press 5");
				System.out.println("To add item to wish list press 6");
				System.out.println("To view wishlist press 7");
				System.out.println("To Plan trip press 8");
				System.out.println("To view distance traveled on a single trip press 9");
				System.out.println("If you want to delete your account enter 10");
				System.out.println("If you want to add an attribute to your profile enter 11");
				System.out.println("If you want to createa journal enter 12");
				System.out.println("If you want to rate a trip enter 13");
				System.out.println("if you want to delete a journal enter 14");
				System.out.println("");
				System.out.println("To logout enter logout");
				System.out.println("To exit press 0");
				
				if(scanner.nextInt()== 0){
					System.out.println("Exiting the program....");
					exit = 0;
				}
				
				
			}
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	
}
