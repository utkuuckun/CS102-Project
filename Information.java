


/**
* Method Information
*
*
*	 
*/
	 
public class Information {
	
	double resistance;
	double voltage;
	double current;
	String name;
		
	
	public Information(double resistance,double voltage,double current,	String name) {
		this.resistance = resistance;
		this.voltage = voltage;
		this.current = current;
		this.name = name;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getResistance()
	{
		return resistance;
	}
	
	public double getVoltage()
	{
		return voltage;
	}
	
	public double getCurrent()
	{
		return current;
	}	
		
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setResistance(double resistance)
	{
		this.resistance = resistance;
	}
	
	public void setVoltage(double voltage)
	{
		this.voltage = voltage;
	}
	
	public void setCurrent(double current)
	{
		this.current = current;
	}
	
	
}
