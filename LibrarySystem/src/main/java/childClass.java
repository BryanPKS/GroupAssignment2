
import java.util.Calendar;


public class childClass extends User {
    
    int maxRentals = 5;
    
    public childClass(String userName, int ID, String userAddress, int userAge, String userPhoneNumber)
    {
        
        this.setName(userName);
        this.setID(ID);
        this.setAddress(userAddress);
        this.setAge(userAge);
        phoneNumber = userPhoneNumber;
        
        fineAmount = 0;
        numberRentals = 0;
        
    }
    
    //setters n getters!
    
    public int getMaxRentals()
    {
        return maxRentals;
    }
    
    public void setMaxRentals(int newNum)
    {
        maxRentals = newNum;
    }
    
    @Override
    public void rentItem(item rentable)
    {
        if(numberRentals <= maxRentals)
        {
            if(rentable.rentable)
            {
               Calendar calendar = Calendar.getInstance();
               int month = calendar.get(Calendar.MONTH) + 1;
           String monthString = "" + month;
           if(month < 10)
           {
               monthString = ("0" + (month));
           }
               String date = calendar.get(Calendar.YEAR) + "-" + monthString + "-" + calendar.get(Calendar.DATE);
               rentedItems.add(rentable);
               rentable.setCheckedOut(true);
               rentable.checkedoutBy = this.getName();
               rentable.setCheckoutDate(date);
               numberRentals++;
            }
            else
            {
                itemNotRentableScreen notRentable = new itemNotRentableScreen();
            }
        }
        else
        {
            tooManyRentalsScreen tooMany = new tooManyRentalsScreen();
        }
    }
    
    @Override
     public void returnItem(item returnable)
    {
        rentedItems.remove(returnable);
        returnable.setCheckedOut(false);
        returnable.setRenewed(false);
        returnable.setRequested(false);
        returnable.setCheckoutDate("Not checked out");
        returnable.setCheckedoutBy("nobody");
        fineAmount += returnable.getFee(); //add setters and getters instead of direct access.
        returnable.overdueAmount = 0;
        returnable.daysRented = 0; //bring this back
        numberRentals--;
        
    }
    
}
