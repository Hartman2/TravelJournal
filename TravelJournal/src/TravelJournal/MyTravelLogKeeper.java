package TravelJournal;

import java.util.Date;

public class MyTravelLogKeeper implements TravelLogKeeper {

	//holds all of the users registered.
	MyDataBase data = new MyDataBase();
	MyTravelLogKeeper()
	{
		
	}

	@Override
	public boolean login(String name, String password) {

		if(data.getUser(name, password) == null){
			return false;
		}
		else
		return true;
	}

	@Override
	public boolean logout(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int createLog(String destination, Date date, String Journal) {
		
		Users theUser = new MyUsers();
		int logID = theUser.createLog(destination, date, Journal);
		return logID;
	}

	@Override
	public boolean modifyLog(int id, String field, String toChange) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean deleteLog(int id, int jid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(String name, String password) {

		MyUsers user = new MyUsers();
		user.create(name, password);
		data.putUser(user);
		
		return true;
	}

	@Override
	public boolean editUser(String name, String field, String toChange) {

		data.getUser(name).editUser(name, field, toChange);
		
		return true;
	}

	@Override
	public boolean removeUser(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nameJournal(String currentName, String newName) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean create() {
		// TODO Auto-generated method stub
		return false;
	}
}
