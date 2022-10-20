
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class librarySystem {
    
    HashMap <String, item> itemMap = new HashMap<>();
    HashMap <String, User> userMap = new HashMap<>();
    int numUsers = 0;
    int numItems = 0;
    
    //add an integer calendar.
    
    BufferedReader libraryReader; 
    BufferedReader userReader;
        
    
    public librarySystem() throws FileNotFoundException, IOException
    {
        libraryReader = new BufferedReader(new FileReader("itemList.txt"));
         System.out.println("file opened");
        String line;
        while((line = libraryReader.readLine()) != null)
        {
            System.out.println(line);
            String[] stringArray = line.split(",", 0);
            String type = stringArray[0];
            String title = stringArray[1];
            String author = stringArray[2];
            int number = Integer.parseInt(stringArray[3]);
            String checkoutDate = stringArray[4];
            Boolean checkedOut = Boolean.parseBoolean(stringArray[5]);
            Boolean renewed = Boolean.parseBoolean(stringArray[6]);
            Boolean requested = Boolean.parseBoolean(stringArray[7]);
            String bookRenter = stringArray[8];
            float itemValue = Float.parseFloat(stringArray[9]);
            int rentalDays = Integer.parseInt(stringArray[10]);
            float itemOverdue = Float.parseFloat(stringArray[11]);
            
            System.out.println("file opened and read from");
            System.out.println(line);
            item newItem = null;
            
            switch(type) 
            {
                case "book" :
                    newItem = new book(number, title, author, itemValue);
                    break;
                case "audioVideoMaterial" :
                    newItem = new audioVideoMaterial(number, title, author, itemValue);
                    break;
                case "currentBestSeller" :
                    newItem = new currentBestSeller(number, title, author, itemValue);
                    break;
                case "referencebook" :
                    newItem = new referenceBook(number, title, author, itemValue);
                    break;    
                case "magazine" : 
                    newItem = new magazine(number, title, author, itemValue);
                    break;
            }
            
            newItem.setCheckedOut(checkedOut);
            newItem.setRenewed(renewed);
            newItem.setRequested(requested);
            newItem.setCheckoutDate(checkoutDate);
            newItem.setCheckedoutBy(bookRenter);
            newItem.setDaysRented(rentalDays);
            newItem.overdueAmount = itemOverdue;
            
            this.addItem(newItem);
            
            
            
            
            //need to add code to open the userFile and also think of a way to save what books are rented.
        }    
           libraryReader.close();
           System.out.println("completed reading in items");
           this.printAllItems();
        
        
            userReader = new BufferedReader(new FileReader("userList.txt"));
            System.out.println("user file opened");
            String userLine;
            while((userLine = userReader.readLine()) != null)
            {
                System.out.println(userLine);
                String[] userStringArray = userLine.split(",", 0);
                String userName = userStringArray[0];
                String userAddress = userStringArray[1];
                int userAge = Integer.parseInt(userStringArray[2]);
                int userID = Integer.parseInt(userStringArray[3]);
                int userNumRentals = Integer.parseInt(userStringArray[4]);
                String userPhoneNumber = userStringArray[5];
                User newUser;
                
                if(userAge < 12)
                {
                    newUser = new childClass(userName, userID, userAddress, userAge, userPhoneNumber);
                }
                else
                {
                    newUser = new adultClass(userName, userID, userAddress, userAge, userPhoneNumber);
                }
                
                newUser.setNumRentals(userNumRentals); 
                
                this.addUser(newUser);   
            }
        
        
        this.printAllUsers();
        
        userReader.close();
        
        //reading in values and assigning them to the users who rented them.
        //for every item in items, if checked out is true, find the user associated with checkedoutBy,
        //and put it in their item vector.
        System.out.println("about to find items rented and locate renters");
        itemMap.forEach((k, v) ->
        {
          System.out.println("for loop start");
          System.out.println("values: " + v.checkedOut + ", " + v.checkedoutBy);
          if(v.checkedOut == true && v.checkedoutBy != "nobody")
          {
              System.out.println("conditions met!");
              User userRented;
              String rentedName = v.getCheckedoutBy();
              System.out.println("checked out by: " + rentedName);
              userRented = userMap.get(rentedName);
              System.out.println("user is: " + userRented.getName());
              userRented.rentedItems.add(v);
          }
          
        }); 
        
        
    }
    
    public void addItem(item itemAdd)
    {
        itemMap.put(itemAdd.getTitle(), itemAdd);
        ++numItems;
    }
    
    public void removeItem(item itemRemove)
    {
        itemMap.remove(itemRemove);
    }
    
    public void addUser(User newUser)
    {
        userMap.put(newUser.getName() , newUser);
        ++numUsers;
    }
    
    public void removeUser(User oldUser)
    {
        userMap.remove(oldUser);
    }
    
    public void printAllItems()
    {
        itemMap.forEach((k, v) ->
        {
        
          System.out.println(v.title);
          
        });   
    }
    
    public void printAllUsers()
    {
        userMap.forEach((k, v) ->
        {
        
          System.out.println(v.name);
          
        });   
    }
    
    public Boolean findUser(String userName)
    {
        return userMap.containsKey(userName);
    }
    
    public Boolean findItem(String itemName)
    {
        return itemMap.containsKey(itemName);
    }
    
    public item getItem(String itemName)
    {
        System.out.println("getting item.");
        item rentedItem = itemMap.get(itemName);
        System.out.println("Item is " + rentedItem.title);
        return itemMap.get(itemName);
    }
    
    public void setNumUsers(int num)
    {
        numUsers = num;
    }
    
    public int getNumUsers()
    {
        return numUsers;
    }
    
    public void setNumItems(int i)
    {
        numItems = i;
    }
    
    public int getNumItems()
    {
        return numItems;
    }
    
    
}
