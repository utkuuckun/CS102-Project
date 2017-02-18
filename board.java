import java.util.*;
import java.io.*;
public class board 
{
	//properties	
	Component[][] 		  			motherboard;
	ArrayList<Component>			connectedComponents;
	ArrayList<junctionOpening>		junctionOpenings;		//for storing junction with their no
	ArrayList<Information>			experiment;				//For sttoring previous experiments
	ArrayList<ArrayList>			storage;
	int 							no = 1;
	boolean 						connected = true;		//change this nonsense!!
	double 							totalVoltage;
	double 							totalResistance;
	double 							totalCurrent; 
	int 							joRes = 0;
	int 							serRes = 0;
	double 							K;
	ArrayList<Component>			saved;
		
	//CONSTROCTOR
	public board()
	{
		motherboard = new Component[20][20];
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				motherboard[i][j] = null;
			}
		}
		connectedComponents = new ArrayList<Component>();
		//junctionOrder = new ArrayList<Integer>();
		junctionOpenings = new ArrayList<junctionOpening>();
		
		totalVoltage = 0;
		totalResistance = 0;
		saved = new ArrayList<Component>();
		experiment = new ArrayList<Information>();
		storage = new ArrayList<ArrayList>();
	}
	
	//Methods
	
	//add battery method
	public boolean addBattery(Position a)
	{
		if(motherboard[a.X()][a.Y()] == null)
		{
			Battery b = new Battery(0);
			b.setCoordinates(a); 
			motherboard[a.X()][a.Y()] = b;
			connectedComponents.add( (Component)b );
			return true;
		}
		else 
			return  false;
	}
	//add resistance method
	public boolean addResistance(Position p)
	{
		if(motherboard[p.X()][p.Y()] == null)
		{
			Resistance r  = new Resistance(0);
			r.setCoordinates(p);
			connectedComponents.add(r);
			motherboard[p.X()][p.Y()] = connectedComponents.get(connectedComponents.indexOf(r));	//fix this
			
			return true;
		}
		else 
			return  false;
	}
	
	//Add junction method
	public boolean addJunction(Position p)
	{
		if(motherboard[p.X()][p.Y()] == null && motherboard[p.X()+2][p.Y()] == null && motherboard[p.X() + 1][p.Y()] == null && p.X() < 18)
		{
			junctionOpening j = new junctionOpening(no, p);
			//j.setCoordinates(p);
			no++;
			motherboard[p.X()][p.Y()] = j;	//addidng the junction openings and closings 
			motherboard[p.X() + 2][p.Y()] = j.getClose();
			connectedComponents.add(j);
			connectedComponents.add(j.getClose());
			junctionOpenings.add(j);
			
			return true;
		}
		else
			return false;
	}
	
	public void remove(Position p) //change
	{
		motherboard[p.X()][p.Y()] = null;
	}
	
	public boolean moveComponent(Position p1, Position p2)
	{
		if(getComponent(p1) != null && getComponent(p2) == null)
		{
			motherboard[p2.X()][p2.Y()] = getComponent(p1);
			remove(p1);
			return true;		
		}
		else
			return false;
	}
	
	public Component getComponent(Position p)
	{
		return motherboard[p.X()][p.Y()];
	}
	
	public int indexOfComponent(Component p)
	{
		return connectedComponents.indexOf(p);
	}
	
	public ArrayList<Component> getConnectedComponents()
	{
		return connectedComponents;
	}
	
	public double getTotalVoltage()
	{
		return totalVoltage;
	}
	
	public ArrayList getJunctionOpenings()
	{
		return junctionOpenings;
	}
	
	public void printBoard()
	{
		for(int y = 0; y < 20; y++)
		{
			for(int x = 0; x < 20; x++)
			{
				if(getComponent(new Position(x,y)) == null)
					System.out.print(".." + "|");
				else
					System.out.print(getComponent(new Position(x,y)).toPaint() + "|");
			}
			System.out.println();
		}
	}
	
	public void disconnect(Position p1, Position p2)
	{
		getComponent(p1).setConnected(false);
		getComponent(p1).next = new ArrayList<Component>();
		getComponent(p2).setJunctionNo(0);
		getComponent(p2).setArm('N');
	}
	
	//Connect componenets together!!!!!!!!!!!!!!!!!!!!!
	
	
	public int connect(Position p1, Position p2)
	{
		//properties
		//boolean connected = true;
		
		if(getComponent(p1) == null || getComponent(p2) == null)
		{
			return -1;
		}
		else
		{
			if(getComponent(p1).getJunctionNo() == 0 || getComponent(p1).getType() == 3)
			{
				Component temp = connectedComponents.remove(connectedComponents.indexOf(getComponent(p2))  );
				connectedComponents.add( (connectedComponents.indexOf(getComponent(p1)) + 1) ,temp);  //adds second component after the first one in the array
				getComponent(p1).setConnected(true);
				getComponent(p1).next.add(getComponent(p2)); 
				//getComponent(p2).setConnected(true);	
			}
			else
			{
				
				if(getComponent(p1).getType() == 2 && getComponent(p2).getType() != 2 && getComponent(p2).getType() != 0)		//Adding a component to a junction
				{					
					if( ( ( junctionOpening)getComponent(p1)).uSize() == 0)
					{
						getComponent(p2).setArm('U');
						int no = getComponent(p1).getJunctionNo(); //Setting second componennt's junction arm location and junction no
						getComponent(p2).setJunctionNo(no);
						
						
						( (junctionOpening)getComponent(p1)).add(getComponent(p2).getArm(),getComponent(p2)); 	//Adding component to upper arm
											
					}
					else
					{
						getComponent(p2).setArm('L');
						
						int no = getComponent(p1).getJunctionNo(); //Setting second componennt's junction arm location and junction no
						getComponent(p2).setJunctionNo(no);
						( (junctionOpening)getComponent(p1)).add(getComponent(p2).getArm() ,getComponent(p2));	//adding component to lower arm
						
						
						
					}
					Component temp = connectedComponents.remove(connectedComponents.indexOf(getComponent(p2)) );
					connectedComponents.add( (connectedComponents.indexOf(getComponent(p1)) + 1) ,temp);
					getComponent(p1).setConnected(true); 
					getComponent(p1).next.add(getComponent(p2));
					return 1;
				}
				else
				{
					if(getComponent(p1).getArm() != 'N'  && getComponent(p1).getType() != 0 && getComponent(p1).getType() != 2 &&  getComponent(p2).getType() != 3) 		//if a component is connected to a component which is in a junction
					{
						getComponent(p2).setArm(getComponent(p1).getArm());
					
						for(junctionOpening x : junctionOpenings)
						{
							if(x.getJunctionNo() == getComponent(p1).getJunctionNo())
							{
								x.add(getComponent(p2).getArm(), getComponent(p2)); 
							}
						} 	//adding the second component to the correcponding junction	//adding the second component to the correcponding junction
					
						Component temp = connectedComponents.remove(connectedComponents.indexOf(getComponent(p2)) );
					
						connectedComponents.add( (connectedComponents.indexOf(getComponent(p1)) + 1) ,temp);
						getComponent(p1).setConnected(true); 
						getComponent(p1).next.add(getComponent(p2));
						return 1;
					}
					else
					{
						if( getComponent(p1).getType() == 2 && getComponent(p2).getType() == 2 && getComponent(p2).getJunctionNo() != getComponent(p1).getJunctionNo())//If there is a junction in another junction
						{
							if(getComponent(p1).getArm() == 'U' || ( ( junctionOpening)getComponent(p1)).uSize() == 0)
							{	
								getComponent(p2).setArm('U');
								(( junctionOpening)	getComponent(p1)).add('U', getComponent(p2));
							}
								
							else
							{	
								getComponent(p2).setArm('L');
								(( junctionOpening)	getComponent(p1)).add('L', getComponent(p2));
							}
							
							Component temp = connectedComponents.remove(connectedComponents.indexOf(getComponent(p2)) );
							
							junctionOpenings.remove( junctionOpenings.indexOf( getComponent( p2)));
							
							junctionOpenings.add( junctionOpenings.indexOf( getComponent(p1)) , ((junctionOpening)temp) );	//adding the second junctions no infront in the line so calclulations will beging from the inner junction to out.
							
							connectedComponents.add( (connectedComponents.indexOf(getComponent(p1)) + 1) ,temp);
							getComponent(p1).setConnected(true); 
							getComponent(p1).next.add(getComponent(p2));
							return 1;
						}
						else
						{
							if(getComponent(p1).getJunctionNo() != getComponent(p2).getJunctionNo() && getComponent(p2).getType() == 3 && getComponent(p1).getType() != 3)	//if a junction closing of another junction is connected to a component in a another junction
							{
								return -2;
							}
							else
							{
								if(getComponent(p2).getType() == 3  ) //closing a junction
								{
									Component temp = connectedComponents.remove(connectedComponents.indexOf(getComponent(p2)));
								//	connectedComponents.get(connectedComponents.indexOf(getComponent(p1)) + 1).setConnected(false);
									connectedComponents.add( (connectedComponents.indexOf(getComponent(p1)) + 1) ,temp); //may add more function later
									getComponent(p1).setConnected(true);
									getComponent(p1).next.add(getComponent(p2)); 
								}
								else
								{
									return 1;
								}
							}
						}														
					}
				}
			}
		}
		return 1;
	}
	
	public boolean circuit()
	{
		boolean a = true;
		for(Component c : connectedComponents)
		{
			if (! (c.getConnected()))
				a = false;	
		}
		
		return a;
	}
	
	//COMPILE. THIS IS IMPORTANT
	
	public boolean compile()
	{
		if(circuit())
		{
			ArrayList<junctionOpening> tempe = new ArrayList<junctionOpening>();
			
			for(int j = 0; j < junctionOpenings.size(); j++)	//copying the junctionOpenings
			{
				tempe.add(junctionOpenings.get(j).clone());
			//	connectedComponents.remove(junctionOpenings.get(j));
			//	connectedComponents.add(tempe.get(j));
			}
			
			for(int i = 0; i < tempe.size() - 1;i++)
			{
				if( tempe.get(i).getArm() != 'N')
				{	
					Resistance temp = new Resistance(tempe.get(i).calcTotal());
					
					temp.setJunctionNo(tempe.get(i + 1).getJunctionNo());
					
					tempe.get(i+1).delete(tempe.get(i).getArm());
					
					tempe.get(i + 1).add( tempe.get(i).getArm(), temp );	//adding total resistance of the inner junction
				}
			}
			
			for(junctionOpening jo: tempe)
			{
				if(jo.getArm() == 'N')
					joRes += jo.calcTotal();
			}
			
			for(Component c: connectedComponents)
			{
				
				if(c.getArm() == 'N' && c.getType() == 1)
					serRes += ((Resistance)c).getRes();
			}
			
			
			for(Component b : connectedComponents)
			{
				if( b.getType() == 0)
					totalVoltage += ((Battery)b).getVolt();
			}
			
			totalResistance = serRes + joRes;
		
				
				totalCurrent = totalVoltage / totalResistance;			//We found the total current
				
				for(Component c: connectedComponents)
				{
					if(c.getArm() == 'N')
						c.setCurrent(totalCurrent);	//component which does not have arm
				}
				
				
				
				for(int i = junctionOpenings.size() - 1; i >= 0; i--)
				{
					junctionOpening temp = junctionOpenings.get(i);
					
					K = junctionOpenings.get(i).getCurrent() / (tempe.get(i).upperRes + tempe.get(i).lowerRes);
					
					for(Component c1: junctionOpenings.get(i).upperArm)
					{
						c1.setCurrent(K * tempe.get(i).lowerRes);
					}
					
					for(Component c2: junctionOpenings.get(i).lowerArm)
					{
						c2.setCurrent(K * tempe.get(i).upperRes);
					}  
						
					
				}
				
				for(Component c : connectedComponents)
				{
					
					if(c.getType() == 0)
						experiment.add(new Information ( 0, ((Battery)c).getVolt(), c.getCurrent(), ((Battery)c).getName() ) );
						
					if(c.getType() == 1)
						experiment.add(new Information ( ((Resistance) c).getRes(), 0, c.getCurrent(), ((Resistance)c).getName() ) );
						
					
				}
				storage.add(experiment);
				
			return true;
		}
		else
			return false;
	}
	
		
	public void save(File fileName) throws FileNotFoundException 
	{
		
		try	
		{
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject( connectedComponents );
			oos.close();
			//fos.close();
		}
		
		catch(IOException e)
		{	
	  		System.out.println(e.getMessage());
		}
	}
	
	
	public void read(File fileName) throws FileNotFoundException {
		
		try{
	
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			saved = (ArrayList<Component>) ois.readObject();
		}
		
		catch(ClassNotFoundException a){	
			System.out.println(a.getMessage());
		}
		
		ois.close();}
		
		catch(IOException e ){
			System.out.println(e.getMessage());
		}
	
	}
		
		public 	ArrayList<Component> getSaved(){
			return saved;
		}
	
	

}
