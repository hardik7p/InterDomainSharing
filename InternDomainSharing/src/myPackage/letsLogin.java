package myPackage;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class letsLogin extends JFrame implements PropertyChangeListener
{
	public static String galleryLink;
	private static final long serialVersionUID = 1L;

	private JLabel labelURL = new JLabel("Upload URL: ");
	private JTextField fieldURL = new JTextField(30);
	private JFilePicker filePicker = new JFilePicker("Choose a File:      ", "Browse");
	private JButton buttonUpload = new JButton("Upload");
	private JLabel labelProgress = new JLabel("Progress:");
	private JProgressBar progressBar = new JProgressBar(0, 100);
	private JEditorPane jep = new JEditorPane();
	private JScrollPane scrollPane = new JScrollPane(jep);     
	private JButton buttonGallery = new JButton("View Your Galley Online");
	private JButton buttonRefresh = new JButton("Refresh");
	private JButton buttonDomain2 = new JButton("VinitSwar");
	private JButton buttonDomain3 = new JButton("RenuSurve");
	private JButton buttonDomain4 = new JButton("SpiritSons");

	public letsLogin(int domainId)
	{
		super("Team Zeus");
		fieldURL.setText(domains.getURL(domainId));
		galleryLink=domains.getGalleryLink(domainId);
		// set up layout
	    setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 15, 15);

		fieldURL.setEnabled(false);

		// set up components
		filePicker.setMode(JFilePicker.MODE_OPEN);

		progressBar.setPreferredSize(new Dimension(200, 30));
		progressBar.setStringPainted(true);

		// add components to the frame
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(labelURL, constraints);

		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1.0;
		add(fieldURL, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 0.0;
		constraints.gridwidth = 2;
		constraints.fill = GridBagConstraints.NONE;
		add(filePicker, constraints);

		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		add(buttonUpload, constraints);
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.EAST;
		add(buttonRefresh,constraints);
	
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.WEST;
		add(labelProgress, constraints);

		constraints.gridx = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		add(progressBar, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.weightx = 0.01;
		constraints.weighty = 0.01;
		add(buttonDomain2,constraints);
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 0.01;
		constraints.weighty = 0.01;
		add(buttonDomain3,constraints);constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.SOUTH;
		constraints.weightx = 0.01;
		constraints.weighty = 0.01;
		add(buttonDomain4,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.CENTER;
	    scrollPane.setPreferredSize(new Dimension(200,450));

		add(scrollPane,constraints);
		jep.setEditable(false);
   
		constraints.gridy = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		add(buttonGallery, constraints);
		
		setVisible(true);

    	//	pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Action Listners
		buttonUpload.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				buttonUploadActionPerformed(event);
			}
		});
		
		buttonGallery.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				buttonGalleryActionPerformed(event);
			}
		});
		buttonRefresh.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				try {
					buttonRefreshActionPerformed(event);
				} catch (IOException e) {
					try {
						//Change Here
						jep.setPage(domains.getGalleryLink(domainId));
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
					e.printStackTrace();
				}
			}
		});
		
		buttonDomain2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				try {
					jep.setPage(domains.getGalleryLink(2));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		buttonDomain3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				try {
					jep.setPage(domains.getGalleryLink(3));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		buttonDomain4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				try {
				jep.setPage(domains.getGalleryLink(4));
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		});
	}

	private void buttonUploadActionPerformed(ActionEvent event)
	{
		String uploadURL = fieldURL.getText();
		String filePath = filePicker.getSelectedFilePath();

		if (uploadURL.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Enter URL, Jim!","Error", JOptionPane.ERROR_MESSAGE);
			fieldURL.requestFocus();
			return;
		}

		if (filePath.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Hey, choose a file to upload!","Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try
		{
			File uploadFile = new File(filePath);
			progressBar.setValue(0);
			UploadTask task = new UploadTask(uploadURL, uploadFile);
			task.addPropertyChangeListener(this);
			task.execute();
     		jep.setPage(galleryLink);
     		
		} 
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(this,"Error in Uploading : " + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void buttonGalleryActionPerformed(ActionEvent event)
	{
		try 
        {
            Desktop.getDesktop().browse(new URL(galleryLink).toURI());
        }           
        catch (Exception e) {}			
	}
	private void buttonRefreshActionPerformed(ActionEvent event) throws IOException
	{
	
		jep.setPage(galleryLink);	
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		if ("progress" == evt.getPropertyName())
		{
			int progress = (Integer) evt.getNewValue();
			progressBar.setValue(progress);
		}
	}
}
