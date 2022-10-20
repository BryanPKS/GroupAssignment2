
import java.io.IOException;


public class testMain {
    
    public static void main(String[] args) throws IOException
    {
        //main screen test section
        librarySystem library = new librarySystem();
        mainScreen libraryScreen = new mainScreen(library);
        
        //testing for renewable or requested items.
        /*
        book myBook = new book(55, "myBook", "myAuthor");
        adultClass Steve = new adultClass("Steve", 50, "3344 road", 25);
        Steve.rentItem(myBook); 
        myBook.setRenewed(true);
        renewItemsScreen testScreen = new renewItemsScreen(Steve);
        */
    }
    
}
