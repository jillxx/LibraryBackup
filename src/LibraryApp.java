import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) {
		String count = "y";
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Library!");
		System.out.println();
		String userID = Validator.getString(scan, "Please enter your name: ");
		int userChoice = 0;
		ActionMethod.wholeArrayAdd();
		
		while (userChoice != 5) {
			System.out.print(userID + ", ");
			System.out.println("Please choose from the options below:");
			System.out.println("1. Search by category");
			System.out.println("2. Display our inventory");
			System.out.println("3. Return");
			System.out.println("4. Donate book");
			System.out.println("5. Quit");

			userChoice = scan.nextInt();
			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			if (userChoice == 1) {
				int searchChoice = Validator.getInt(scan, "1. Search by author\n2. Search by title keyword\nPlease enter the number:  ", 1, 2);

				if (searchChoice == 1) {
					String author = Validator.getString(scan, "Please enter author: ");
					ActionMethod.researchAuthor(author, userID);
					int bookIDNum = Validator.getInt(scan, "\nPlease enter the bookID number you want to borrow: ");
					ActionMethod.searchCheckout(bookIDNum, userID);
				}

				else if (searchChoice == 2) {
					String keyword = Validator.getString(scan, "Please enter title keyword: ");
					ActionMethod.researchKeyword(keyword, userID);
					int bookIDNum = Validator.getInt(scan, "\nPlease enter the bookID number you want to borrow: ");
					ActionMethod.searchCheckout(bookIDNum, userID);
					
				} else {
					System.out.println("The choice you entered is not avaiable");

				}

			}
			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			if (userChoice == 2) {
				System.out.println("The books in our library are listed below: ");// done
				ActionMethod.readFromBookList();

				// check out and set duedate
				// already checked out. show message
				while (count.equalsIgnoreCase("y")) {
					int bookID = Validator.getInt(scan, "\nPlease enter the bookID number you want to borrow: ");
					ActionMethod.checkOut(userID, bookID);
					count = Validator.getString(scan, "Would you like to borrow another book? (y/n)");

				}
			
			}

			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			if (userChoice == 3) {
				ActionMethod.pullRentList(userID);
				int bookID = Validator.getInt(scan, "What book would you like to return? (enter BookID): ", 100, 111);

				ActionMethod.returnMethod(bookID);
				System.out.println("Please put the book on the shelf. Thank you!\n");
			}
			if (userChoice == 4) {
				String userString = Validator.getString(scan, "Enter a book and author:(name,author)");
				ActionMethod.addBook(userString);
				System.out.println("Thank you for donating books.");

			}
		}
		System.out.println("Thank you for visiting our library~!");
		scan.close();
	}
}
