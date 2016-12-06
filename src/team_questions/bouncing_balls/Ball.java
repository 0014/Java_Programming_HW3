package team_questions.bouncing_balls;

import java.awt.Color;
import java.util.Vector;

public class Ball {

	private int x, y;
	public Color color;
	
	public Ball(Color c)
	{
		x = 300; y = 300; // default starting point
		color = c;
	}
	
	public void SetX(int x)
	{
		this.x = x; 
	}
	
	public void SetY(int y)
	{
		this.y = y; 
	}
	
	public int GetX()
	{
		return x;
	}
	
	public int GetY()
	{
		return y;
	}
}
