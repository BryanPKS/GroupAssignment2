
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class checkoutItemScreen {
    
    public checkoutItemScreen(librarySystem library, User person)
    {
        JFrame frame = new JFrame("Checkout Item");
        JPanel panel = new JPanel();
        JTextField titleField = new JTextField();
        JLabel titleLabel = new JLabel("Title: ");
        JButton searchButton = new JButton("Search");
        JButton cancel = new JButton("Cancel");
        
        titleLabel.setBounds(20, 20, 100, 30);
        titleField.setBounds(100, 20, 150, 30);
        searchButton.setBounds(20, 60, 100, 30);
        cancel.setBounds(130, 60, 100, 30);
        
        //making buttons work
        cancel.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                frame.dispose();
             }
        });
        
        searchButton.addActionListener(new ActionListener() //This is not working right now.
        {
             public void actionPerformed(ActionEvent e)
             {
                Boolean found = false; 
                found = library.findItem(titleField.getText());
                System.out.println("Searching for " + titleField.getText());
                
                if(found == true)
                {
                    System.out.println("Found! ");
                    item rentableItem = library.getItem(titleField.getText()); 
                    itemFoundScreen itemFound = new itemFoundScreen();
                    
                    if(rentableItem.getCheckedOut() == false)
                    { 
                        person.rentItem(rentableItem); 
                    }
                    else if(rentableItem.getCheckedOut())
                    {
                        itemCheckedoutScreen checkedOut = new itemCheckedoutScreen(rentableItem);
                    }
                    
                    person.printItems();
                }
                else
                {
                    System.out.println("not found!");
                    itemNotFoundScreen notFound = new itemNotFoundScreen();
                }
             }
        });
        
        
        
        frame.setSize(300,300);
        panel.setLayout(null);
        
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(searchButton);
        panel.add(cancel);
        
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    
}
