import java.util.ArrayList;

/*A Club class that holds basic details about each fitness club, including at minimum:

name, address*/


public class Club {

	private String name;
	private String address;
	
	public Club (String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Club" + name + "address" + address;
	}
	
}
