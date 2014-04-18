package TravelJournal;

import java.util.Date;

public interface TravelLog {

	
	
	/**
	 * modifies given travel log
	 * @param field
	 * @param toChange
	 * @return
	 */
	public boolean modifyTravelLog(String field, String toChange);
	
	/**
	 * create a new Travel log
	 * @param destination
	 * @param date
	 * @return - returns id of log
	 */
	public int create(String destination, Date date);
	
	
}
