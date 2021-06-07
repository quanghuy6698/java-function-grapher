package main.forms;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.models.CoordinateGrid;
import main.models.common.Function;

public class FunctionGrapher extends JFrame{
	private JLabel coefficientsLabel;
	private JTextField coefficientsTxt;
	private JLabel coefficientsInputNoteLabel;
	private JButton drawBtn;
	private JButton exportImageBtn;
	
	private Function function;
	private CoordinateGrid coordinateGrid;
	
	public FunctionGrapher() {
		
	}
	
	private void initLayout() {
		coefficientsLabel.setSize(200, 50);
		coefficientsLabel.setText("Coefficients: ");
		coefficientsLabel.setLocation(50, 50);
	}
}
