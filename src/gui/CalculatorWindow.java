package gui;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class CalculatorWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Set up dimensions for the JFrame window
	final int FRAME_WIDTH = 325;
	final int FRAME_HEIGHT = 325;
	
	// Set dimensions for the calculation display
	final int HEIGHT = 30;
	final int WIDTH = 30;
	final int H_SPACE = 10;
	final int V_SPACE = 10;
	final int X = 30;
	final int Y = 50;
		
	// Declare needed values
	public boolean setClear = true;
	double number, memory;
	char operator;
	
	// Setup strings for the button definitions
	String buttonNumbersText[] = {"7","8","9","4","5","6","1","2","3","0","0","+/-","-"};
	String buttonOperatorsText[] = {"/","sqrt","*","%","-","1/X", "+", "="};
	String buttonMemoryText[] = {"MC","MR","MS", "M+"};
	String buttonSpecialText[] = {"Backspace","C","CE"};
	
	// Create Arrays in length of the given amount of named button options above
	MemoryButton memoryButton[] = new MemoryButton[buttonMemoryText.length];
	DigitButton digitButton[] = new DigitButton[buttonNumbersText.length];
	SpecialButton specialButton[] = new SpecialButton[buttonSpecialText.length];
	OperatorButton operatorButton[] = new OperatorButton[buttonOperatorsText.length];
	
	// Create the calculation display
	Label display = new Label("0",Label.RIGHT);
	Label memLabel = new Label("",Label.RIGHT);
	
	// Constructor for the main calculator elements
	public CalculatorWindow(String frameText) {
		super(frameText);
		
		int tempX = X;
		int tempY = Y;
		
		// Configure and add the display to the main Frame
		display.setBounds(tempX, tempY, 240, HEIGHT);
		display.setBackground(Color.GRAY);
		display.setForeground(Color.WHITE);
		add(display);

		// Configure and adds the Memory component
		memLabel.setBounds(X, Y + HEIGHT + V_SPACE, WIDTH, HEIGHT);
		add(memLabel);
		
		// Create and set Coordinates for all Memory Buttons
		tempY = Y + 2*(HEIGHT + V_SPACE);
		
		for (int i = 0 ; i < memoryButton.length ; i++) {
			
			memoryButton[i] = new MemoryButton(tempX, tempY, WIDTH, HEIGHT, buttonMemoryText[i], this);
			memoryButton[i].setForeground(Color.BLACK);
			tempY += HEIGHT + V_SPACE;
			
		}
		
		// Create and set Coordinates for all Special Buttons
		tempX = X + 1*(WIDTH + H_SPACE);
		tempY = Y + 1*(HEIGHT + V_SPACE);
		
		for (int i = 0; i < specialButton.length; i++) {
			
			specialButton[i] = new SpecialButton(tempX, tempY, WIDTH * 2, HEIGHT, buttonSpecialText[i], this);
			specialButton[i].setForeground(Color.BLACK);
			tempX = tempX + 2*WIDTH + H_SPACE;
			
		}
		
		// Create and set Coordinates for all Number Buttons
		int numberX = X + WIDTH + H_SPACE;
		int numberY = Y + 2*(HEIGHT + V_SPACE);
		
		tempX = numberX;
		tempY = numberY;
		
		for (int i = 0; i < digitButton.length; i++) {
			
			digitButton[i] = new DigitButton(tempX, tempY, WIDTH, HEIGHT, buttonNumbersText[i], this);
			digitButton[i].setForeground(Color.BLACK);
			tempX += WIDTH + H_SPACE;
			
			if((i+1) % 3 == 0) {
				
				tempX = numberX;
				tempY += HEIGHT + V_SPACE;
				
			}
			
			
		}
		
		// Create and set Coordinates for all Operator Buttons
		int operatorX = numberX + 2*(WIDTH + H_SPACE) + H_SPACE;
		int operatorY = numberY;
		
		tempX = operatorX;
		tempY = operatorY;
		
		for (int i = 0; i < operatorButton.length; i++) {
			
			tempX += WIDTH + H_SPACE;
			operatorButton[i] = new OperatorButton(tempX, tempY, WIDTH, HEIGHT, buttonOperatorsText[i], this);
			operatorButton[i].setForeground(Color.BLACK);
			
			if((i+1) % 2 == 0) {
				
				tempX = operatorX;
				tempY += HEIGHT + V_SPACE;
				
			}
			
		}
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent ev) {
				
				System.exit(0);
				
			}
			
		});
		
		setLayout(null);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		
	}

	// Create a function for formatting furture Text on the display
	static String getFormattedText(double temp) {
		
		String text = "" + temp;
				
		if (text.lastIndexOf(".0") > 0) {
			
			text = text.substring(0, text.length() - 2);
			
			return text;
			
		} else
		
		return null;
		
	}
	
}
