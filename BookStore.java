package cm4BookStore;

public class BookStore {
	public static void main(String[] args) {

		Book bookCat = new Book();
		bookCat.setId("B1");
		bookCat.setAuthor("Cam");
		bookCat.setISBN(123);
		bookCat.setName("Cat in the Hat");

		Book bookDog = new Book();
		bookDog.setId("B2");
		bookDog.setAuthor("Sam");
		bookDog.setISBN(234);
		bookDog.setName("Dog in Space");

		Book bookCow = new Book();
		bookCow.setId("B3");
		bookCow.setAuthor("Tin");
		bookCow.setISBN(345);
		bookCow.setName("Cow goes moo");

		Book bookPig = new Book();
		bookPig.setId("B3");
		bookPig.setAuthor("Ton");
		bookPig.setISBN(456);
		bookPig.setName("Pig in the City");

		Book[] books = { bookCat, bookDog, bookCow, bookPig };

		Location location1 = new Location();
		location1.setName("Quan 1");
		location1.setId("L1");
		location1.setAddress("12 Vo Thi Sau");

		Location location2 = new Location();
		location2.setName("Quan 3");
		location2.setId("L1");
		location2.setAddress("7 Nam Ki Khoi Nghia");

		Location[] locations = { location1, location2 };

		Customer customer1 = new Customer();
		customer1.setId("C1");
		customer1.setName("Andrew");

		Customer customer2 = new Customer();
		customer2.setId("C2");
		customer2.setName("Georgia");

		Customer customer3 = new Customer();
		customer3.setId("C3");
		customer3.setName("Stephanie");

		Customer[] customers = { customer1, customer2, customer3 };

		Type type1 = new Type();
		type1.setId("T1");
		type1.setName("Horror");

		Type type2 = new Type();
		type2.setId("T2");
		type2.setName("Comedy");

		Type type3 = new Type();
		type3.setId("T4");
		type3.setName("Sci-fi");

		Type type4 = new Type();
		type4.setId("T5");
		type4.setName("Thrill");

		Type[] types = { type1, type2, type3, type4 };

		BookType bookCatType = new BookType();
		bookCatType.book = bookCat;
		bookCatType.type = new Type[2];
		bookCatType.type[0] = type1;
		bookCatType.type[1] = type2;

		BookType bookDogType = new BookType();
		bookDogType.book = bookDog;
		bookDogType.type = new Type[2];
		bookDogType.type[0] = type3;
		bookDogType.type[1] = type4;

		BookType bookPigType = new BookType();
		bookPigType.book = bookDog;
		bookPigType.type = new Type[3];
		bookPigType.type[0] = type1;
		bookPigType.type[1] = type3;
		bookPigType.type[2] = type3;

		BookType bookCowType = new BookType();
		bookCowType.book = bookCow;
		bookCowType.type = new Type[3];
		bookCowType.type[0] = type4;
		bookCowType.type[1] = type2;
		bookCowType.type[2] = type3;

		BookType[] bookTypes = { bookCatType, bookDogType, bookPigType, bookCowType };

		BookLocation bookCatLocation = new BookLocation();
		bookCatLocation.book = bookCat;
		bookCatLocation.location = location1;
		bookCatLocation.setAvailableQuantity(15);

		BookLocation bookDogLocation = new BookLocation();
		bookDogLocation.book = bookDog;
		bookDogLocation.location = location2;
		bookDogLocation.setAvailableQuantity(30);

		BookLocation bookCowLocation = new BookLocation();
		bookCowLocation.book = bookCow;
		bookCowLocation.location = location1;
		bookCowLocation.setAvailableQuantity(27);

		BookLocation bookPigLocation = new BookLocation();
		bookPigLocation.book = bookPig;
		bookPigLocation.location = location1;
		bookPigLocation.setAvailableQuantity(12);

		BookLocation[] bookLocations = { bookCatLocation, bookDogLocation, bookCowLocation, bookPigLocation };

		BorrowReturnDetail detail1 = new BorrowReturnDetail(bookCat, customer1);
		detail1.setBorrowed(true);
		detail1.setBorrowDate("18-03-2023");
		detail1.setReturned(true);
		detail1.setReturnDate("20-03-2023");

		BorrowReturnDetail detail2 = new BorrowReturnDetail(bookCow, customer1);
		detail2.setBorrowed(true);
		detail2.setBorrowDate("18-03-2023");
		detail2.setReturned(true);
		detail2.setReturnDate("15-03-2023");

		BorrowReturnDetail detail3 = new BorrowReturnDetail(bookDog, customer1);
		detail3.setBorrowed(true);
		detail3.setBorrowDate("01-03-2023");
		detail3.setReturned(false);

		BorrowReturnDetail detail4 = new BorrowReturnDetail(bookDog, customer2);
		detail4.setBorrowed(true);
		detail4.setBorrowDate("15-02-2023");
		detail4.setReturned(true);
		detail4.setReturnDate("30-03-2023");

		BorrowReturnDetail detail5 = new BorrowReturnDetail(bookCow, customer3);
		detail5.setBorrowed(true);
		detail5.setBorrowDate("23-04-2023");
		detail5.setReturned(true);
		detail5.setReturnDate("30-04-2023");

		BorrowReturnDetail[] borrowReturnDetails = { detail1, detail2, detail3, detail4, detail5 };

		System.out.println("1. Borrow list");

		for (BorrowReturnDetail borrowReturnDetail : borrowReturnDetails) {
			System.out.println(borrowReturnDetail.book.getName() + " by " + borrowReturnDetail.customer.getName()
					+ " on " + borrowReturnDetail.getBorrowDate());
		}

		System.out.println("\n\n\n");

		getBookStatus(books, borrowReturnDetails);

		getBookByType(types, bookTypes);

	}

	public static void getBookStatus(Book[] books, BorrowReturnDetail[] borrowReturnDetails) {

		System.out.println("2. Borrow and return status of a book: ");
		for (Book book : books) {
			System.out.println(book.getName());
			boolean hasDetails = false;
			for (BorrowReturnDetail detail : borrowReturnDetails) {
				if (detail.book == book) {
					hasDetails = true;
					if (detail.getReturnDate() == null) {
						System.out.println("- Borrowed by " + detail.customer.getName() + " on "
								+ detail.getBorrowDate() + " and hasn't been returned yet.");
					} else {
						System.out.println("- Borrowed by " + detail.customer.getName() + " on "
								+ detail.getBorrowDate() + " and returned on " + detail.getReturnDate() + ".");

					}

				}

			}
			if (!hasDetails) {
				System.out.println("No borrow/return record found for this book");

			}
			System.out.println("---");
		}
		System.out.println("\n\n\n");
	}

	public static void getBookByType(Type[] types, BookType[] bookTypes) {
		System.out.println("3. Get books by Type: ");
		for (Type type : types) {
			System.out.println(type.getName() + " books: ");

			for (BookType bookType : bookTypes) {
				for (Type bookTypeType : bookType.type) {
					if (bookTypeType.getId().equals(type.getId())) {
						System.out.println("- " + bookType.book.getName());
						break;
					}
				}
			}
			System.out.println("\n");
		}
	}
}
