package Collections;
import java.util.ArrayList;
class Book{
	int bookId;
	String title;
	String author;
	float price;
	public Book(int bookId,String title,String author,float price) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public void displayBook() {
		System.out.println("BookId: "+bookId);
		System.out.println("Book title: "+title);
		System.out.println("Book author: "+author);
		System.out.println("price: "+price);
	}
}
public class BookInventorySystem{
	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<>();
		
		//create 
		books.add(new Book(1001,"Let Us C","Yashwantkar",450));
		books.add(new Book(1003,"Seven Ages","Wiliam Shakespeare",390));
		books.add(new Book(1005,"Normal People","Sally Booney",290));
		
		//display
		for(Book book:books) {
			System.out.println(book.bookId+" "+book.title+" "+book.author+" "+book.price);
			
		}
		
		//search
		int searchId = 1003;
		boolean found = false;
		for(Book book:books) {
			if(book.bookId==searchId) {
				found = true;
				System.out.println("Book found");
				book.displayBook();
				break;
			}
		}
		if(!found) {
			System.out.println("Book not found");
		}
		
		//update
		float newPrice = 560;
		found = false;
		for(Book book:books) {
			if(book.bookId==searchId) {
				found = true;
				book.price = newPrice;
				System.out.println("Update Book successfully");
				book.displayBook();
				break;
			}
		}
		if(!found) {
			System.out.println("Book not found");
		}
		
		
		//delete
		int deleteId = 1005;
		found = false;
		for(int i=0;i<books.size();i++) {
			if(books.get(i).bookId==deleteId) {
				found= true;
				books.remove(i);
				System.out.println("Delete book successfully");
				break;
			}
		}
		if(!found) {
			System.out.println("Book not found");
		}
		System.out.println("Total number of books in the inventory: "+books.size());
	}
}