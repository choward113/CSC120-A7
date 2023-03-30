import java.util.Hashtable;
import java.util.Enumeration;
/**
 *A class representing a library. It contains a collection of books, which can be added to, removed from, checked out, returned, searched for, and printed out.
 */
public class Library extends Building {

  private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
    }
  
  /**
   * Adds a book into the collection
   * @param title The title of the book 
   */
  public void addTitle(String title){
    this.collection.put(title, true);
  }

  /**
   * Removes a title from the collection
   * @param title The title of the book
   * @return Returns the title of the book
   */
  public String removeTitle(String title){
    try {
    this.collection.remove(title, true);
    } catch (Exception e ) {
      throw new RuntimeException(title + " does not exist");
    }
    return title;
  }

  /**
   * Checks out a book and makes the book unavailable 
   * @param title The title of the book
   * @throws RuntimeException if the title is not in the library's collection
   */
  public void checkOut(String title){
    if (this.collection.get(title)) {
      this.collection.put(title, false);
    }else{
      throw new RuntimeException(title + " is not in the library right now.");
    }
  }

  /**
   * Returns a book and makes the book available
   * @param title The title of the book
   */
  public void returnBook(String title){
    this.collection.replace(title, false, true);
  }

  /**
   * Returns whether or not the given title is present in the collection.
   * @param title The title to search for
   * @return True if the given title is in the collection, false otherwise
   */
  public boolean containsTitle(String title){
    return this.collection.getOrDefault(title, false);
  }
  
  /**
   * Returns whether or not the given title is available.
   * @param title The title to search for
   * @return True if the given title is available, false otherwise
   */
  public boolean isAvailable(String title){
    return this.collection.getOrDefault(title, false);
  }

  /** 
   * Prints the collection of books
   */
  public void printCollection(){
    String entireCollection = "";
    Enumeration<String> keys = this.collection.keys();
    while (keys.hasMoreElements()) {
      String title = keys.nextElement();
      Boolean inStock = this.collection.get(title);
      String isCheckedOut = "Available";
      if (!inStock){
        isCheckedOut = "Checked out";
      }
      System.out.println("Title: " + title + ", Status: " + isCheckedOut);
    }
    System.out.println(entireCollection);
  }

    public static void main(String[] args) {
      Library lib = new Library("name", "address", 2);
    }

  }