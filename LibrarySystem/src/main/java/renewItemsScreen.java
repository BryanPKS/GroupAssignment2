
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.*; 


public class renewItemsScreen {
    Vector<String> titleVector = new Vector<>();
    String titleName;
    public renewItemsScreen(User person)
    {
        for(item rentedItem : person.rentedItems)
        {
            titleVector.add(rentedItem.getTitle());
        }
        
        JFrame frame = new JFrame("Renew Items");
        JPanel panel = new JPanel();
        JLabel renewLabel = new JLabel("Renew Items");
        JComboBox dropDown = new JComboBox(titleVector); 
        JButton renewButton = new JButton("Renew");
        JButton cancel = new JButton("Cancel");
        
        panel.setLayout(null);
        frame.setSize(400,400);
        renewLabel.setBounds(150, 20, 150, 30);
        dropDown.setBounds(110, 50, 150, 30);
        renewButton.setBounds(20, 300, 150, 30);
        cancel.setBounds(200, 300, 150, 30);
        
        //making buttons work
        cancel.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               frame.dispose();
           }
        });
        
        renewButton.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               
               titleName = (String)dropDown.getSelectedItem();
               item returnItem = person.findItem(titleName);
               if(returnItem.getRequested() == false && returnItem.getRenewed() == false)
               {
                   Calendar calendar = Calendar.getInstance();
                   int month = calendar.get(Calendar.MONTH) + 1;
                   String monthString = "" + month;
                   if(month < 10)
                   {
                       monthString = ("0" + (month));
                    }
                   String date = calendar.get(Calendar.YEAR) + "-" + monthString + "-" + calendar.get(Calendar.DATE);
                   returnItem.setRenewed(true);
                   returnItem.setDaysRented(0);
                   returnItem.setCheckoutDate(date);
               }
               else
               {
                   itemsNotRenewableScreen notRenewable = new itemsNotRenewableScreen();
               }
               
               frame.dispose();
           }
        });
        
        
        
        panel.add(renewLabel);
        panel.add(dropDown);
        panel.add(renewButton);
        panel.add(cancel);
        
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    
}
