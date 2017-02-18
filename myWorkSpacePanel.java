import java.awt.*;
/**
 *
 * @author Muhammad Hamza Khan
 */
public class myWorkSpacePanel extends javax.swing.JPanel
{
        // Variables
        
        // Constructor
        public myWorkSpacePanel()
        {
        }
        
        // Methods
        @Override
        public void paintComponent( Graphics page)
        {
                super.paintComponent( page);
                
                for ( int i = 25; i <  525; i = i + 25 )
                {
                        for ( int j = 25; j < 525; j = j + 25 )
                        {
                                page.drawRect(i, j, 25, 25);
                        }
                }                
        }                     
        
}
