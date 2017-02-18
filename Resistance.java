
public class Resistance extends Component
{
	//properties
	double resistance;
	int junctionNo;
	int type;
	char arm;
	String name;
	static int no = 1;
	
	//CONSTROCTOR
	public Resistance(double r)
	{
		super();
		name = "Resistance " + no;
		this.resistance = r;
		junctionNo = 0;
		type = 1;
		arm  = 'N';	
		no++;	
	}
	//Method
	
	public void setValue(double value)
	{
		resistance = value;
	}
	
	
	public void setCoordinates(Position p)
	{
		coordinates = p;
	}
	
	public Position getCoordinates()
	{
		return coordinates;
	} 
	
	public int getJunctionNo()
	{
		return junctionNo;
	}
	
	public void setJunctionNo(int no)
	{
		junctionNo = no;
	}
	
	public int getType()
	{
		return type;
	}
	
	public void setArm(char d)
	{
		arm = d;
	}
	public String getName()
	{
		return name;
	}
	public char getArm()
	{
		return arm; 
	}
	
	public String toString()
	{
		String str = name + " Junc " + junctionNo + " Arm " + arm + " Connected: " + connected + " Current " + current;
		return str;
	}
	
	public double getRes()
	{
		return resistance;
	}
	
	public String toPaint()
	{
		return "**";
	}
	
	public void setConnected(boolean state)
	{
		connected = state;
	}
	
	public boolean getConnected()
	{
		return connected;
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
