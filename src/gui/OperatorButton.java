package gui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButton extends Button implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	CalculatorWindow cl;
	
	public OperatorButton(int x, int y, int width, int height, String caption, CalculatorWindow clw) {
		
		super(caption);
		
		setBounds(x, y, width, height);
		this.cl = clw;
		this.cl.add(this);
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String operatorText = ((OperatorButton)e.getSource()).getLabel();
		
		cl.setClear = true;
		
		double temp = Double.parseDouble(cl.display.getText());
		
		if (operatorText.equals("1/x")) {
			
			try {
				
				double tempDouble = 1/(double) temp;
				cl.display.setText(CalculatorWindow.getFormattedText(tempDouble));
				
			} catch (ArithmeticException error) {
				
				cl.display.setText("Divide by 0.");
				
			}
			
			return;
			
		}
		
		if (operatorText.equals("sqrt")) {
			
			try {
				
				double tempDouble = Math.sqrt(temp);
				
				cl.display.setText(CalculatorWindow.getFormattedText(tempDouble));
				
			} catch (ArithmeticException error) {
				
				cl.display.setText("Divide by 0.");
				
			}
			
			return;
			
		}
		
		if (!operatorText.equals("=")) {
			
			cl.number = temp;
			
			cl.operator = operatorText.charAt(0);
			
			return;
			
		}
		
		switch(cl.operator) {
		
		case '+':
			
			temp += cl.number;
		
		break;
		case '-':
			
			temp = cl.number-temp;
		
		break;
		case '*':
			
			temp *= cl.number;
		
		break;
		case'%':
			
			try {
				
				temp = cl.number % temp;
				
			} catch (ArithmeticException error) {
				
				cl.display.setText("Divide by 0."); 
				return;
				
			}
			
		break;
		case '/':
			
			try {
				
				temp = cl.number / temp;
				
			} catch (ArithmeticException error) {
				
				cl.display.setText("Divide by 0.");
				return;
				
			}
		break;
		
		}
		
		cl.display.setText(CalculatorWindow.getFormattedText(temp));
		
	}

}
