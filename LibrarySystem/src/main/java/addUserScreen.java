
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class addUserScreen {
    
    public addUserScreen(librarySystem system)
    {
        JFrame frame = new JFrame("New User");
        JPanel panel = new JPanel();
        JLabel nameLabel = new JLabel("Name: ");
        JLabel addressLabel = new JLabel("Address: ");
        JLabel phoneNumberLabel = new JLabel("Phone #: ");
        JLabel ageLabel = new JLabel("age: ");
        JButton addUser = new JButton("Add User");
        JButton cancel = new JButton("Cancel");
        JTextField nameField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField phoneNumberField = new JTextField();
        
        
        panel.setLayout(null);
        frame.setSize(320,320);
        nameLabel.setBounds(20, 20, 50, 30);
        nameField.setBounds(80, 20, 150, 30);
        addressLabel.setBounds(20, 70, 70, 30);
        addressField.setBounds(80, 70, 150, 30);
        ageLabel.setBounds(20, 120, 50, 30);
        ageField.setBounds(80, 120, 150, 30);
        addUser.setBounds(20, 230, 100, 30);
        cancel.setBounds(130, 230, 100, 30);
        phoneNumberLabel.setBounds(20, 170, 150, 30);
        phoneNumberField.setBounds(80, 170, 150, 30);
        
        addUser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String ageText = ageField.getText();
                int age = Integer.parseInt(ageText); 
                String address = addressField.getText();
                String name = nameField.getText();
                String phoneNumber = phoneNumberField.getText(); 
                int id = system.getNumUsers();
                
                
                User newUser;
                if(age < 12) 
                { 
                    newUser = new childClass(name, id, address, age, phoneNumber); 
                }
                else
                {
                    newUser = new adultClass(name, id, address, age, phoneNumber);
                }
                
                system.addUser(newUser);
                
                frame.dispose();
            }
        });
        
        cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose(); 
            }
        });
        
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(addUser);
        panel.add(cancel);
        panel.add(ageLabel);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        
    }
    
}
