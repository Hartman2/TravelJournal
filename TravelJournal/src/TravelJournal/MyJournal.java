package TravelJournal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyJournal implements Journal {

	HashMap<Integer, TravelLog> travelLogs = new HashMap<Integer, TravelLog>();
	String journalName = "";
	int journalID = 0;
	
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
		
		boolean delete = (travelLogs.remove(id) != null);
		return delete;
	}

	@Override
	public boolean editName(String name) {
		
		journalName = name;
		return journalName.equals(name);
	}

	@Override
	public int create() {
		
		journalID = (int)(Math.random()*100);
		return journalID;
	}

	@Override
	public String getName() {
		
		return journalName;
	}

	@Override
	public int getID() {
		
		return journalID;
	}

	@Override
	public List<TravelLog> getAllLogs() {
		
		Collection<TravelLog> tl = travelLogs.values();
		List<TravelLog> logs  = new ArrayList<TravelLog>();
		for(TravelLog log : tl)
		{
			logs.add(log);
		}
		
		return logs;
	}

	@Override
	public int getAllData() {
		
		int distanceTraveledInJournal= 0;
		List<TravelLog> logs = getAllLogs();
		for(int i = 0; i < logs.size(); i++){
			distanceTraveledInJournal = distanceTraveledInJournal + logs.get(i).getData();
		}
			
		return distanceTraveledInJournal;
	}

	@Override
	public List<TravelLog> sort(String by) {
		
		List<TravelLog> unsorted = getAllLogs();
		List<TravelLog> sorted = new ArrayList<TravelLog>();
		if(by.equalsIgnoreCase("Date"))
		{
			for(TravelLog tl : unsorted)
			{
				Date date = tl.getDate();
				if(sorted.size() == 0)
					sorted.add(tl);
				else
				{
					int i = 0;
					while(i < sorted.size() && date.before(sorted.get(i).getDate()))
					{
						i++;
					}
					sorted.add(tl);
				}
			}
		}
		else if(by.equalsIgnoreCase("Rating"))
		{
			int other = 0;
			for(TravelLog tl : unsorted)
			{
				int rate = tl.getRating();
				if(sorted.size() == 0)
				{
					sorted.add(tl);
					other = sorted.get(0).getRating();
				}
				else
				{
					int i = 0;
					while(i < sorted.size() && rate < other)
					{
						i++;
						if(i < sorted.size())
							other = sorted.get(i).getRating();
					}
					sorted.add(tl);
				}
			}
		}
		return sorted;
	}


}
