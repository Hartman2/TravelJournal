package TravelJournal;

import java.util.Date;

public interface Users {


	
	/**
	 * creates log
	 * @param destination
	 * @param date
	 * @param Journal
	 * @return log id
	 */
	public int createLog(String destination, Date date, String Journal);
	
	/**
	 * modify's log
	 * @param id
	 * @param field
	 * @param toChange
	 * @return returns true if able to change. false otherwise
	 */
	public boolean modifyLog(int id, String field, String toChange);
	
	/**
	 * delete log
	 * @param id
	 * @param jid
	 * @return - return true if log is deleted. false otherwise
	 */
	public boolean deleteLog(int id, int jid);
	
	/**
	 * change name of journal
	 * @param currentName
	 * @param newName
	 * @return - return true if journal name is true, otherwise false
	 */
	public boolean nameJournal(String currentName, String newName);
	

	/**
	 * Change the attributes of travel log
	 * @param t
	 * @return - true if modification is true. false otherwise
	 */
	public boolean modifyLog(TravelLog t);
	
	/**
	 * delete a travel log
	 * @param id
	 * @return - true if log is deleted, false otherwise
	 */
	public boolean deleteLog(int id);
	
	
	/**
	 * creates a new journal?
	 * @return
	 */
	public boolean createJournal();
	
	
	/**
	 * create new user
	 * @param name
	 * @param password
	 * @return - returns true if successful. false
	 */
	public boolean create(String name, String password);
	
	/**
	 * change field of user 
	 * @param field
	 * @param change
	 * @return - true if modified. false otherwise
	 */
	public boolean modify(String  field, String change);
	
}
