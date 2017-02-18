 import java.awt.*;
 import javax.swing.*;
/**
 * @(#)Main.java
 *
 * Main application: sdasdaf
 *
 * @author: Utku Uckun 
 * @version 1.00 2015/2/25
 */
 import java.io.*;
public class Main 
{
    
    public static void main(String[] args) 
    {
    	
    	// Lets test this
    	
    	//properties
    	Position p1;
    	Position p2;
    	Position p3;
    	Position p4;
    	Position p5;
    	Position p6;
    	Position p7;
    	Position p8;
    	Position p9;
    	Position p10;
    	Position p11;
    	Position p12;
    	Position p13;
    	Position p14;
    
    	board    template;	
    	template = new board();
    	
    	//code
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	p1 = new Position(5,10);
    	
    	p2 = new Position(3,4);
    	
    	p3 = new Position(5,3);
    	
    	p4 = new Position(6,2);
    	
    	p5 = new Position(6,4);    
    		
    	p6 = new Position(6,6);
    	
    	p7 = new Position(5, 4); //j closing
    	
    	p8 = new Position(7,3); //j closing
    	
    	p9 = new Position(8,4);    
    	
    	p10 = new Position(10,4);
    	
    	p11 = new Position(11,3);
    	
    	p12 = new Position(11,5);	
    	
    	p13 = new Position(12,4);
    	
    	//p11 = new Position(1,1);	
    	
    	template.addBattery(p1);
    	
    	//template.addResistance(p2);
    	
    	template.addResistance(p4);
    	
    	template.addResistance(p5);
    	
    	template.addResistance(p6);	
    	
    	template.addJunction(p2);
    	
    	template.addJunction(p3);
    	
    	template.addJunction(p10);
    	
    	template.addResistance(p11);
    	
    	template.addResistance(p12);
    	
    	//template.getComponent(p2).setValue(5);
    	
    	for(Component c : template.getConnectedComponents())
    		System.out.println( c.toString());
    	
    	System.out.println();
    	
    	template.getComponent(p5).setValue(12);
    	
    	template.getComponent(p4).setValue(12);
    	
    	template.getComponent(p6).setValue(6);
    	
    	template.getComponent(p11).setValue(12);
    	
    	template.getComponent(p12).setValue(4);
    	
    	template.getComponent(p1).setValue(72);
    	
    	System.out.println(template.getJunctionOpenings().get(0));
    	System.out.println(template.getJunctionOpenings().get(1));
    	System.out.println(template.getJunctionOpenings().get(2));
    		System.out.println();	System.out.println();
    	
    
    	template.connect(p1,p2);
    	
    	template.connect(p2,p3);
    	
    	template.connect(p3, p4);
    	 
    	template.connect(p3,p5);  	
    	
    	template.connect(p4, p8);
    	 
    	template.connect(p5,p8);  	
    	
    	template.connect(p2,p6);
    	
    	template.connect(p6,p7);  	
    	
    	template.connect(p8,p7);
    	
    	template.connect(p7,p10);
    	
    	template.connect(p10,p11);
    	
    	template.connect(p10,p12);
    	
    	template.connect(p11,p13);
    	
    	template.connect(p12,p13);
    	
    	template.connect(p13,p1);
    	
    	
    	template.moveComponent(p7,p9);
    	
    	
    	
    	for(Component c : template.getConnectedComponents())
    		System.out.println( c.toString());
    	
    	System.out.println();
    	
    	
    		
    	System.out.println();	System.out.println();
    	
    	//System.out.println( ((junctionOpening)template.getComponent(p3)).calcTotal());
    	
    	template.compile();
    	
    	
    	System.out.println();	System.out.println();
    	
    	for(Component c : template.getConnectedComponents())
    		System.out.println( c.toString());
    		
    	System.out.println();	System.out.println();
//    		FileNotFoundException e = new FileNotException();
    	System.out.println(template.getComponent(p1).next.get(0).toString());
    	
    	File f = new File("D:/Users/irem.yuksel-ug/Documents/Saves/utku");
    	
    	//System.out.println(f.list()[0]);
    	try{
    	
    	template.save(f);}
    	
    	catch(FileNotFoundException e)
    		{System.out.println("File Not found");
    	}
    	
    	try {template.read(f);}
    
    	catch (FileNotFoundException e){
    
	    	System.out.println("File Not found");
	    }	
	    	
	    
   		System.out.println(template.getSaved().size());
  		
  		for(Component c : template.getSaved())
    		System.out.println( c.toString());
    		
    	
    	myPanel graph = new myPanel(template.storage);
    	JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(graph);
    	graph.setPreferredSize(new Dimension(500,500));
    	frame.pack();
    	frame.setVisible( true);
    	
    	for(Position p : graph.dots)
    		System.out.println(p.X() + " | " + p.Y());
}
}