/*import java.util.*;
public class junction
{
	//properties
	ArrayList<Component> upperArm;
	ArrayList<Component> lowerArm;
	junctionOpening open;
	junctionClosing close;
	int junctionNo = 1;
	//int type;
	
	
	//CONSTROCTOR
	public junction()
	{
		//super
		open = new junctionOpening(junctionNo);
		close = new junctionClosing(junctionNo);
		junctionNo++;
		//type = -1;
	}
	//MEthods
	public int getJunctionNo()
	{
		return junctionNo;
	}
	
	public Component getOpen()
	{
		return open;
	}
	
	public Component getClose()
	{
		return close;
	}
	
	//public int getType()
	//{
	//	return type;
	//}
	
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
		if( d == 'u')
			upperArm.add(c);
		else
		{
			if(d == 'l')
				lowerArm.add(c);		//fix this
			
		}
	}
	

}
*/