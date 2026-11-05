package JavaFileHandling;
import java.io.*;
class Book implements Serializable{
	int bookId;
	String bookName;
	String author;
	double price;
	public Book(int bookId,String bookName,String author,double price) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
}
public class BookSerialize {
	public static void main(String[] args) throws IOException,FileNotFoundException, ClassNotFoundException {
		
		Book b1 = new Book(101,"Let Us C","William",450.0);
		Book b2 = new Book(101,"Let Us C","William",450.0);
		Book b3 = new Book(101,"Let Us C","William",450.0);
		Book b4 = new Book(101,"Let Us C","William",450.0);
		Book b5 = new Book(101,"Let Us C","William",450.0);
		
		
		
		
		//object serialization
		FileOutputStream fos = new FileOutputStream("student.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(b1);
        oos.writeObject(b2);
        oos.writeObject(b3);
        oos.writeObject(b4);
        oos.writeObject(b5);
        
        oos.close();
        
        System.out.println("Book object successfully written");
        
        //read object deserialize
        
		FileInputStream fis = new FileInputStream("student.dat");
		ObjectInputStream os = new ObjectInputStream(fis);
		
		Book bk1 = (Book) os.readObject();
		Book bk2 = (Book) os.readObject();
		Book bk3 = (Book) os.readObject();
		Book bk4 = (Book) os.readObject();
		Book bk5 = (Book) os.readObject();
		
		System.out.println("Book details: ");
		
		System.out.println(bk1.bookId+" "+bk1.bookName+" "+bk1.author+" "+bk1.price);
		System.out.println(bk2.bookId+" "+bk2.bookName+" "+bk2.author+" "+bk2.price);
		System.out.println(bk3.bookId+" "+bk3.bookName+" "+bk3.author+" "+bk3.price);
		System.out.println(bk4.bookId+" "+bk4.bookName+" "+bk4.author+" "+bk4.price);
		
		oos.close();
		
		
		
		
	}

}
