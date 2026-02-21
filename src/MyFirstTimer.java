import acm.graphics.*;
import acm.program.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFirstTimer extends GraphicsProgram {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int MAX_STEPS = 20;
	
	private GLabel myLabel;
	private int numTimes; // tracks how many times actionPerformed is called
	private Timer t;	// moved so action performed may access

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		myLabel = new GLabel("# of times called?", 0, 100);
		add(myLabel);
		
		numTimes = 0;	// Init timer to 0.
		
		// Create timer 1000ms, notifies class
		Timer t = new Timer(1000, this);
		t.setInitialDelay(3000);	// waits 3 seconds before first tick
		// Starting the timer
		t.start();
	}
	
	// Called auto every 10 seconds
	public void actionPerformed(ActionEvent e) {
		myLabel.move(5, 0);
		numTimes++;	// increment counter
		myLabel.setLabel("# of times called? " + numTimes);	//updates the label text
		
		if (numTimes == 10) {	// stops the timer after 10 ticks
			t.stop();
		}
	}
	
	public static void main(String[] args) {
		new MyFirstTimer().start();
	}
}