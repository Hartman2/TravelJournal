package TravelJournal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
			if(temp.equals("0")){
				System.out.println("Exiting the program....");
				exit = 0;
			}
			if(temp.equals("1")){
			
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
			
			if(temp.equals("2")){
				
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
				
				temp = scanner.next();
				if(temp.equals("0")){
					System.out.println("Exiting the program....");
					exit = 0;
					break;
				}
				
				if(temp.equals("1")){
					
				}
				

				if(temp.equals("2")){
					
					System.out.println("Enter Travel Log Id to change");
					int logID = Integer.parseInt(scanner.next());
					System.out.println("Enter Field you want to change \n departurePoint travelMethod locationWeather destination");
					String field = scanner.next();
					System.out.println("Enter what you want to change " + field +" to");
					String toChange = scanner.next();
					boolean changed = controller.modifyLog(logID, field, toChange);
					if(!changed){
						System.out.println("Log " + logID + " was not modified");
					}
					
				}
				

				if(temp.equals("3")){
					
					int logID = Integer.parseInt(scanner.next());
					boolean deleted = controller.deleteLog(logID);
					if(!deleted){
						System.out.println("Log " + logID +" was not deleted");
					}
				}


				if(temp.equals("4")){
	
					List<TravelLog> allLogs = controller.viewAllLogs();
					for(int i = 0; i < allLogs.size(); i++){
						
						MyTravelLog tmp = (MyTravelLog) allLogs.get(i);
						System.out.println("Destination: "+ tmp.destination + "\t Departure Point: " + tmp.departurePoint 
								+ "\t Distance to Destination"+ tmp.distance + "\t Destination Weather" + tmp.locationWeather +
								"\t Rating out of 5" + tmp.myRating + "\t Travel Method " + tmp.travelMethod);
						
					}
					
					
				}


				if(temp.equals("5")){
	

				}


				if(temp.equals("6")){
	

				}
				
				
				if(temp.equals("7")){
					
				}
				

				if(temp.equals("8")){
					
				}
				

				if(temp.equals("9")){
	

				}


				if(temp.equals("10")){
	

				}



				if(temp.equals("11")){
	

				}


				if(temp.equals("12")){
	

				}
				
				
				if(temp.equals("13")){
					
				}
				

				if(temp.equals("14")){
	

				}


				if(temp.equals("logout")){
					String user = controller.keeper.currentLoggedIn.username;
					controller.logout(user);
					System.out.println(user + " You Are currently logged out");

				}
				
			}
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	
}
