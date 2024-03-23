package gui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButton extends Button implements ActionListener {


	private static final long serialVersionUID = 1L;
	
	CalculatorWindow cl;
	
	public DigitButton(int x, int y, int width, int height, String caption, CalculatorWindow clw) {
		// Calls upon the parent constructor with the value caption
		super(caption);
		
		setBounds(x, y, width, height);
		this.cl = clw;
		this.cl.add(this);
		addActionListener(this);
		
	}

	// Method for checking the format of a given String
	static boolean isInString(String s, char c) {
		
		for (int i = 0; i < s.length(); i++) if(s.charAt(i) == c) return true;
		
		return false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Pull the Button Label into a String after being pressed
		String tempText = ((DigitButton)e.getSource()).getLabel();

		// Check for when the . Button is being used
		if (tempText.equals(".")) {

			// Checks for if the Display is unused
			if (cl.setClear) {

				// Make your Number into a Decimal Format
				cl.display.setText("0.");
				cl.setClear = false;

				
			} else if (!isInString(cl.display.getText(), '.')) {
			
				cl.display.setText(cl.display.getText() + ".");
				
				return;
				
			}
			
		}
		
		int index = 0;
		
		try {
			// Turn the String into an Integer for calculations
			index = Integer.parseInt(tempText);

		// Checks for errors in your Format and returns to prevent crashing
		} catch (NumberFormatException error) {
			
			return;
			
		}

		// Returns when display or index reads 0 
		if (index == 0 && cl.display.getText().equals("0")) return;
		
		if (cl.setClear) {
			// Adds the Button value from index
			cl.display.setText("" + index);
			cl.setClear = false;
			
		} else cl.display.setText(cl.display.getText() + index);
		
	}

}
