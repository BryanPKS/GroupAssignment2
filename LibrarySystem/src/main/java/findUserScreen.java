
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class findUserScreen {
    
    public findUserScreen(librarySystem system)
    {
        JFrame frame = new JFrame("Find User");
        JPanel panel = new JPanel();
        
        JTextField userNameField = new JTextField();
        JLabel userNameLabel = new JLabel("User Name: ");
        JButton searchButton = new JButton("Search");
        JButton cancel = new JButton("Cancel");
        
        //setting boundaries
        frame.setSize(300,300);
        panel.setLayout(null);
        userNameLabel.setBounds(20, 20, 100, 30);
        userNameField.setBounds(100, 20, 150, 30);
        searchButton.setBounds(20, 60, 100, 30);
        cancel.setBounds(130, 60, 100, 30);
        
        //making buttons work
        searchButton.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 String userName = userNameField.getText();
                 if(system.findUser(userName))
                 {
                     userScreen user = new userScreen(system.userMap.get(userName), system); 
                     frame.dispose();
                 }
                 else
                 {
                     userNotFoundScreen notFound = new userNotFoundScreen();
                 }
             }
        });
        
        cancel.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 frame.dispose();
             }
        });
        
        
        //adding stuff
        panel.add(userNameLabel);
        panel.add(userNameField);
        panel.add(searchButton);
        panel.add(cancel);
        
        
        //frame housekeeping
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    
}
