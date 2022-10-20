
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



public class findItemScreen {
    
    public findItemScreen(librarySystem library)
    {
        JFrame frame = new JFrame("Find Item");
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
        
        searchButton.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                Boolean found = library.findItem(titleField.getText());
                System.out.println("Searching for " + titleField.getText());
                if(found == true)
                {
                    System.out.println("Found! ");
                    itemFoundScreen itemFound = new itemFoundScreen();
                    item foundItem = library.getItem(titleField.getText());
                    try {
                        itemScreen newItemScreen = new itemScreen(foundItem);
                    } catch (ParseException ex) {
                        Logger.getLogger(findItemScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
