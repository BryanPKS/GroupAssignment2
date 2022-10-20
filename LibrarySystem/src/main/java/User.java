
import java.util.Calendar;
import java.util.Vector;


public abstract class User {
    
    String name;
    int id; 
    String address;
    Vector<overdueFine> fineVector = new Vector<>();
    Vector<item> rentedItems = new Vector<>();
    int numberRentals;
    int age;
    float fineAmount;
    String phoneNumber;
    
    //setters n getters!
    
    public void setName(String userName)
    {
        name = userName;
    }
    
    public void setAge(int userAge)
    {
        age = userAge;
    }
    
    public void setID(int userID)
    {
        id = userID;
    }
    
    public void setAddress(String userAddress)
    {
        address = userAddress;
    }
    
    public void setNumRentals(int number)
    {
        numberRentals = number;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public int getAge()
    {
        return age; 
    }
    
    public int getNumberRentals()
    {
        return numberRentals;
    }
    
    public void addFine(overdueFine newFine)
    {
        fineVector.add(newFine);
    }
    
    public float getFines()
    {
        return fineAmount;
    }
    
    public void rentItem(item rentable)
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
           ++numberRentals;
        }
        else
        {
            itemNotRentableScreen notRentable = new itemNotRentableScreen();
        }
    }
    
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
        --numberRentals;
        
    }
    
    public void returnAllItems()
    {
        for(item rentedItem : rentedItems)
        {
            rentedItem.setCheckedOut(false);
            rentedItem.setCheckoutDate("not checked out");
            rentedItem.setCheckedoutBy("nobody");
            rentedItem.setRequested(false); 
            rentedItem.setRenewed(false);
        }
        rentedItems.clear();
    }
    
    public void payFines()
    {
        fineAmount = 0;
    }
    
    public void printItems()
    {
        System.out.println("Printing items: ");
        for(item rentedItem : rentedItems)
        {
            System.out.println(rentedItem.title);
        }
    }
    
    public item findItem(String itemName)
    {
        for(item rentedItem: rentedItems)
        {
            if(rentedItem.getTitle() == itemName)
            {
                return rentedItem;
            }
        }
        
        return null;
        
    }
    
    
    
    
    
}
