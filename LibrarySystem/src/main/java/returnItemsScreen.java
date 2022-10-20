
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;


public class returnItemsScreen {
      Vector<String> titleVector = new Vector<>();
       
      public returnItemsScreen(User person)
      {
          
        for(item rentedItem : person.rentedItems)
        {
            titleVector.add(rentedItem.getTitle());
        }
        
        JFrame frame = new JFrame("Return Items");
        JPanel panel = new JPanel(); 
        JComboBox itemBox = new JComboBox(titleVector);
        JButton returnItem = new JButton("Return");
        JButton cancel = new JButton("cancel");
        
        frame.setSize(300,300);
        panel.setLayout(null);
        itemBox.setBounds(110, 50, 150, 30);
        returnItem.setBounds(110, 150, 150, 30);
        cancel.setBounds(110, 200, 150, 30);
        
        //make buttons work
        cancel.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               frame.dispose();
           }
        });
        
        returnItem.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               String itemTitle = (String)itemBox.getSelectedItem();
               item itemReturn = person.findItem(itemTitle);
               person.returnItem(itemReturn); 
               frame.dispose();
           }
        });
        
          
        panel.add(itemBox);
        panel.add(returnItem);
        panel.add(cancel);
        
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      }
    
}
