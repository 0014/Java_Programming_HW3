package team_questions.bouncing_balls;

import java.awt.Color;
import java.util.Vector;

public class Ball {

	public int x, y; 
	public int directionX, directionY; 
	
	public Color color;
	
	private int radius;
	
	public Ball(Color c, int dirX, int dirY, int radius)
	{
		x = 300; y = 300; // default starting point
		// set its properties
		color = c;
		
		// set the direction of the ball
		// these parameters also defines the speed of the ball 
		directionX = dirX;
		directionY = dirY;
		
		// this parameter will define how big is the ball
		this.radius = radius;
	}
	
	// this property is read only
	public int getRadius()
	{
		return radius;
	}
}
