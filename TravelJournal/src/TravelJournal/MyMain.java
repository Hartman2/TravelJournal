package TravelJournal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyMain {

	// This will be the class to call controller and be the actually program
	public static void main(String[] args){
		
		
		
		
		MyTravelController controller = new MyTravelController();
		
		controller.addUser("Andrew", "Hartman");
		controller.login("Andrew", "Hartman");
		controller.addAttributes("I'm Fun");
		MyJournal journal = (MyJournal) controller.createJournal();
		journal.editName("Journal");
		MyJournal journal2 = (MyJournal) controller.createJournal();
		journal2.editName("Journal2");
		
		Date date = new Date();
		date.setMonth(6);
		date.setYear(2015-1900);
		int travelLogId = controller.createLog("Alaska", date, journal.journalName);
		int travelLogId2 = controller.createLog("Ames", date, journal.journalName);
		
		int travelLogId3 = controller.createLog("Alaska2", date, journal2.journalName);
		int travelLogId4 = controller.createLog("Ames2", date, journal2.journalName);
		
		controller.modifyLog(journal.journalID, travelLogId, "distance", "1010");
		controller.modifyLog(journal.journalID, travelLogId2, "distance", "2020");
		controller.modifyLog(journal2.journalID, travelLogId3, "distance", "2020");
		controller.modifyLog(journal2.journalID, travelLogId4, "distance", "1015");
		
		
		controller.addWish("Florida");
		//controller.modifyLog(travelLogId, "destination", "Paraguay");
		controller.addWish("Canada");
//		System.out.println("Journal1 id is " + journal.journalID);
//		System.out.println("Journal2 id is " + journal2.journalID);
		System.out.println("Alaska id is " + travelLogId);
		System.out.println("Ames id  id is " + travelLogId2);
		System.out.println("Alaska2 id is " + travelLogId3);
		System.out.println("Ames1 id  id is " + travelLogId4);

		controller.rateTrip(journal.journalID, travelLogId,1);
		controller.rateTrip(journal.journalID, travelLogId2,3);
		controller.rateTrip(journal2.journalID, travelLogId3,5);
		controller.rateTrip(journal2.journalID, travelLogId4,1);
		controller.logout("Andrew");
		
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
				System.out.println("To view all data(total distance) 5");
				System.out.println("To add item to wish list press 6");
				System.out.println("To view wishlist press 7");
				System.out.println("To Plan trip press 8");
				System.out.println("To view distance traveled on a single trip press 9");
				System.out.println("If you want to delete your account enter 10");
				System.out.println("If you want to add an attribute to your profile enter 11");
				System.out.println("If you want to create a journal enter 12");
				System.out.println("If you want to rate a trip enter 13");
				System.out.println("if you want to delete a journal enter 14");
				System.out.println("If you want to view your attribute enter 15");
				System.out.println("To Sort & View logs by date enter 16");
				System.out.println("To Sort & View logs by rating enter 17");
				System.out.println("To logout enter logout");
				System.out.println("To exit press 0");
				
				temp = scanner.next();
				if(temp.equals("0")){
					System.out.println("Exiting the program....");
					exit = 0;
					break;
				}
				
				//Create Travel Log
				if(temp.equals("1")){
					System.out.println("Where Did You Go?:");
					String dest = scanner.next();
					System.out.println("When Did You Go?(dd/MM/yyyy):");
					String when = scanner.next();
					System.out.println("What Journal to add to?:");
					String journ = scanner.next();
					
					Date myDate = new Date();
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					try {
						myDate = sdf.parse(when);
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					int id = controller.createLog(dest, myDate, journ);
					System.out.println("New Log created with id " + id);
				}
				
				//modify log
				if(temp.equals("2")){
					
					System.out.println("Enter Journal Id of Journal containing the log");
					int jID = Integer.parseInt(scanner.next());
					System.out.println("Enter Travel Log Id to change");
					int logID = Integer.parseInt(scanner.next());
					System.out.println("Enter Field you want to change \n departurePoint travelMethod locationWeather destination distance");
					String field = scanner.next();
					System.out.println("Enter what you want to change " + field +" to");
					String toChange = scanner.next();
					boolean changed = controller.modifyLog(jID, logID, field, toChange);
					if(!changed){
						System.out.println("Log " + logID + " was not modified");
					}
					
				}
				
				//delete log
				if(temp.equals("3")){
					
					System.out.println("Enter Travel Log Id to delete");
					int logID = Integer.parseInt(scanner.next());
					System.out.println("Enter Journal Id of Journal containing the log");
					int jID = Integer.parseInt(scanner.next());
					boolean deleted = controller.deleteLog(logID, jID);
					if(!deleted){
						System.out.println("Log " + logID +" was not deleted");
					}
				}
				
				//view all logs
				if(temp.equals("4")){
	
					List<TravelLog> allLogs = controller.viewAllLogs();
					for(TravelLog tl : allLogs){
						
						MyTravelLog tmp = (MyTravelLog)tl; //allLogs.get(i);
						System.out.println("Destination: "+ tmp.destination + "\t Departure Point: " + tmp.departurePoint 
								+ "\t Distance to Destination: "+ tmp.distance + "\t Destination Weather: " + tmp.locationWeather +
								"\t Rating out of 5: " + tmp.myRating + "\t Travel Method: " + tmp.travelMethod);
					}
					if(allLogs.size() == 0)
						System.out.println("No Logs Exist");
				}
				
				//view all data
				if(temp.equals("5")){
	
					int totalDistance = controller.viewData();
					System.out.println("Total Distance Traveled: " + totalDistance);
				}

				//add a wish list destination
				if(temp.equals("6")){
	
					System.out.println("Enter in the destination you would like to add to your wish list?");
					String destination = scanner.next();
					boolean dest = controller.addWish(destination);
					if(!dest){
						System.out.println("Could not add destination to wishlist");
					}
					else
						System.out.println(destination + " added to wishlist");
				}
				
				//view wish list
				if(temp.equals("7")){
				
					List<String> wishList = controller.viewWishList();
					System.out.println("Wish List Destinations include");
					for(int i = 0; i < wishList.size(); i++){
						System.out.println("\t" + wishList.get(i));
					}
					if(wishList.size() == 0)
						System.out.println("WishList is empty");
					
				}
				
				//plan trip
				if(temp.equals("8")){
					
					System.out.println("Enter destination for trip to plan");
					String destination = scanner.next();
					if(!controller.planTrip(destination))
						System.out.println("Failed to plan trip");
					else
						System.out.println("Trip to " + destination + " planned");
				}
				
				//view total distance
				if(temp.equals("9")){
	
					System.out.println("Enter Journal id");
					int jid = scanner.nextInt();
					System.out.println("Enter Travel Log id");
					int tid = scanner.nextInt();
					int tripDistance = controller.viewTripDistance(tid, jid);
					
					System.out.println("Trip with id: " + tid + " has a travel distance of " + tripDistance);
					
				}

				//delete account
				if(temp.equals("10")){
	
					String username = controller.keeper.currentLoggedIn.username;
					
					controller.logout(username);
					boolean remove = controller.removeUser(username);
					if(!remove){
						System.out.println("user was not removed");
					}
					else
						System.out.println(username + " Successfully removed");
				}

				//add attribute
				if(temp.equals("11")){
					
					System.out.println("Enter a new attribute/fun fact do you want on your profile");
					String attribute = scanner.next();
					boolean add = controller.addAttributes(attribute);
					if(add)
						System.out.println("Added Attribute");
					else
						System.out.println("Failed to add attribute");
					
				}

				//create a journal
				if(temp.equals("12")){
	
					System.out.println("Enter a name for the journal");
					String name = scanner.next();
					MyJournal j = (MyJournal) controller.createJournal();
					if(j != null)
					{
						j.editName(name);
						System.out.println("Your journal " + name + " was created with the id of " + j.journalID);
					}
					else
						System.out.println("Failed to create Journal with name of " + name);
				}
				
				//rate trip
				if(temp.equals("13")){
					System.out.println("Give the id of the journal your travel log is in");
					String jid = scanner.next();
					System.out.println("Give the id of the travel log you want to rate");
					String tid = scanner.next();
					System.out.println("Give the rating for the trip");
					String rating = scanner.next();
					boolean rate = controller.rateTrip(Integer.parseInt(jid), Integer.parseInt(tid), Integer.parseInt(rating));
					if(!rate){
						System.out.println("Rating was not successful");
					}
					else
						System.out.println("Rated Log " + tid + " " + rating + " stars out of 5");
					
				}
				
				//delete journal
				if(temp.equals("14")){
					System.out.println("Give the id of the journal you want to delete ");
					String tmp = scanner.next();
					boolean delete = controller.deleteJournal(Integer.parseInt(tmp));
					if(!delete){
						System.out.println("Journal was not deleted");
					}
					else
						System.out.println("Journal deleted");

				}
				
				//sort by date
				if(temp.equals("16")){
	
					List<TravelLog> allLogs = controller.sortDate();
					for(TravelLog tl : allLogs){
						
						MyTravelLog tmp = (MyTravelLog)tl; //allLogs.get(i);
						System.out.println("Date: " + tmp.date + " Destination: "+ tmp.destination + "\t Departure Point: " + tmp.departurePoint 
								+ "\t Distance to Destination: "+ tmp.distance + "\t Destination Weather: " + tmp.locationWeather +
								"\t Rating out of 5: " + tmp.myRating + "\t Travel Method: " + tmp.travelMethod);
					}
				}
				
				//sort by rating
				if(temp.equals("17")){
	
					List<TravelLog> allLogs = controller.sortRating();
					for(TravelLog tl : allLogs){
						
						MyTravelLog tmp = (MyTravelLog)tl; //allLogs.get(i);
						System.out.println("Destination: "+ tmp.destination + "\t Departure Point: " + tmp.departurePoint 
								+ "\t Distance to Destination: "+ tmp.distance + "\t Destination Weather: " + tmp.locationWeather +
								"\t Rating out of 5: " + tmp.myRating + "\t Travel Method: " + tmp.travelMethod);
					}
				}
				
				//view user's attribute
				if(temp.equals("15")){
					String attri = controller.keeper.currentLoggedIn.attribute;
					System.out.println(controller.keeper.currentLoggedIn.username+"'s attribute is " + attri);
				
				}

				if(temp.equals("logout")){
					String user = controller.keeper.currentLoggedIn.username;
					controller.logout(user);
					System.out.println(user + " You Are currently logged out");

				}
				
				System.out.println();
				System.out.println();
				System.out.println("Enter z to continue");
				String t = scanner.next();
				while(!t.equals("z")){
					t = scanner.next();
				}
			}
		}
	}
}
