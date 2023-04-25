package cm4BookStore;

public class BorrowReturnDetail {
	Book book;
	Customer customer;
	private boolean borrowed;
	private boolean returned;
	private String returnDate;
	private String borrowDate;
	
	public BorrowReturnDetail(Book book, Customer customer) {
		this.book = book;
		this.customer = customer;
		this.borrowed = false;
		this.returned = false;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	

}
