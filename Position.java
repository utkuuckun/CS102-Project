import java.io.*;

public class Position implements Serializable
{
	//properties
	int x;
	int y;
	
	//CONSTROCTOR
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	//Method
	public int X()
	{
		return x;
	}
	
	public int Y()
	{
		return y;
	}
	
	public Position plus(int a, int b)
	{
		x = x + a;
		y = y + b;
		return new Position(x,y);
	}
}
