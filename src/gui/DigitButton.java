package gui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButton extends Button implements ActionListener {


	private static final long serialVersionUID = 1L;
	
	CalculatorWindow cl;
	
	public DigitButton(int x, int y, int width, int height, String caption, CalculatorWindow clw) {
		
		super(caption);
		
		setBounds(x, y, width, height);
		this.cl = clw;
		this.cl.add(this);
		addActionListener(this);
		
	}
	
	static boolean isInString(String s, char c) {
		
		for (int i = 0; i < s.length(); i++) if(s.charAt(i) == c) return true;
		
		return false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String tempText = ((DigitButton)e.getSource()).getLabel();
		
		if (tempText.equals(".")) {
			
			if (cl.setClear) {
				
				cl.display.setText("0.");
				cl.setClear = false;
				
			} else if (!isInString(cl.display.getText(), '.')) {
			
				cl.display.setText(cl.display.getText() + ".");
				
				return;
				
			}
			
		}
		
		int index = 0;
		
		try {
			
			index = Integer.parseInt(tempText);
			
		} catch (NumberFormatException error) {
			
			return;
			
		}
		
		if (index == 0 && cl.display.getText().equals("0")) return;
		
		if (cl.setClear) {
			
			cl.display.setText("" + index);
			cl.setClear = false;
			
		} else cl.display.setText(cl.display.getText() + index);
		
	}

}
