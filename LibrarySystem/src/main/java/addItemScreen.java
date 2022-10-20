
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class addItemScreen {
    
    String itemType;
    
    public addItemScreen(librarySystem library)
    {
        itemType = "not initialized";
        
        JFrame frame = new JFrame("New Item");
        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Title: ");
        JTextField titleField = new JTextField();
        JLabel valueLabel = new JLabel("Value: ");
        JTextField valueField = new JTextField();
        JButton addItem = new JButton("Add Item");
        JButton cancel = new JButton("Cancel");
        JLabel authorLabel = new JLabel("Author");
        JTextField authorField = new JTextField();
        
        
        //setting up combo box for drop down
        String [] itemTypes = {"reference book", "book", "best seller", "A/V item", "magazine"};
        JComboBox dropDown = new JComboBox(itemTypes);
        
        //setting up dimensions
        titleLabel.setBounds(20, 20, 50, 30);
        titleField.setBounds(110, 20, 150, 30);
        valueLabel.setBounds(20, 120, 100, 30);
        valueField.setBounds(110, 120, 150, 30);
        dropDown.setBounds(20, 170, 150, 30);
        addItem.setBounds(20, 250, 150, 30);
        cancel.setBounds(180, 250, 150, 30);
        authorLabel.setBounds(20, 70, 50, 30);
        authorField.setBounds(110, 70, 150, 30);
        
        //making buttons and dropdown work
        dropDown.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 itemType = (String)dropDown.getSelectedItem(); 
                 System.out.println(itemType);
            }
        });
        
        addItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int number = library.getNumItems();
                String name = titleField.getText();
                String author = authorField.getText();
                float itemValue = Float.parseFloat(valueField.getText());
                item newItem = null;
                itemType = (String)dropDown.getSelectedItem();
                
                 switch(itemType)
                 {
                     case "reference book" :
                         newItem = new referenceBook(number, name, author, itemValue); 
                         break;
                     case "book" :
                         newItem = new book(number, name, author, itemValue);
                         break;
                     case "best seller" :
                         newItem = new currentBestSeller(number, name, author, itemValue);
                         break;
                     case "A/V item" :
                         newItem = new audioVideoMaterial(number, name, author, itemValue);
                         break;
                     case "magazine" :
                         newItem = new magazine(number, name, author, itemValue);
                         break;
                 }
                 
                 library.addItem(newItem); 
                 
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
        
        //adding things to panel and frame
        
        panel.setLayout(null);
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(valueLabel);
        panel.add(valueField);
        panel.add(dropDown);
        panel.add(addItem);
        panel.add(cancel);
        panel.add(authorLabel);
        panel.add(authorField);
        
        frame.setSize(350,350);
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
