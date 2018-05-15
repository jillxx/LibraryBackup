import java.time.LocalDate;

public class Book {

	private String bookID;
	private String bookTitle;
	private String author;
	private String status;
	private String borrower;
	private LocalDate dueDate;
	private int counter;


	public Book(String bookTitle, String author, String status, int counter,String bookID) {
		super();
		this.author = author;
		this.bookTitle = bookTitle;
		this.status = status;
		this.counter = counter;
		this.bookID=bookID;
	}
	

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {

		return String.format("%1$-4d %2$-50s %3$-20s %4$-10s %5$-15s",counter, bookTitle, author,bookID,status);
	}

}
