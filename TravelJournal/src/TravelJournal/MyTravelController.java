package TravelJournal;

import java.util.Date;

public class MyTravelController implements TravelController {

	@Override
	public boolean login(String name, String password) {
		
		TravelLogKeeper keeper = new MyTravelLogKeeper();
		boolean login = keeper.login(name, password);
		
		return login;
	}

	@Override
	public boolean logout(String name) {

		MyTravelLogKeeper keeper = new MyTravelLogKeeper();
		boolean logout = keeper.logout(name);
		
		return logout;
	}

	@Override
	public int createLog(String destination, Date date, String Journal) {
		
		TravelLogKeeper keeper = new MyTravelLogKeeper();
		int logID = keeper.createLog(destination, date, Journal);
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

		TravelLogKeeper keeper = new MyTravelLogKeeper();
		boolean createUser = keeper.addUser(name, password);
		
		return createUser;
	}

	@Override
	public boolean editUser(String name, String field, String toChange) {

		MyTravelLogKeeper keeper = new MyTravelLogKeeper();
		boolean editUser = keeper.editUser(name, field, toChange);
		
		
		return editUser;
	}

	@Override
	public boolean removeUser(String name) {

		MyTravelLogKeeper keeper = new MyTravelLogKeeper();
		boolean removeUser = keeper.removeUser(name);
		
		return removeUser;
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
