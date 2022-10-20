
public class currentBestSeller extends item{
    
    String checkoutDate;
    
    public currentBestSeller(int number, String itemTitle, String itemAuthor, float itemValue)
    {
        checkedOut = false;
        itemNumber = number;
        title = itemTitle;
        requested = false;
        renewed = false;
        value = itemValue;
        checkoutTime = 14;
        author = itemAuthor;
        checkedoutBy = "nobody";
        rentable = true;
        daysRented = 0;
        overdueAmount = 0;
        checkoutDate = "Not checked out";
        
    }
    
    @Override
    public String toString()
    {
        return "currentBestSeller";
    }
    
    
    
}
