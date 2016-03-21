
public class Book {

	private String title;
	private String author;
	private String description;
	private double price;
	private boolean isInStock;
	private String sku;

	// Constructor	
	public Book() {
		title = "";
		author = "";
		description = "";
		price = 0.0;
	}

	// Constructor
	public Book(String value, double cost) {
		sku = value;
		title = "";
		author = "";
		description = "";
		price = cost;
	}

	// Constructor
	public Book(String _sku, String _title, String _author, String _description, double _price) {
		sku = _sku;
		title = _title;
		author = _author;
		description = _description;
		price = _price;
		isInStock = true;
	}


	//  Setters
	public void setSku(String value) {
		sku = value;
	}
	public void setTitle(String value) {
		title = value;
	}
	public void setAuthor(String value) {
		author = value;
	}
	public void setDescription(String value) {
		description = value;
	}
	public void setPrice(double value) {
		price = value;
	}
	public void setIsInStock(boolean value) {
		isInStock = value;
	}

	//  Getters
	public String getSku() {
		return sku;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public boolean getIsInStock() {
		return isInStock;
	}

	// Get Display Text	
	public String getDisplayText() {
		String displayText;
		displayText = (author + "\t" + title + "\t" + description );
		return displayText;
	}

	// Get Pricing for Requested Number of Books
	public double getBookPricing(int value) {
		int numRequest = value; 
		double pricing = 0.0;

		if (isInStock == true) {
			pricing = numRequest * price;
		}	else {
			pricing = -1.0;
		}
		return pricing;
	}

}
