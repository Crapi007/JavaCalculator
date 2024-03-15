package gui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialButton extends Button implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	CalculatorWindow cl;
	
	public SpecialButton(int x, int y, int width, int height, String caption, CalculatorWindow clw) {
		
		super(caption);
		
		setBounds(x, y, width, height);
		this.cl = clw;
		this.cl.add(this);
		addActionListener(this);
		
	}
	
	static String backSpace(String s) {
		
		String r = "";
		
		for (int i = 0; i < s.length() - 1; i++) r += s.charAt(i);
			
			return r;

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String operatorText = ((SpecialButton)e.getSource()).getLabel();

		if (operatorText.equals("Backspace")) {
			
			String tempText = backSpace(cl.display.getText());
			
			if (tempText.equals(""))
				
				cl.display.setText("0");
		
			else
				
				cl.display.setText(tempText);
		
			return;
		}
		
		if (operatorText.equals("C")) {
			
			cl.number = 0.0;
			cl.operator = ' ';
			cl.memory = 0.0;
			cl.memLabel.setText(" ");
			
			
		}
		
		cl.display.setText("0");
		cl.setClear = true;
		
	}

}
