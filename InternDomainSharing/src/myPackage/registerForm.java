package myPackage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class registerForm extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int myId;
	private JPanel contentPane;
	private static JTextField firstNameField;
	private static JTextField lastNameField;
	private static JTextField emailIdField;
	private static JTextField userNameField;
	private static JPasswordField passwordField;

	public registerForm(int myDomainId)
	{
		myId=myDomainId;
		String myDomain=domains.getDomainName(myDomainId);
		setTitle("Registration : " + myDomain);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{15, 0, 75, 28, 0, 0, 0, 15};
		gbl_contentPane.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 20, 0, 0, 5};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("First Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label = new JLabel(":");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 1;
		contentPane.add(label, gbc_label);
		
		firstNameField = new JTextField();
		firstNameField.setMinimumSize(new Dimension(6, 10));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		firstNameField.setColumns(10);
		contentPane.add(firstNameField, gbc_textField);
		
		JLabel lblLastName = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.WEST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 2;
		gbc_lblLastName.gridy = 2;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		JLabel lblNewLabel_1 = new JLabel(":");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lastNameField = new JTextField();
		lastNameField.setMinimumSize(new Dimension(6, 10));
		lastNameField.setColumns(10);
		GridBagConstraints gbc_lastNameField = new GridBagConstraints();
		gbc_lastNameField.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameField.gridx = 4;
		gbc_lastNameField.gridy = 2;
		contentPane.add(lastNameField, gbc_lastNameField);
		
		JLabel lblEmailId = new JLabel("Email Id ");
		GridBagConstraints gbc_lblEmailId = new GridBagConstraints();
		gbc_lblEmailId.anchor = GridBagConstraints.WEST;
		gbc_lblEmailId.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailId.gridx = 2;
		gbc_lblEmailId.gridy = 3;
		contentPane.add(lblEmailId, gbc_lblEmailId);
		
		JLabel lblNewLabel_2 = new JLabel(":");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		emailIdField = new JTextField();
		emailIdField.setMinimumSize(new Dimension(6, 10));
		emailIdField.setColumns(10);
		GridBagConstraints gbc_emailIdField = new GridBagConstraints();
		gbc_emailIdField.insets = new Insets(0, 0, 5, 5);
		gbc_emailIdField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailIdField.gridx = 4;
		gbc_emailIdField.gridy = 3;
		contentPane.add(emailIdField, gbc_emailIdField);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 4;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		JLabel lblNewLabel_3 = new JLabel(":");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		userNameField = new JTextField();
		userNameField.setMinimumSize(new Dimension(6, 10));
		userNameField.setColumns(10);
		GridBagConstraints gbc_userNameField = new GridBagConstraints();
		gbc_userNameField.insets = new Insets(0, 0, 5, 5);
		gbc_userNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNameField.gridx = 4;
		gbc_userNameField.gridy = 4;
		contentPane.add(userNameField, gbc_userNameField);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 5;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		JLabel label_1 = new JLabel(":");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 5;
		contentPane.add(label_1, gbc_label_1);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 5;
		contentPane.add(passwordField, gbc_passwordField);
		
		JButton rButton = new JButton("Register");
		rButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerButtonActionPerformed(arg0);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 6;
		contentPane.add(rButton, gbc_button);
		
		JButton cButton = new JButton("Clear");
		cButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clearButtonActionPerformed(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 7;
		contentPane.add(cButton, gbc_button_1);
		setVisible(true);

	}

	private void registerButtonActionPerformed(ActionEvent event)
	{
		try 
		{
			if(registerUser()==0)
			{
				setVisible(false);
			}
        }           
        catch (Exception e)
		{
        	
        }			
	}
	
	public static int registerUser() throws IOException
	{

	   	   	URL url;
		    URLConnection   urlConn;
		    DataOutputStream    printout;

		    url = new URL(domains.getRegistrationLink(myId));
		    urlConn = url.openConnection();
		    urlConn.setDoInput (true);
		    urlConn.setDoOutput (true);
		    urlConn.setUseCaches (false);
		    urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    // Send POST output.
		    printout = new DataOutputStream (urlConn.getOutputStream ());
		    String fname = firstNameField.getText();
		    String lname = lastNameField.getText();
		    String email = emailIdField.getText();
		    String username = userNameField.getText();
		    String password =  new String(passwordField.getPassword());


		    String part1="fname=" + URLEncoder.encode (fname, "UTF-8") + "&lname=" + URLEncoder.encode (lname,"UTF-8");
		    String part2="&email=" + URLEncoder.encode (email, "UTF-8") + "&username=" + URLEncoder.encode (username,"UTF-8");
		    String part3="&password=" + URLEncoder.encode (password, "UTF-8");
		    String content=part1+part2+part3;
		    
		    printout.writeBytes (content);
		    printout.flush ();
		    printout.close ();
	   	    try (InputStream is = urlConn.getInputStream())
	   	    {
		    	  BufferedReader lines = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		    	  while (true) {
		    	    String line = lines.readLine();
		    	    if (line == null)
		    	      break;
		    	    else 
		    	    {
		    	    	if(line.equals("A Confirmation Link Has Been Sent To Your Email Address. Kindly Confirm."))
		    	    	{
				 			JOptionPane.showMessageDialog(null,
				 					"A Confirmation link Has Been Sent To Your Email Address. Kindly Confirm.",
				 					"Success",JOptionPane.INFORMATION_MESSAGE);	
		    	    		return 0;
		    	    	}
		    	    	else
		    	    	{
			 			JOptionPane.showMessageDialog(null,line, "Response from Domain",JOptionPane.ERROR_MESSAGE);	
			 			return 1;
		    	    	}
		    	    }
		    	  }
		    }
	   	    catch (IOException ex)
	   	    {
	 			JOptionPane.showMessageDialog(null,"Message from Domain : " + ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
			}
			return 0;   
	 }
	private void clearButtonActionPerformed(ActionEvent event) throws IOException
	{
		firstNameField.setText("");
		lastNameField.setText("");
		emailIdField.setText("");
		userNameField.setText("");
		passwordField.setText("");
	}
}
