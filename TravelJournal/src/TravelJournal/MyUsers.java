package TravelJournal;

import java.util.Date;
import java.util.HashMap;

public class MyUsers implements Users {
	String username;
	String password;
	private MyDataBase db = new MyDataBase();
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
		
		Journal toEdit = db.getJournal(Journal);
		toEdit.createLog(destination, date);
		db.putJournal(toEdit);
		return 0;
	}

	@Override
	public boolean modifyLog(int id, String field, String toChange) {
		
		Journal toEdit = db.getJournal(id);
		TravelLog tl = toEdit.getLog(0);//need new id field
		boolean success = toEdit.modifyLog(tl, field, toChange); //needs extra parameters
		db.putJournal(toEdit);
		
		return success;
	}

	@Override
	public boolean deleteLog(int id, int jid) {

		Journal j = db.getJournal(jid);
		j.deleteLog(id);
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
		
		username = name;
		this.password = password;
		
		return false;
	}

	@Override
	public boolean modify(String field, String change) {
		// TODO Auto-generated method stub
		return false;
	}	
	
}
