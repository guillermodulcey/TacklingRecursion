/*************************************
An UI for the Fibonacci secuence

Code by: Hernán Guillermo Dulcey Morán
October 2019
**************************************/
package UI;

/*************************************
My Fibonacci classes
*************************************/
import FibonacciProject.*;
import TimeComparison.*;

/*************************************
Java UI classes
**************************************/
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class FibonacciUI{

	/******************
	UI components
	******************/
	private JTextField userInput;
	private JTextField number;
	private JFrame frame;
	private JButton getNumber;
	private JButton reset;
	private JMenu menu;
	private boolean loop = true;
	private String loopLabel = "Loop";
	private String recursionLabel = "Recursion";

	public static void main(String[] args) {
		FibonacciUI fui = new FibonacciUI();
		fui.go();
	}

	/******************
	UI building method
	******************/
	public void go(){
		JMenuBar menuBar = new JMenuBar();
		JPanel mainPanel = new JPanel();
		JMenuItem menuItemLoop = new JMenuItem(loopLabel);
		JMenuItem menuItemRecu = new JMenuItem(recursionLabel);

		/*****************
		Menu creation
		******************/
		menu = new JMenu(loopLabel);
		
		menuItemLoop.addActionListener(new GetLoopImplementation());
		menu.add(menuItemLoop);

		menuItemRecu.addActionListener(new GetRecursionImplementation());
		menu.add(menuItemRecu);

		menuBar.add(menu);
		mainPanel.add(menuBar);

		/*****************
		User input 
		*****************/
		userInput = new JTextField(10);
		userInput.setText("1");
		userInput.setEditable(true);
		mainPanel.add(userInput);

		number = new JTextField(20);
		number.setText("0");
		number.setEditable(false);
		mainPanel.add(number);

		/*****************
		Button management  
		*****************/
		getNumber = new JButton("get the fibonacci value");
		getNumber.addActionListener(new GetNumberListener());
		mainPanel.add(getNumber);

		reset = new JButton("reset");
		reset.addActionListener(new ResetListener());
		mainPanel.add(reset);

		/******************
		Frame management
		******************/
		frame = new JFrame("Fibonacci");
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/******************************************************************
	Action listeners: these are going to help with the UI interactions
	******************************************************************/
	/******************************************************************
	GetNumberListener: Chooses which Fibonacci method to use according
	to the user's selection
	******************************************************************/
	public class GetNumberListener implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			int value = Integer.parseInt(userInput.getText());
			long result;
			if(loop){
				result = FibonacciLoop.fibonacci(value);
			}
			else{
				result = Fibonacci.fibonacci(value);
			}
			
			number.setText(Long.toString(result));
		}
	}

	/******************************************************************
	GetNumberListener: Chooses which Fibonacci method to use according
	to the user's selection
	******************************************************************/
	public class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			userInput.setText("1");
			number.setText("0");
		}
	}

	/******************************************************************
	GetLoopImplementation: Changes the variable loop so the program
	knows which Fibonacci implementation the user wants
	******************************************************************/
	public class GetLoopImplementation implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			loop = true;
			menu.setText(loopLabel);
		}
	}

	/*******************************************************************
	GetRecursionImplementation: Changes the variable loop so the program
	knows which Fibonacci implementation the user wants
	*******************************************************************/
	public class GetRecursionImplementation implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			loop = false;
			menu.setText(recursionLabel);
		}
	}
}