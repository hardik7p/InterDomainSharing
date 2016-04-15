package myPackage;

import java.awt.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Point;
import java.io.IOException;

import javax.swing.*;

public class mainClass implements ActionListener {
	static JFrame frame;
    JPanel cards; //a panel that uses CardLayout
    JPanel p;
    public static boolean succeeded = false;
    public static String myDomain;
    JTextField tfUsername;
    JLabel lbUsername;
    JLabel lbPassword;
    JPasswordField passwordField;
    JButton lButton;
    JButton rButton;
    myComboBox pb = new myComboBox();
    
 public mainClass()
 {

     frame = new JFrame("Team Zeus");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setLocationRelativeTo(null);
	//	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
     frame.pack();
     frame.setSize(400, 400);
     
     Dimension windowSize = frame.getSize();
     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
     Point centerPoint = ge.getCenterPoint();

     int dx = centerPoint.x - windowSize.width / 2;
     int dy = centerPoint.y - windowSize.height / 2;    
     frame.setLocation(dx, dy);

     frame.setVisible(true);
  }  
    private void addComponentToPane(Container pane)
    {
    	JPanel comboBoxPane = new JPanel(); //use FlowLayout
        
        pb.setOpaque(true);
        comboBoxPane.add(pb);
        
        passwordField = new JPasswordField(12);
        lbUsername = new JLabel("Username: ");
        tfUsername = new JTextField(12);
        lbPassword = new JLabel("Password: ");
        lButton = new JButton("Login");
        rButton = new JButton("Register");
        lButton.addActionListener(this);
        rButton.addActionListener(this);

        JPanel q = new JPanel(new GridBagLayout());
        		
        GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
        q.add(lbUsername,constraints);
        constraints.gridx = 1;
		constraints.gridy = 0;
        q.add(tfUsername,constraints);
        constraints.gridx = 0;
		constraints.gridy = 1;
        q.add(lbPassword,constraints);
        constraints.gridx = 1;
		constraints.gridy = 1;
        q.add(passwordField,constraints);
        constraints.anchor=GridBagConstraints.EAST;
        constraints.gridx = 0;
		constraints.gridy = 2;
        q.add(rButton,constraints);
        constraints.anchor=GridBagConstraints.NORTH;
        constraints.gridx = 1;
        constraints.gridy = 2;
        q.add(lButton,constraints);
        rButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				buttonRegisterActionPerformed(event);
			}
		});
        lButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				buttonLoginActionPerformed(event);
			}
		});
        p = new JPanel();
        p.add(q,"Hello");
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(p,BorderLayout.CENTER);	
}
	public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	  mainClass demo = new mainClass();
            	 demo.addComponentToPane(frame.getContentPane()); }
        });
	}

    public String getUsername() {
        return tfUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(passwordField.getPassword());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }
    
	public void buttonLoginActionPerformed(ActionEvent event) {
    	try {
    		
    		if(myComboBox.myId==0)
    		{
    			JOptionPane.showMessageDialog(null,"Select a domain, Jim!","Try Again",JOptionPane.ERROR_MESSAGE);
    		}
    		else if (Login.authenticate(getUsername(), getPassword(), myComboBox.myId))
			{
			    JOptionPane.showMessageDialog(null,
			            "Hi " + getUsername() + " !  You have successfully logged in.",
			            "Login",
			            JOptionPane.INFORMATION_MESSAGE);
			    succeeded = true;
			} else {
			    JOptionPane.showMessageDialog(null,
			            "Invalid username or password",
			            "Login",
			            JOptionPane.ERROR_MESSAGE);
			    tfUsername.setText("");
			    passwordField.setText("");
			    succeeded = false;
			}
		} catch (HeadlessException | IOException e) {
			e.printStackTrace();
		}
 //   	if(succeeded)
    	{
    		letsLogin l1 = new letsLogin(myComboBox.myId);
    		l1.setVisible(true);
    		frame.setVisible(false);
    	}
	}
	public void buttonRegisterActionPerformed(ActionEvent event) {
		if(myComboBox.myId!=0)
		{
			registerForm r1 = new registerForm(myComboBox.myId);
			r1.setVisible(true);
		}
		else
			JOptionPane.showMessageDialog(null,"Select a domain, Jim!","Try Again",JOptionPane.ERROR_MESSAGE);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
