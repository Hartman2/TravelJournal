package TravelJournal;

import java.util.Date;
import java.util.HashMap;

public class MyJournal implements Journal {

	HashMap<Integer, TravelLog> travelLogs = new HashMap<Integer, TravelLog>();
	String journalName = "";
	@Override
	public int createLog(String destination, Date date) {
		TravelLog tl = new MyTravelLog();
		int logID = tl.create(destination, date);
		travelLogs.put(logID, tl);
		return logID;
	}

	@Override
	public TravelLog getLog(int id) {
		
		TravelLog tl = travelLogs.get(id);
		return tl;
	}

	@Override
	public boolean modifyLog(TravelLog t, String field, String toChange) {
		boolean success  = t.modifyTravelLog(field, toChange);
		
		return success;
	}

	@Override
	public boolean deleteLog(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		
		return journalName;
	}

}
