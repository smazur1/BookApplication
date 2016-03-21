import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sku;
		String displayText;
		int numBooks = 0;
		double price = 0.0;
		String title;
		String choice = "";
		String desc = "";
		int numberUpdated = 0;
		String author = "";

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Do you want to (F)ind a book, (U)pdate descripton, or (I)nsert a book? : ");

		choice = keyboard.nextLine();
		if (choice.equalsIgnoreCase("f")) {

			System.out.println("Enter Book SKU : ");
			sku = keyboard.nextLine();

			try {

				BookDB bdb = new BookDB();
				Book b = bdb.getBook(sku);

				displayText = b.getDisplayText();
				System.out.println("Author   \t\t  Title  \t\t\t\t Description");
				System.out.println(displayText);

				System.out.println("\nHow many copies of this book do you want to order? ");
				numBooks = keyboard.nextInt();
				keyboard.nextLine();
				price = b.getBookPricing(numBooks);
				if (price < 0.0) {
					System.out.println("This book is not in stock");
				} else {
					title = b.getTitle();
					System.out.printf(numBooks + " copies of " + "'" + title + "'" + " costs $%.2f%n", price);

				}

			} catch (IllegalArgumentException e) {
				System.out.println("Book not found");
			}

		} else if (choice.equalsIgnoreCase("u")) {

			System.out.println("Enter Book SKU : ");
			sku = keyboard.nextLine();
			System.out.println("Enter new description : ");
			desc = keyboard.nextLine();

			try {

				BookDB bdb = new BookDB();

				numberUpdated = bdb.updateDescription(sku, desc);
				System.out.println("Number of books updated = " + numberUpdated);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();

			}
		} else if (choice.equalsIgnoreCase("i")) {

			System.out.println("Enter Book SKU : ");
			sku = keyboard.nextLine();
			System.out.println("Enter Title : ");
			title = keyboard.nextLine();
			System.out.println("Enter Author : ");
			author = keyboard.nextLine();
			System.out.println("Enter Description : ");
			desc = keyboard.nextLine();
			System.out.println("Enter Price : ");
			price = keyboard.nextDouble();
			keyboard.nextLine();

			try {

				BookDB bdb = new BookDB();

				numberUpdated = bdb.insertBook(sku, title, author, desc, price);
				System.out.println("Number of books Inserted = " + numberUpdated);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();

			}
		} else if (choice.equalsIgnoreCase("d")) {

			System.out.println("Enter Book SKU to delete : ");
			sku = keyboard.nextLine();

			try {

				BookDB bdb = new BookDB();

				numberUpdated = bdb.deleteBook(sku);
				System.out.println("Number of books deleted = " + numberUpdated);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();

			}
		}
		keyboard.close();
	}
}
