import java.util.*;
import java.io.*;
public abstract class  Component implements Serializable
{
	//properties
	int type;
	int junctionNo;
	boolean connected = false;
	protected Position coordinates;
	protected double current;
	ArrayList<Component>  next;
	
	//CONSTROCTOR
	public Component()
	{
		next = new ArrayList<Component>();
	}
	
	//Methods

	
	public abstract int getJunctionNo();
	public abstract void setCoordinates(Position p);
	public abstract Position getCoordinates();
	public abstract void setJunctionNo(int no);
	
	public abstract void setCurrent(double c);
	public abstract double getCurrent();
	public abstract int getType();
	
	public abstract void setArm(char d);
	
	public abstract char getArm();
	
	public abstract String toString();
	
	public abstract void setValue(double value);
	
	public abstract String toPaint();
	
	public abstract void setConnected(boolean state);
		
	public abstract boolean getConnected();
}
