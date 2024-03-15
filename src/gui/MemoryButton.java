package gui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryButton extends Button implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	CalculatorWindow cl;
	
	// Constructor for every Memory Button
	public MemoryButton(int x, int y, int width, int height, String caption, CalculatorWindow clw) {
			
		super(caption);
		
		setBounds(x, y, width, height);
		this.cl = clw;
		this.cl.add(this);
		addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		char memOperator=((MemoryButton)e.getSource()).getLabel().charAt(1);
		
		cl.setClear = true;
		
		double temp = Double.parseDouble(cl.display.getText());
		
		switch(memOperator) {
		
		case 'C':
		
			cl.memLabel.setText(" ");
			cl.memory = 0.0;
		
		break;
		case 'R':
			
			cl.display.setText(CalculatorWindow.getFormattedText(cl.memory));
		
		break;
		case 'S':
		
			cl.memory = 0.0;
			
		case '+':
			
			cl.memory += Double.parseDouble(cl.display.getText());
			
			if (cl.display.getText().equals("0") || cl.display.getText().equals("0.0")) 
				
				cl.memLabel.setText(" ");
			
			else
				
				cl.memLabel.setText("M");
			
		break;
		
		}
		
	}

}
