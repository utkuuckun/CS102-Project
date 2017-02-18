import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class myPanel  extends JPanel implements ActionListener
{
	//properties
	ArrayList<Position> dots;
	ArrayList<Information> info;
	boolean option = true;	//means show resistance for example
	int x;
	int y;
	JButton b = new JButton("Press me!");
	JOptionPane JOP = new JOptionPane();
	
	//constructor
	public myPanel(ArrayList depo)
	{
		setBackground(Color.PINK);
		dots = new ArrayList<Position>();
		add(b);
		b.addActionListener(this);
		
		for(int i = depo.size(); i > 0; i--)
		{
			info = (ArrayList)depo.get(i - 1);
			for(Information in : info)
			{
				System.out.print("test");
				if(in.getName().equals("Resistance 1"))	//this will come from other code
				{
					
					if(option)	//this will come from other code
						dots.add(new Position( i , (int)in.getResistance()));
				}
			}
		}
	}
	
	//methods
	@Override
	public void paintComponent(Graphics g)
	{
   		super.paintComponent(g);
   		
   		for(Position p : dots)
   		{
   			g.drawRect(100 * p.X(), 500 - (10*p.Y()),1,1);
   		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		/*JOP.showMessageDialog(null, "Virus!");
			
			if(JOP.YES_OPTION == JOP.showConfirmDialog(null, "Many virus!") )
			      JOP.showInputDialog(null,"Do you want how many virus?");
			else{
				
					JOP.showMessageDialog(null, "Virus deleted!");
			}*/
			//setBackground(Color.);
	}
}
