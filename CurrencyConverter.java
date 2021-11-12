
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CurrencyConverter extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JPanel contentPane;
	private JComboBox startBox;
	private JComboBox endBox;
	private JButton reset;
	private JButton convert;
	private JButton exit;
	private JLabel lblNewLabel_2;
	private JLabel lblResult;
	double result = 0.0;
	double input;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter frame = new CurrencyConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CurrencyConverter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convert:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		//here is where the user enters the number
		JTextField textField = new JTextField();
		textField.setText("--,--");
		textField.setBounds(66, 8, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("To:");
		lblNewLabel_1.setBounds(10, 57, 46, 14);
		panel.add(lblNewLabel_1);
		
		startBox = new JComboBox();
		startBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "EUR", "USD", "TRY", "PLN"}));
		startBox.setBounds(162, 7, 242, 22);
		panel.add(startBox);
		
		endBox = new JComboBox();
		endBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "EUR", "USD", "TRY", "PLN"}));
		endBox.setBounds(66, 53, 86, 22);
		panel.add(endBox);
		
		lblNewLabel_2 = new JLabel("RESULT:");
		lblNewLabel_2.setBounds(162, 55, 59, 20);
		panel.add(lblNewLabel_2);
		
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we simply reset everything back to default
				startBox.setSelectedIndex(0);
				endBox.setSelectedIndex(0);
				lblResult.setText("0.00");
				textField.setText("--,--");
			}
		});
		reset.setBounds(10, 158, 89, 23);
		contentPane.add(reset);
		
		convert = new JButton("Convert");
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//this will convert the input string into a double
					input = Double.parseDouble(textField.getText());
					//now we have to work with the combo boxes and cover all possible combos
					if(startBox.getSelectedItem().equals("EUR") && endBox.getSelectedItem().equals("USD")) {
						result = input*1.15;
						lblResult.setText("$"+result);	
					}
					if(startBox.getSelectedItem().equals("USD") && endBox.getSelectedItem().equals("EUR")) {
						result = input*0.87;
						lblResult.setText("€"+result);
					}
					if(startBox.getSelectedItem().equals("EUR") && endBox.getSelectedItem().equals("EUR")) {
						lblResult.setText("why?");
					}
					if(startBox.getSelectedItem().equals("USD")&& endBox.getSelectedItem().equals("USD")) {
						lblResult.setText("stop it fool");
					}
					if(startBox.getSelectedItem().equals("EUR") && endBox.getSelectedItem().equals("TRY")) {
						result = input*11.42;
						lblResult.setText("€"+result);	
					}
					if(startBox.getSelectedItem().equals("TRY") && endBox.getSelectedItem().equals("EUR")) {
						result = input*0.08;
						lblResult.setText("TL"+result);
					}
					if(startBox.getSelectedItem().equals("EUR") && endBox.getSelectedItem().equals("EUR")) {
						lblResult.setText("why?");
					}
					if(startBox.getSelectedItem().equals("TRY")&& endBox.getSelectedItem().equals("TRY")) {
						lblResult.setText("stop it fool");
					}
					if(startBox.getSelectedItem().equals("USD") && endBox.getSelectedItem().equals("TRY")) {
						result = input*10.00;
						lblResult.setText("$"+result);	
					}
					if(startBox.getSelectedItem().equals("TRY") && endBox.getSelectedItem().equals("USD")) {
						result = input*0.10;
						lblResult.setText("TL"+result);
					}
					if(startBox.getSelectedItem().equals("USD") && endBox.getSelectedItem().equals("USD")) {
						lblResult.setText("why?");
					}
					if(startBox.getSelectedItem().equals("TRY")&& endBox.getSelectedItem().equals("TRY")) {
						lblResult.setText("stop it fool");
					}
				}catch(Exception e1) {
				    //this will warn the user if the input is invalid
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}
				
			}
		});
		convert.setBounds(160, 158, 89, 23);
		contentPane.add(convert);
		
		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this will exit the app
				System.exit(0);
			}
		});
		exit.setBounds(309, 158, 89, 23);
		contentPane.add(exit);
	}
}
