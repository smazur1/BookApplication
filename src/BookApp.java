import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sku;
		String displayText;
		int numBooks = 0;
		double price = 0.0;
		String title;

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter Book SKU : ");
		sku = keyboard.next();

		try {
			Book b = BookDB.getBook(sku);

			displayText = b.getDisplayText();
			System.out.println("Author   \t\t\t\t  Title  \t\t\t Description");
			System.out.println(displayText);

			System.out.println("How many copies of this book do you want to order? ");
			numBooks = keyboard.nextInt();
			price = b.getBookPricing(numBooks);
			if (price < 0.0) {
				System.out.println("This book is not in stock");
			}
			else {
				title = b.getTitle();
				System.out.printf(numBooks + " copies of " + "'" + title + "'" + " costs $%.2f%n" , price );

			}


		} catch (IllegalArgumentException e) {
			System.out.println("Book not found");
		}



	}

}
