
import java.util.*;
public class junctionOpening extends Component
{
	//properties
	int type = 2;
	ArrayList<Component> upperArm;
	ArrayList<Component> lowerArm;
	junctionClosing close;
	
	int junctionNo;
	double totalResistance;
	char arm = 'N';
	int junctionType = -1;
	double lowerRes;
	double upperRes;
	
	//CONSTROCTOR
	public junctionOpening(int No, Position p)
	{
		super();
		junctionNo = No;
		close = new junctionClosing(junctionNo);
		
		upperArm = new ArrayList<Component>();
		lowerArm = new ArrayList<Component>();
		 
		close.setArm(getArm());	
		setCoordinates(p);		
		close.setCoordinates(new Position( getCoordinates().X() + 2, getCoordinates().Y()));
	}
	
	public int getType()
	{
		return type;
	}
	
	public Component getClose()
	{
		return close;
	}
	
	public void setJunctionNo(int no)
	{
		
	} 
		
	public int getJunctionNo()
	{
		return junctionNo;
	}
	
	public int uSize()
	{
		return upperArm.size();
	}
	
	public int lSize()
	{
		return lowerArm.size();
	}
	
	public void add(char d ,Component c)
	{
		if( d == 'U')
			upperArm.add(c);
		else
		{
			if(d == 'L')
				lowerArm.add(c);
		}
			
	}
	public void delete(char a)
	{
		if (a == 'U')
			upperArm = new ArrayList<Component>();
			
		else if (a == 'L')
			lowerArm = new ArrayList<Component>();
	}
	
	public void setArm(char d)
	{
		arm = d;
		close.setArm(arm);
	}
	
	public char getArm()
	{
		return arm;
	}
	
	public String toString()
	{
		String str = "Juncion no of this junc " + junctionNo + " Arm: " + arm + " Connected: " + connected + " Current " + current;
		return str;
	}
	
	public void setValue(double val)
	{
	}
	
	public double calcUpper()
	{
		//properties
		upperRes = 0;
		
		for(Component c: this.upperArm)
			upperRes += ((Resistance)c).getRes();
			
		return upperRes;
	}
	
	public double calcLower()
	{
		//properties
		lowerRes = 0;
		
		for(Component c: this.lowerArm)
			lowerRes += ((Resistance)c).getRes();
			
		return lowerRes;
	}
	
	public double calcTotal()
	{
		//properties
		double total;
		
		total = ((double) 1/this.calcUpper() ) + ((double) 1/this.calcLower() );
		
		totalResistance = (1/total);
		return (1/total);
	}
	
	public String toPaint()
	{
		return "-|";
	}
	
	public void setConnected(boolean state)
	{
		connected = state;
	}
	
	public boolean getConnected()
	{
		return connected;
	}
	
	public void setCoordinates(Position p)
	{
		coordinates = p;
	}
	
	public Position getCoordinates()
	{
		return coordinates;
	} 
	
	public double getCurrent()
	{
		return current;
	}
	
	public void setCurrent(double a)
	{
		current = a;
	}
	

	public junctionOpening clone()
	{
		junctionOpening temp = new junctionOpening(this.getJunctionNo(), this.getCoordinates());
		temp.setArm(this.getArm());
		temp.upperArm = this.upperArm;
		temp.lowerArm = this.lowerArm; 
		return temp;
	}
}
