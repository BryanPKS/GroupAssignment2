
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class mainScreen {
    
    BufferedWriter libraryWriter;
    BufferedWriter userWriter;
    
    public mainScreen(librarySystem library)
    {
        
        //initializing GUI elements
        JFrame frame = new JFrame("Library System");
        JPanel panel = new JPanel();
        JButton addUser = new JButton("Add User");
        JButton addItem = new JButton("Add Item");
        JButton findUser = new JButton("Find User");
        JButton findItem = new JButton("Find Item");
        JButton quit = new JButton("Quit");
        JLabel title = new JLabel("Library System");
        
        //setting boundaries
        panel.setLayout(null);
        frame.setSize(400, 400);
        addUser.setBounds(80, 180, 100, 30);
        addItem.setBounds(200, 180, 100, 30);
        findUser.setBounds(25, 100, 150, 30);
        findItem.setBounds(205, 100, 150, 30);
        quit.setBounds(260, 300, 100, 30);
        title.setBounds(150, 10, 100, 30);
        
        //making buttons active
        quit.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                 
                 try 
                 {
                     libraryWriter = new BufferedWriter(new FileWriter("itemList.txt"));
                     
                     
                     library.itemMap.forEach((k, v) -> 
                     {
                         try { //add value to this and to the boot up sequence
                             libraryWriter.write(v.toString() + "," + v.title + "," + v.author + "," + v.itemNumber + "," +
                                     v.checkoutDate + "," + v.checkedOut + "," + v.renewed + "," + v.requested + "," + v.checkedoutBy + "," + v.value 
                                     + "," + v.daysRented + "," + v.overdueAmount + "\n");
                             } 
                             catch (IOException ex) 
                             {
                             Logger.getLogger(mainScreen.class.getName()).log(Level.SEVERE, null, ex);
                             }
                     });
                     
                 } 
                 catch (IOException ex) 
                 {
                     Logger.getLogger(mainScreen.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
                 try 
                 {
                     libraryWriter.close();
                 } 
                 catch (IOException ex) 
                 {
                     Logger.getLogger(mainScreen.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 try {
                     //Here is where we need to save all the userData into a file.

                     userWriter = new BufferedWriter(new FileWriter("userList.txt"));
                 } catch (IOException ex) {
                     Logger.getLogger(mainScreen.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 library.userMap.forEach((k, v) -> 
                     {
                         try {
                             userWriter.write(v.name + "," + v.address + "," + v.age + "," + v.id + "," + v.numberRentals + "," + v.phoneNumber
                                     + "\n");
                             } 
                             catch (IOException ex) 
                             {
                             Logger.getLogger(mainScreen.class.getName()).log(Level.SEVERE, null, ex);
                             }
                     });
                 
                 try 
                 {
                     userWriter.close();
                 } 
                 catch (IOException ex) 
                 {
                     Logger.getLogger(mainScreen.class.getName()).log(Level.SEVERE, null, ex);
                 }
                         
                frame.dispose();
             }
        });
        
        
        
        
        addUser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                addUserScreen newUser = new addUserScreen(library);
            }
        });
        
        addItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                addItemScreen newItem = new addItemScreen(library);
            }
        });
        
        findUser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                findUserScreen findUser = new findUserScreen(library);
            }
        });
        
        findItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                findItemScreen findnewItem = new findItemScreen(library);
            }
        });
        
        //adding to panel
        panel.add(addUser);
        panel.add(addItem);
        panel.add(findUser);
        panel.add(findItem);
        panel.add(quit);
        frame.add(panel);
        panel.add(title);
        
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
