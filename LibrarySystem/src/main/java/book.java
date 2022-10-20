
public class book extends item {
    
        
        
    public book(int number, String itemTitle, String itemAuthor, float itemValue)
    {
        checkedOut = false;
        itemNumber = number;
        title = itemTitle;
        requested = false;
        checkoutDate = "Not checked out";
        author = itemAuthor;
        renewed = false;
        value = itemValue;
        checkoutTime = 21;
        checkedoutBy = "nobody";
        rentable = true;
        daysRented = 0;
        overdueAmount = 0;
        
    }
    
    @Override
    public String toString()
    {
        return "book";
    }
    
}
