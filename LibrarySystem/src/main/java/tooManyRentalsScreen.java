
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class tooManyRentalsScreen {
    
    public tooManyRentalsScreen()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Max items checked out!");
        JButton okButton = new JButton("OK");
        
        frame.setSize(200, 200);
        panel.setLayout(null);
        label.setBounds(35, 20, 150, 30);
        okButton.setBounds(40, 60, 100, 30);
        
        okButton.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               frame.dispose();
           }
        });
        
        panel.add(label);
        panel.add(okButton);
        
        frame.add(panel);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    
    }  
    
}
