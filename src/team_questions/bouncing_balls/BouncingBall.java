package team_questions.bouncing_balls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BouncingBall extends JFrame  implements Runnable {

	// set the width and height of the Main Application Frame
	int WIDTH = 800, HEIGHT = 900;
	
	// Define another panel inside the main panel where the balls are bouncing
	final BallJPanel ballPanel = new BallJPanel(0);
	
	// define the timer which is responsible for every movement of the balls
	private ActionListener taskPerformer;
	
	public BouncingBall()
	{
	      super("BouncingBall");
	      
	      // define the timer function which will update the ball position
	      taskPerformer = new ActionListener() {
	          public void actionPerformed(ActionEvent evt) {
	              //...Perform this task when timer event is fired
	        	  ballPanel.repaint(); // redraw all the balls
	          }
	      };

	      // create mainJPanel to contain ballPanel
	      final JPanel mainJPanel = new JPanel();
	      mainJPanel.add(ballPanel);
	      
	      // everytime user clicks on the ball panel this event will be fired 
	      ballPanel.addMouseListener(new MouseAdapter() {
	    	    @Override
	    	    public void mouseClicked(MouseEvent e) {
	    	    	// TODO Auto-generated method stub
	    	    	// Add a new ball to the panel
	    	    	ballPanel.generateBall();
	    	    }
	    	});
	      
	      // attach the ball panel inside the main frame
	      add(mainJPanel); // add JPanel to JFrame

	      setSize(WIDTH, HEIGHT); // set size of JFrame
	      setVisible(true); // display JFrame
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BouncingBall ballApp = new BouncingBall();
		ballApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        // Create a new Thread instance, provide the task that we want to run
        // (by providing the Runnable as an argument) and give the thread a name.
        // Now we can use Thread.start() to run it!
        Thread thread = new Thread(ballApp, "Move ball(s)");
        thread.start();
	}

	@Override
	public void run() {
		 // define the timer
		 Timer timer = new Timer(10 ,taskPerformer); // define the timer interval (10 ms)
	     timer.setRepeats(true); // enable the timer to repeat
	     timer.start(); // start the timer
	}
}
