package TravelJournal;

import java.util.Date;

public class MyTravelLog implements TravelLog {

	String destination = "";
	int id = 0;
	Date date;
	String departurePoint = "";
	String travelMethod = "";
	String locationWeather = "";
	int distance = 0;
	int myRating = 0;
	
	@Override
	public boolean modifyTravelLog(String field, String toChange) {
		boolean success = true;
		if(field.equals("departurePoint"))
			departurePoint = toChange;
		else if(field.equals("travelMethod"))
			travelMethod = toChange;
		else if(field.equals("locationWeather"))
			locationWeather = toChange;
		else if(field.equals("destination"))
			destination = toChange;
		else if(field.equals("distance"))
			distance = Integer.parseInt(toChange);
		else
			success = false;
		return success;
	}

	@Override
	public int create(String destination, Date date) {
		
		this.destination = destination;
		this.date = date;
		id = (int)(Math.random()*100);//destination.length();
		return id;
	}
	
	@Override
	//can be expanded if further fields are added
	public int getData() {
		
		return distance;
	}

	@Override
	public TravelLog createNew(String destination) {
		//Unused
		return null;
	}

	@Override
	public int getDistance() {
		
		return distance;
	}

	@Override
	public boolean rateTrip(int rating) {
		
		myRating = rating;
		return myRating == rating;
	}
	
	@Override
	public int getRating()
	{
		return myRating;
	}
	
	@Override
	public Date getDate()
	{
		return date;
	}

}
