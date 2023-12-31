import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NurseGUI implements ActionListener{
	//info labels
	private static JLabel patientLabel;
	private static JLabel barcodeLabel;
	//entry fields
	private static JTextField patientText;
	private static JTextField barcodeText;
	//buttons
	private static JButton pButton;
	private static JButton bButton;
	//patient and barcode info
	private static JLabel patientLog;
	private static JLabel barcodeLog;
	//patient id
	private static String ID;
	//barcode
	private static String barcode;
	
	public static void main(String[] args)
	{
		//frame
		JFrame frame = new JFrame();
		frame.setSize(4000,5000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		
		//label to ask nurse for patient id
		patientLabel = new JLabel("Enter Patient ID");
		patientLabel.setBounds(150,300,600,125);
		panel.add(patientLabel);
		
		//input area for patient id
		patientText = new JTextField();
		patientText.setBounds(140,400,100,25);
		panel.add(patientText);
		
		//label to ask nurse for barcode
		barcodeLabel = new JLabel("Enter barcode");
		barcodeLabel.setBounds(650,300,600,125);
		panel.add(barcodeLabel);
		
		//label to ask nurse for barcode
		barcodeText = new JTextField();
		barcodeText.setBounds(640,400,100,25);
		panel.add(barcodeText);
		
		//patient information from schedule class as input by doctor
		patientLog = new JLabel("");
		patientLog.setBounds(10,110,400,25);
		panel.add(patientLog);
		
		//barcode information from drug class (hardcoded and matching doctor's input)
		barcodeLog = new JLabel("");
		barcodeLog.setBounds(640,110,400,25);
		panel.add(barcodeLog);

		//patient id enter button
		pButton = new JButton("Enter");
		pButton.setBounds(140,450,100,25);
		pButton.addActionListener(new NurseGUI());
		panel.add(pButton);
		
		//barcode id enter button
		bButton = new JButton("Enter code");
		bButton.setBounds(640,450,100,25);
		bButton.addActionListener(new ActionListener() {
			//once barcode button is clicked, check barcode for the matching drug as listed from patient info, list dosage if correct
			//prompt for another check if incorrect including the severity color (sample pink)
			//entry can not be empty
		    public void actionPerformed(ActionEvent e) {
		    	barcode=barcodeText.getText();
		    	if(!ID.equals("")) //if id contains something
		    	{
		    		if (!barcode.equals("")) //if barcode contains something
			    	{
			    		if (barcode.equals("111"))
						{
							barcodeLog.setText("Administer [x mg] to patient");
						}
						else
						{
							barcodeLog.setText("Please check barcode for color severity [pink] and reenter code");
						}
			    	}
		    		else //barcode is empty
			    	{
			    		barcodeLog.setText("Please enter barcode");
			    	}
		    	}
		    	
		    	else //id is empty
		    	{
		    		patientLog.setText("Please enter ID");
		    	}
		    	
		    }
		});
		panel.add(bButton);
		
		frame.setVisible(true);
	}
	//once patient id button is clicked, check to make sure it is a valid patient and display information from schedule
	//entry can not be empty
	@Override
	public void actionPerformed(ActionEvent e) {
		ID=patientText.getText();
		if (!ID.equals(""))
		{
			if (ID.equals("1"))
			{
				patientLog.setText("Sample patient info");
			}
			else
			{
				patientLog.setText("Please check ID");
			}
		}
		else
		{
			patientLog.setText("Please enter ID");
		}
		
		
	}

}
