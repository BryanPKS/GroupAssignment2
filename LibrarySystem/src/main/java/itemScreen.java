
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;



public class itemScreen {
    JLabel dueBackLabel;
    public itemScreen(item thisItem) throws ParseException
    {
        JFrame frame = new JFrame(thisItem.getTitle());
        JPanel panel = new JPanel();
        
        JLabel title = new JLabel("Title: " + thisItem.getTitle());
        JLabel author = new JLabel("Author: " + thisItem.getAuthor());
        JLabel itemType = new JLabel(thisItem.toString());
        JLabel checkedOut = new JLabel("Checked Out: " + thisItem.getCheckedOut());
        JLabel checkedOutDate = new JLabel("Date Checked Out: " + thisItem.getCheckoutDate());
        
        
        dueBackLabel = new JLabel();
        
        if(thisItem.getCheckedOut())
        {
            
           Calendar calendar = Calendar.getInstance();
           int month = calendar.get(Calendar.MONTH) + 1;
           String monthString = "" + month;
           if(month < 10)
           {
               monthString = ("0" + (month));
           }
           String today = calendar.get(Calendar.YEAR) + "-" + monthString + "-" + calendar.get(Calendar.DATE);
           LocalDate dayRented = LocalDate.parse(thisItem.getCheckoutDate());
           LocalDate todaysDate = LocalDate.parse(today);
           int dayDifference = (int) ChronoUnit.DAYS.between(dayRented, todaysDate);
            
           System.out.println("Days rented: " + dayDifference);
            
           thisItem.setDaysRented(dayDifference); 
           
           if((thisItem.checkoutTime - thisItem.daysRented) >= 0)
            {
                dueBackLabel= new JLabel("Due back in: " + (thisItem.checkoutTime - thisItem.daysRented) + " days");
            }
            else
            {
                if(((thisItem.daysRented - thisItem.checkoutTime) * .1) > thisItem.getValue())
                {
                    dueBackLabel= new JLabel("Overdue by " + (thisItem.daysRented - thisItem.checkoutTime) + " days! Fee: $" + thisItem.getValue());
                }
                else
                {
                    dueBackLabel = new JLabel("Overdue by " + (thisItem.daysRented - thisItem.checkoutTime) + " days! Fee: $" + 
                            String.format("%.2f", (0.1 * (thisItem.daysRented - thisItem.checkoutTime))));
                }
            }
        }
        else
        {
            dueBackLabel= new JLabel("Due back in: Not checked out");
        }
        
        JLabel requested = new JLabel("Requested: " + thisItem.getRequested());
        JLabel itemNumber = new JLabel("Item #: " + thisItem.getItemNumber());
        JLabel valueLabel = new JLabel("Value: $" + thisItem.getValue());
        JButton okButton = new JButton("OK");
        
        
        panel.setLayout(null);
        frame.setSize(360,370);
        
        title.setBounds(20, 20, 150, 30);
        author.setBounds(20, 50, 150, 30);
        itemType.setBounds(20, 80, 150, 30);
        checkedOut.setBounds(20, 110, 150, 30);
        checkedOutDate.setBounds(20, 140, 250, 30);
        dueBackLabel.setBounds(20, 170, 250, 30);
        requested.setBounds(20, 200, 150, 30);
        itemNumber.setBounds(20, 230, 150, 30);
        valueLabel.setBounds(20, 260, 150, 30);
        okButton.setBounds(180, 290, 150, 30);
        
        
        okButton.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 frame.dispose();
             }
        });
        
        panel.add(title);
        panel.add(author);
        panel.add(itemType);
        panel.add(checkedOut);
        panel.add(requested);
        panel.add(itemNumber);
        panel.add(valueLabel);
        panel.add(okButton);
        panel.add(dueBackLabel);
        panel.add(checkedOutDate);
        
        // add refresh button here
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(20, 290, 150, 30);
        panel.add(refreshButton);
        
        refreshButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                checkedOut.setText("Checked Out: " + thisItem.getCheckedOut());
                checkedOutDate.setText("Date Checked Out: " + thisItem.getCheckoutDate());
                requested.setText("Requested: " + thisItem.getRequested());
                
                if(thisItem.getCheckedOut())
                {
                    Calendar calendar = Calendar.getInstance();
                    int month = calendar.get(Calendar.MONTH) + 1;
                    String monthString = "" + month;
                    if(month < 10)
                    {
                        monthString = ("0" + (month));
                    }
                    String today = calendar.get(Calendar.YEAR) + "-" + monthString + "-" + calendar.get(Calendar.DATE);
                    LocalDate dayRented = LocalDate.parse(thisItem.getCheckoutDate());
                    LocalDate todaysDate = LocalDate.parse(today);
                    
                    if((thisItem.checkoutTime - thisItem.daysRented) >= 0)
                    {
                         dueBackLabel.setText("Due back in: " + (thisItem.checkoutTime - thisItem.daysRented) + " days");
                    }
                    else
                    {
                        dueBackLabel.setText("Overdue!");
                    }
                    
                }
                else
                {
                    dueBackLabel.setText("Due back in: Not checked out");
                }
                
                
                
                
            }
        });
        
        
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        
    }
    
}
