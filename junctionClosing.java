
public class junctionClosing extends Component
{
	//properties
	int junctionNo;
	int type;
	char arm;
	
	//CONSTROCTOR
	public junctionClosing(int no)
	{
		junctionNo = no;
		type = 3;
		//arm = 'N';
	}
	
	public int getType()
	{
		return type;
	}
	
	public int getJunctionNo()
	{
		return junctionNo;
	}
	
	public void setArm(char d)
	{
		arm = d;
	}
	
	public char getArm()
	{
		return arm;
	}
	
	public void setJunctionNo(int no)
	{
		
	}
	
	public String toString()
	{
		String str = "Juncion closing of " + junctionNo + " Arm: " + arm + " Connected: " + connected + " Current " + current;
		return str;
	}
	
	public void setValue(double val)
	{
	}
	
	public String toPaint()
	{
		return "|-";
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
}
