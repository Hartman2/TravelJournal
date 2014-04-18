package TravelJournal;

import java.util.Date;

public class MyTravelLog implements TravelLog {

	String destination = "";
	int id = 0;
	Date date;
	
	@Override
	public boolean modifyTravelLog(String field, String toChange) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int create(String destination, Date date) {
		// TODO Auto-generated method stub
		this.destination = destination;
		this.date = date;
		id++;
		return id;
	}

}
