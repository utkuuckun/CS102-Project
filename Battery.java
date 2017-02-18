
public class Battery extends Component
{
	//propetties
	double 			voltage;
	int junctionNo = 0;
	int type;
	char arm;
	String name;
	static int no = 1;
	
	//CONSTROCTOR
	public Battery(double voltage)
	{
		super();
		name = "Battery " + no;
		this.voltage = voltage;
		type = 0;
		arm = 'N';
		no++;
	}
	
	//Methods
	public void setValue(double value)
	{
		voltage = value;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getJunctionNo()
	{
		return junctionNo;
	}
	
	public void setJunctionNo(int no)
	{
		junctionNo = no;
	}
	
	public void setArm(char d)
	{
		arm = d;
	}
	
	public char getArm()
	{
		return arm; 
	}
	
	public int getType()
	{
		return type;
	}
	
	public String toString()
	{
		String str = name + " Junc " + junctionNo + " Arm " + arm + " Connected: " + connected + " Current " + current;
		return str;
	}
	
	public double getVolt()
	{
		return voltage;
	}
	
	public String toPaint()
	{
		return "[]";
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
