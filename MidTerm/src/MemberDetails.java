
public abstract class MemberDetails {

	private String name;
	private int id = 0;
	private static int nextId = 1;
	private int fees; 
	private int months;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public MemberDetails() {
		super();
	}
	//add First and last name
	public MemberDetails(String name) {
		super();
		this.name = name;
		this.id = nextId;
		this.months = 1;
		this.fees = 10;
		nextId++;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\n" + "ID:" + id + "\n";
	}
	public abstract void checkIn(Club club);
	
	
}
