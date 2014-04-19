package TravelJournal;

import java.util.HashMap;

public class MyDataBase implements DataBase {

	HashMap<String, Journal> journals = new HashMap<String, Journal>();
	MyDataBase()
	{
		
	}
	@Override
	public Users getUser(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean putUser(Users u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Journal getJournal(String name) {
		return journals.get(name);
	}

	@Override
	public Journal getJournal(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean putJournal(Journal j) {
		// TODO Auto-generated method stub
		return false;
	}

}
