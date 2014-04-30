package TravelJournal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyUsers implements Users {
	String username;
	String password;
	String attribute;
	protected MyDataBase db = new MyDataBase();
	MyUsers()
	{
		
	}

	@Override
	public int createLog(String destination, Date date, String Journal) {
		
		if(db.getJournal(Journal) == null)
		{
			Journal j = createJournalAlt();
			j.editName(Journal);
			db.putJournal(j);
			System.out.println("New Journal Created id = " + j.getID());
		}
		Journal toEdit = db.getJournal(Journal);
		int id = toEdit.createLog(destination, date);
		db.putJournal(toEdit);
		return id;
	}

	@Override
	public boolean modifyLog(int jid, int id, String field, String toChange) {
		
		Journal toEdit = db.getJournal(jid);
		TravelLog tl = toEdit.getLog(id);
		boolean success = toEdit.modifyLog(tl, field, toChange);
		db.putJournal(toEdit);
		
		return success;
	}

	@Override
	public boolean deleteLog(int id, int jid) {

		Journal j = db.getJournal(jid);
		return j.deleteLog(id);
	}
	@Override
	public boolean nameJournal(String currentName, String newName) {
		
		Journal j = db.getJournal(currentName);
		boolean change = j.editName(newName);
		db.putJournal(j);
		return change;
	}

	@Override
	public boolean modifyLog(TravelLog t) {
		
		return false;
	}

	@Override
	public boolean deleteLog(int id) {
		
		return false;
	}

	@Override
	public boolean createJournal() {
		
		return false;
	}

	@Override
	public boolean create(String name, String password) {
		
		username = name;
		this.password = password;
		
		return username.equals(name);
	}

	@Override
	public boolean modify(String field, String change) {

		if(field.equals("attribute"))
			attribute = change;

		return attribute.equals(change);
	}	
	
	/*********************ITERANTION 2 ********************************************/

	@Override
	public List<TravelLog> viewAllLogs() {
		
		List<Journal> journals = db.getAllJournals();
		List<TravelLog> tl = new ArrayList<TravelLog>();
		for(Journal j : journals )
		{
			tl.addAll(j.getAllLogs());
		}
		
		return tl;
	}

	@Override
	public int viewData() {

		int distanceTraveledFromAllJournals = 0;
		List<Journal> journals = db.getAllJournals();
		for(int i = 0; i < journals.size(); i++){
			distanceTraveledFromAllJournals = distanceTraveledFromAllJournals + journals.get(i).getAllData();
		}
		
		return distanceTraveledFromAllJournals;
	}

	@Override
	public boolean addWish(String destination) {
		
		boolean wish = db.storeWishList(destination);
		return wish;
	}

	@Override
	public boolean planTrip(String destination) {
		
		MyTravelLog log = new MyTravelLog();
		log.createNew(destination);
		
		return db.storeFutureTrip(log);
	}

	@Override
	public int viewTripDistance(int tid, int jid) {
		
		Journal j = db.getJournal(jid);
		TravelLog tl = j.getLog(tid);
		int distance = tl.getDistance();
		return distance;
	}

	@Override
	public List<TravelLog> sortDate() {
		
		List<Journal> j = db.getAllJournals();
		List<TravelLog> toReturn = new ArrayList<TravelLog>();
		for(Journal journal : j)
		{
			List<TravelLog> tmp = journal.sort("Date");
			if(toReturn.size() == 0)
				toReturn.addAll(tmp);
			else
			{
				for(TravelLog t : tmp)
				{
					int i = 0;
					while(i< toReturn.size() && t.getDate().before(toReturn.get(i).getDate()))
						i++;
					toReturn.add(i, t);
				}
			}
		}
		return toReturn;
	}

	@Override
	public List<TravelLog> sortRating() {
		
		List<Journal> j = db.getAllJournals();
		List<TravelLog> toReturn = new ArrayList<TravelLog>();
		for(Journal journal : j)
		{
			List<TravelLog> tmp = journal.sort("Rating");
			if(toReturn.size() == 0)
				toReturn.addAll(tmp);
			else
			{
				for(TravelLog t : tmp)
				{
					int i = 0;
					while(i< toReturn.size() && t.getRating() < toReturn.get(i).getRating())
						i++;
					toReturn.add(i, t);
				}
			}
		}
		return toReturn;
	}

	@Override
	public boolean addAttributes(String attribute) {

		this.attribute = attribute;
		return this.attribute.equals(attribute);
	}

	@Override
	public Journal createJournalAlt() {
		
		Journal j = new MyJournal();
		int jid = j.create();
		System.out.println("New Journal with id: " + jid);
		db.putJournal(j);
		return j;
	}

	@Override
	public boolean rateTrip(int jid, int tid, int rating) {
	
		Journal j = db.getJournal(jid);
		TravelLog tl = j.getLog(tid);
		boolean rate = tl.rateTrip(rating);
		return rate;
	}

	@Override
	public boolean deleteJournal(int id) {
		
		boolean delete = db.removeJournal(id);
		return delete;
	}

	@Override
	public List<String> viewWishList() {
		
		ArrayList<String> wishList = (ArrayList<String>) db.viewWishList();
		return wishList;
	}	
	
	
}
