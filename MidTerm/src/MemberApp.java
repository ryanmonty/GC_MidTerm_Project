import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MemberApp {

	private static ArrayList<MemberDetails> members = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// switch statement:
		// add, delete, display member info
		Club[] clubs = { new Club("DownTownFit", "123 Downtown Street"),
				new Club("FitnessThisWholeBurgerInMyMouth", "Foodcourt"), new Club("UpTownFit", "321 Uptown Street"),
				new Club("CornerTownFit", "000 Cornertown Street") };

		members.add(new SingleMembers("John Doe", clubs[0].getName()));
		members.add(new SingleMembers("Mary Moe", clubs[2].getName()));
		members.add(new MultiMembers("Jack Foe", 0));
		members.add(new MultiMembers("Emily Toe", 5));

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
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
					String newMemHomeClub = getUserInput("What is the name of their Home club?"
							+ "\n1. DownTownFit\n2. FitnessThisWholeBurgerInMyMouth\n3. UpTownFit\n4. CornerTownFit",
							scan);
					members.add(new SingleMembers(newMemName, clubs[Integer.parseInt(newMemHomeClub) - 1].getName()));

				} else if (newMemType.equals("multi")) {
					members.add(new MultiMembers(newMemName, 0));
				} else {
					System.out.println("Please Select an appropriate option.");
				}
			} else if (userChoice == 2) {
				HashMap<Integer, String> memberMap = convertArrayListToHashMap(members);

				// printing the HashMap
				for (Entry<Integer, String> entry : memberMap.entrySet()) {

					System.out.println(entry.getKey() + ". " + entry.getValue());
				}
				System.out.println("Please select a member by ID number");
				int memId = scan2.nextInt();

				for (MemberDetails member : members) {

					if (member.getId() == memId) {
						System.out.println(member.toString());

						System.out.println(
								"Please select an option: \n1. Check Member In\n2. Current Balance\n3. Cancel Membership");
						int choice = scan2.nextInt();

						switch (choice) {
						case 1:
							String homeClubChoice = getUserInput("What is the name of their Home club?"
									+ "\n1. DownTownFit\n2. FitnessThisWholeBurgerInMyMouth\n3. UpTownFit\n4. CornerTownFit",
									scan);
							if (member instanceof SingleMembers) {
								try {
									member.checkIn(clubs[Integer.parseInt(homeClubChoice) - 1]);
								} catch (ArrayIndexOutOfBoundsException e) {
									System.out.println("Please select from one of the existing clubs");
								}
							} else {
								member.checkIn(null);
								System.out.println("Be sure to tell " + member.getName()
										+ " about their 5 new membership points!");
							}
						}
					}

				}
			} else {
				willContinue = false;
			}
			System.out.println("Continue? (y/n)");
			String userWantsToContinue = scan.nextLine();
			if (userWantsToContinue.toLowerCase().startsWith("y")) {
				willContinue = true;
			} else {
				willContinue = false;
			}
		} while (willContinue);
		scan.nextLine();
		System.out.println("Goodbye!");

	}
	
	private static String getUserInput(String prompt, Scanner scan) {
		System.out.println(prompt);
		return scan.nextLine();
	}

	private static LinkedHashMap<Integer, String> convertArrayListToHashMap(ArrayList<MemberDetails> members) {

		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

		for (MemberDetails member : members) {

			linkedHashMap.put(member.getId(), member.getName());
		}

		return linkedHashMap;
	}

}
