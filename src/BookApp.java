import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sku;
		String displayText;

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter Book SKU : ");
		sku = keyboard.next();

		try {
			Book java1Book = BookDB.getBook(sku);

			displayText = java1Book.getDisplayText();
			System.out.println("Author   \t\t\t\t  Title  \t\t\t Description");
			System.out.println(displayText);
		} catch (IllegalArgumentException e) {
			System.out.println("Book not found");
		}
	}

}
