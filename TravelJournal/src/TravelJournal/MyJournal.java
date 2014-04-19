package TravelJournal;

import java.util.ArrayList;
import java.util.Date;

public class MyJournal implements Journal {

	ArrayList<TravelLog> travelLogs = new ArrayList<TravelLog>();
	@Override
	public int createLog(String destination, Date date) {
		TravelLog tl = new MyTravelLog();
		int logID = tl.create(destination, date);
		travelLogs.add(tl);
		return logID;
	}

	@Override
	public TravelLog getLog(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyLog(TravelLog t) {
		// TODO Auto-generated method stub
		return false;
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

}
