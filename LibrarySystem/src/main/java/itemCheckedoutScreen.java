
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class itemCheckedoutScreen {
    
    public itemCheckedoutScreen(item inquiryItem)
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Item Already Checked Out");
        JButton okButton = new JButton("OK");
        JButton requestButton = new JButton ("Request");
        
        frame.setSize(200, 200);
        panel.setLayout(null);
        label.setBounds(20, 20, 170, 30);
        okButton.setBounds(40, 60, 100, 30);
        requestButton.setBounds(40, 100, 100, 30);
        
        okButton.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               frame.dispose();
           }
        });
        
        requestButton.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               inquiryItem.setRequested(true); 
           }
        });
        
        panel.add(label);
        panel.add(okButton);
        panel.add(requestButton);
        
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    
    }  
    
}
