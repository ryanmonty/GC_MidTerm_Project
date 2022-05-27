import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingleMembersTest {

	@Test
	void testGetClub() {
		SingleMembers sm = new SingleMembers("Bruce", "Gym");
		assertEquals("Gym", sm.getClubName());
	}

	@Test
	void testGetName() {
		SingleMembers sm = new SingleMembers("Bruce", "Gym");
		assertEquals("Bruce", sm.getName());
	}

	@Test
	void testCheckIn() {
		Club club = new Club("Clubby McClubClub", "123 Club Street");
		assertEquals("Clubby McClubClub", club.getName());
		assertEquals("123 Club Street", club.getAddress());
	}
	//FINISH??
	@Test
	void testIncorrectCheckinLocation() {
		SingleMembers sm = new SingleMembers("Regina", "Correct Club");
		Club club = new Club("She doesn't even go here Club", "123 Mean Girls Street");
		
		
	}

}
