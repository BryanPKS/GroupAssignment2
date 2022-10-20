
public class referenceBook extends item{
    
    public referenceBook(int number, String itemTitle, String itemAuthor, float itemValue)
    {
        checkedOut = false;
        itemNumber = number;
        title = itemTitle;
        checkoutDate = "unrentable";
        requested = false;
        renewed = false;
        value = itemValue;
        checkoutTime = 0;
        author = itemAuthor;
        checkedoutBy = "nobody";
        rentable = false;
        daysRented = 0;
        overdueAmount = 0;
        checkoutDate = "Not checked out";
        
    }
    
    @Override
    public String toString()
    {
        return "referencebook";
    }
    
}
