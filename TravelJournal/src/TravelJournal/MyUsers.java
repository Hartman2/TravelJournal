package TravelJournal;

import java.util.Date;

public class MyUsers implements Users {

	MyUsers()
	{
		
	}
	@Override
	public boolean logout(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int createLog(String destination, Date date, String Journal) {
		// TODO Auto-generated method stub
		
		return 0;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editUser(String name, String field, String toChange) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean createJournal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(String field, String change) {
		// TODO Auto-generated method stub
		return false;
	}

}
