
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import javax.swing.*;


public class userScreen {
    
    public userScreen(User person, librarySystem library)
    {
        
        JFrame frame = new JFrame(person.getName() + "'s Library Card");
        JPanel panel = new JPanel();
        JButton checkoutItem = new JButton("Checkout Item");
        JButton payFine = new JButton("Pay Fines");
        JButton returnItems = new JButton("Return Items");
        JButton refresh = new JButton("Refresh");
        JButton close = new JButton("Close");
        JLabel userName = new JLabel("User name: " + person.getName());
        JLabel fineTotal = new JLabel("Total Fines: $" + person.getFines());
        JLabel address = new JLabel("Address: " + person.getAddress());
        JLabel userID = new JLabel("Card #:  " + person.getID());
        JLabel itemsRentedLabel = new JLabel("Items Checked Out: ");
        JLabel phoneNumberLabel = new JLabel("Phone #: " + person.phoneNumber);
        JLabel userAgeLabel = new JLabel("Age: " + person.getAge());
        JTextArea itemsRentedArea = new JTextArea();
        JButton renewItems = new JButton("Renew Items");
        
        
        frame.setSize(400,400);
        panel.setLayout(null);
        checkoutItem.setBounds(20, 100, 150, 30);
        payFine.setBounds(180, 100, 150, 30);
        returnItems.setBounds(20, 140, 150, 30);
        userName.setBounds(20, 20, 150, 30);
        fineTotal.setBounds(20, 40, 150, 30);
        address.setBounds(20, 60, 150, 30);
        userID.setBounds(180, 20, 150, 30);
        itemsRentedLabel.setBounds(20, 180, 150, 30);
        itemsRentedArea.setBounds(20, 220, 200, 120);
        renewItems.setBounds(180, 140, 150, 30);
        refresh.setBounds(240, 220, 100, 30);
        close.setBounds(240, 300, 100, 30);
        phoneNumberLabel.setBounds(180, 40, 150, 30);
        userAgeLabel.setBounds(180, 60, 150, 30);
        
        //makin buttons work
        payFine.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 person.payFines();
                 finePaidScreen paidFines = new finePaidScreen();
                 fineTotal.setText("Total Fines: $" + person.getFines());
             }
        });
        
        checkoutItem.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 checkoutItemScreen newItem = new checkoutItemScreen(library, person);
             }
        });
        
        returnItems.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 returnItemsScreen returnScreen = new returnItemsScreen(person);
             }
        });
        
        renewItems.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 renewItemsScreen renewItem = new renewItemsScreen(person);
             }
        });
        
        close.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 frame.dispose();
             }
        });
        
        refresh.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 fineTotal.setText("Total Fines: $" + person.getFines());
                 itemsRentedArea.setText("");
                 
                 for(item rentedItem : person.rentedItems)
                    {
                        if(!rentedItem.getRequested() && rentedItem.getCheckoutTime() >= rentedItem.daysRented)
                        {
                           itemsRentedArea.append(rentedItem.getTitle() + "\n");
                        }
                        else if(rentedItem.getRequested() && rentedItem.getCheckoutTime() >= rentedItem.daysRented)
                        {
                           itemsRentedArea.append(rentedItem.getTitle() + "  Requested! \n");
                        }
                        else if(rentedItem.getRequested() && rentedItem.getCheckoutTime() < rentedItem.daysRented)
                        {
                            itemsRentedArea.append(rentedItem.getTitle() + "  Requested! Overdue! \n");
                        }
                        else if(!rentedItem.getRequested() && rentedItem.getCheckoutTime() < rentedItem.daysRented)
                        {
                            itemsRentedArea.append(rentedItem.getTitle() + " Overdue! \n");
                        }
                    } 
                 
             }
        });
        
        panel.add(checkoutItem);
        panel.add(payFine);
        panel.add(returnItems);
        panel.add(userName);
        panel.add(fineTotal);
        panel.add(address);
        panel.add(userID);
        panel.add(itemsRentedLabel);
        panel.add(itemsRentedArea);
        panel.add(renewItems);
        panel.add(refresh);
        panel.add(close);
        panel.add(phoneNumberLabel);
        panel.add(userAgeLabel);
        
        
        //
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        Calendar calendar = Calendar.getInstance();
           int month = calendar.get(Calendar.MONTH) + 1;
           String monthString = "" + month;
           if(month < 10)
           {
               monthString = ("0" + (month));
           }
           String today = calendar.get(Calendar.YEAR) + "-" + monthString + "-" + calendar.get(Calendar.DATE);
           LocalDate todaysDate = LocalDate.parse(today);
           LocalDate dayRented;
        
        for(item rentedItem : person.rentedItems)
        {    
            dayRented = LocalDate.parse(rentedItem.getCheckoutDate());
            int dayDifference = (int) ChronoUnit.DAYS.between(dayRented, todaysDate);
            rentedItem.setDaysRented(dayDifference);
            
                if(!rentedItem.getRequested() && rentedItem.getCheckoutTime() >= rentedItem.daysRented)
                {
                    itemsRentedArea.append(rentedItem.getTitle() + "\n");
                }
                else if(rentedItem.getRequested() && rentedItem.getCheckoutTime() >= rentedItem.daysRented)
                {
                   itemsRentedArea.append(rentedItem.getTitle() + "  Requested! \n");
                }
                        else if(rentedItem.getRequested() && rentedItem.getCheckoutTime() < rentedItem.daysRented)
                {
                    itemsRentedArea.append(rentedItem.getTitle() + "  Requested! Overdue! \n");
                }
                        else if(!rentedItem.getRequested() && rentedItem.getCheckoutTime() < rentedItem.daysRented)
                {
                    itemsRentedArea.append(rentedItem.getTitle() + " Overdue! \n");
                }
        }
        
        if(person.getAge() < 12)
        {
            userAgeLabel.setText("Age: " + person.getAge() + " (child)");
        }
    }
    
    
    
}
