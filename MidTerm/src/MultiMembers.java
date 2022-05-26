
public class MultiMembers extends MemberDetails {
	private int memPoints;
	
	public int getMemPoints() {
		return memPoints;
	}
	public void setMemPoints(int memPoints) {
		this.memPoints = memPoints;
	}
	
	public MultiMembers(String name, int memPoints ) {
		super(name);
		this.memPoints = memPoints;
		
	}
	
	@Override
	public void checkIn(Club club) {
		this.memPoints =+ 5;
		
	}

}
