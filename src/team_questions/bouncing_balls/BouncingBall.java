package team_questions.bouncing_balls;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Handler;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import individual_questions.fractal.Fractal;
import individual_questions.fractal.FractalJPanel;

public class BouncingBall extends JFrame  {
	
	int WIDTH = 800;
	int HEIGHT = 900;
	
	final BallJPanel drawSpace = new BallJPanel(0);
	
	public BouncingBall()
	{
	      super("BouncingBall");
	      
	      // set up control panel
	      final JPanel controlJPanel = new JPanel();
	      controlJPanel.setLayout(new FlowLayout());

	      // create mainJPanel to contain controlJPanel and drawSpace
	      final JPanel mainJPanel = new JPanel();
	      mainJPanel.add(controlJPanel);
	      mainJPanel.add(drawSpace);

	      // set up color button and register listener
	      final JButton changeColorJButton = new JButton("Test Button");
	      controlJPanel.add(changeColorJButton);
	      changeColorJButton.addActionListener(
	         new ActionListener() // anonymous inner class
	         {
	            // process changeColorJButton event
	            @Override
	            public void actionPerformed(ActionEvent event)
	            {
	               	drawSpace.repaint();
	            } 
	         } // end anonymous inner class
	      ); // end addActionListener
	      
	      add(mainJPanel); // add JPanel to JFrame

	      setSize(WIDTH, HEIGHT); // set size of JFrame
	      setVisible(true); // display JFrame
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BouncingBall ballApp = new BouncingBall();
		ballApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
