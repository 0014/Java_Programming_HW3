package team_questions.bouncing_balls;

//Fig. 18.18: FractalJPanel.java
//Drawing the "Lo feather fractal" using recursion.
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class BallJPanel extends JPanel
{
	private ArrayList<Ball> balls;
	
	private Color color; // stores color used to draw fractal
	private int level;   // stores current level of fractal
	
	private static final int WIDTH = 800;  // defines width of JPanel
	private static final int HEIGHT = 800; // defines height of JPanel
	
	private int xDir, yDir;
	
	// set the initial fractal level to the value specified
	// and set up JPanel specifications
	public BallJPanel(int currentLevel)
	{
		balls = new ArrayList<Ball>();
		
		Ball b = new Ball(Color.BLUE);
		balls.add(b);
	    
		setBackground(Color.WHITE);
	    setPreferredSize(new Dimension(WIDTH, HEIGHT));
	    
	    xDir = 1; yDir = 2; //Default direction when ball is instantiated
	}
	
	// draw fractal recursively
	public void drawBall(Ball b, Graphics g)
	{   	
		// update the next coordinate of the ball
		b.SetX(b.GetX() + xDir);
		b.SetY(b.GetY() + yDir);
		
		g.setColor(Color.BLUE);
		g.fillArc(b.GetX(), b.GetY(), 50, 50, 0, 360);
	} 
	
	// start the drawing of fractal
	@Override
	public void paintComponent(Graphics g)
	{
	   super.paintComponent(g);
	
	   // draw fractal pattern
	   g.setColor(color);
	   drawBall(balls.get(0), g);
	} 
	
	// set the drawing color to c
	public void setColor(Color c)
	{
	   color = c;
	} 
	 
	// set the new level of recursion
	public void setLevel(int currentLevel)
	{
	   level = currentLevel;
	} 
	
	// returns level of recursion 
	public int getLevel()
	{
	   return level;
	}
} // end class FractalJPanel

/*************************************************************************
* (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/
