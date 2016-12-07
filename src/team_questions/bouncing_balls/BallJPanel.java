package team_questions.bouncing_balls;

//Fig. 18.18: FractalJPanel.java
//Drawing the "Lo feather fractal" using recursion.
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class BallJPanel extends JPanel
{
	private ArrayList<Ball> balls;
	
	// define all the colors in an array
	private Color[] colors = new Color[]{Color.BLUE, Color.CYAN, Color.BLACK, Color.RED, 
											Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE,
											Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.PINK};
	
	private static final int WIDTH = 800;  // defines width of JPanel
	private static final int HEIGHT = 800; // defines height of JPanel
	
	public BallJPanel(int currentLevel)
	{
		balls = new ArrayList<Ball>();
		
		setBackground(Color.WHITE);
	    setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	// this function will draw a single ball and its shadow
	public void drawBall(Ball ball, Graphics g)
	{   
		// calculate the new coordinate of the ball
		int newX = ball.x + ball.directionX; // set new x position
		int newY = ball.y + ball.directionY; // set new y position
		
		// check if ball hits the panel edges
		if(newX > (WIDTH - ball.getRadius()) || newX < 0)
			ball.directionX = ball.directionX * -1;
		
		if(newY > (HEIGHT - ball.getRadius()) || newY < 0)
			ball.directionY = ball.directionY * -1;
		
		// update the next coordinate of the ball
		ball.x = newX;
		ball.y = newY;
		
		//draw the ball
		g.setColor(ball.color);
		g.fillArc(ball.x, ball.y, ball.getRadius(), ball.getRadius(), 0, 360);
		
		//draw the shadow the ball
		if(ball.y > HEIGHT / 2){
			g.setColor(Color.DARK_GRAY);
			int shadowWidth = (ball.y - HEIGHT/2) / ((HEIGHT - HEIGHT / 2) / ball.getRadius());
			int shadowHeight = 6;
			
			g.fillArc(ball.x, HEIGHT - shadowHeight, shadowWidth, shadowHeight, 0, 360);
		}
	}
	
	// generates a ball with random color
	// random speed and direction
	// random radius 
	public void generateBall()
	{
		// define a random generator
		Random rand = new Random();
		
		// generate all the random properties
		int color = rand.nextInt(colors.length);
		int radius = 30 + rand.nextInt(50);
		int directionX = -5 + rand.nextInt(10);
		int directionY = -5 + rand.nextInt(10);
		
		// generate the ball with all the random properties attached to it
		Ball ball = new Ball(colors[color], directionX, directionY, radius);
		balls.add(ball); // add the created ball into our ball list
	}
	
	// redraw all the balls with its updated coordinates
	@Override
	public void paintComponent(Graphics g)
	{
	   super.paintComponent(g);
	
	   // draw all the balls in the ball list
	   for (Ball ball :balls){
		   drawBall(ball, g);	
	   }
	}
} // end class BallJPanel