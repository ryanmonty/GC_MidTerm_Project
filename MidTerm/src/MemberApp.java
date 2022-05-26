import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class MemberApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// switch statement:
		// add, delete, display member info
		Club[] clubs = { new Club("DownTownFit", "123 Downtown Street"),
				new Club("FitnessThisWholeBurgerInMyMouth", "Foodcourt"), 
				new Club("UpTownFit", "321 Uptown Street"),
				new Club("CornerTownFit", "000 Cornertown Street") };

		ArrayList<MemberDetails> members = new ArrayList<>();
		members.add(new SingleMembers("John Doe", clubs[0].getName()));
		members.add(new SingleMembers("Mary Moe", clubs[2].getName()));
		members.add(new MultiMembers("Jack Foe", 0));
		members.add(new MultiMembers("Emily Toe", 5));

		Scanner scan = new Scanner(System.in);
		boolean willContinue = false;

		System.out.println("Welcome to the Member Management App!! \n ");

		do {
			System.out.println("Please Select an option?\n1. Adding Members\n2. Member Checkin");
			int userChoice = scan.nextInt();
			scan.nextLine();

			if (userChoice == 1) {
				String newMemName = getUserInput("What is the new member's name?", scan);
				String newMemType = getUserInput("Are they choosing a single or multi membership?", scan);
				
				if (newMemType.equals("single")) {
					String newMemHomeClub = getUserInput("What is the name of their Home club?" + 
							"\n1. DownTownFit\n2. FitnessThisWholeBurgerInMyMouth\n3. UpTownFit\n4. CornerTownFit", scan);
					members.add(new SingleMembers(newMemName, clubs[Integer.parseInt(newMemHomeClub) -1].getName()));
					
				}
				else if (newMemType.equals("multi")) {
					members.add(new MultiMembers(newMemName, 0));
				}
				else {
					System.out.println("Please Select an appropriate option.");
				}
			} else if (userChoice == 2) {
				System.out.println(members.toString());
			} else {
				willContinue = false;
			}

			String userWantsToContinue = getUserInput("Would you like to continue? (y/n)", scan);
			if (userWantsToContinue.toLowerCase().startsWith("y")) {
				willContinue = true;
			} else {
				willContinue = false;
			}
		} while (willContinue);
		scan.close();
		System.out.println("Goodbye!");
	}

	private static String getUserInput(String prompt, Scanner scan) {
		System.out.println(prompt);
		return scan.nextLine();
	}
	

}
