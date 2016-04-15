package myPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class myComboBox extends JPanel
                          implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	public static int myId=0; 
	JLabel picture;

    public myComboBox() {
        super(new BorderLayout());

        String[] petStrings = { "Team Zeus", "cloud-hp", "vinitswar", "renusurve", "spiritsons" };

        JComboBox<?> petList = new JComboBox<Object>(petStrings);
        petList.setSelectedIndex(0);
        petList.addActionListener(this);

        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
        picture.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));

        picture.setPreferredSize(new Dimension(177, 122+10));

        updateLabel("Team Zeus");
        
        add(petList, BorderLayout.PAGE_START);
        add(picture, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
    }

    public void actionPerformed(ActionEvent e) {
        JComboBox<?> cb = (JComboBox<?>)e.getSource();
        String petName = (String)cb.getSelectedItem();
        if(petName.equals("Team Zeus"))
        {
        	updateLabel(petName);
        	myId=0;   	
        }
        else if(petName.equals("cloud-hp"))
        {
            updateLabel(petName);
        	myId=1;
        }else if(petName.equals("vinitswar"))
        {
            updateLabel(petName);
        	myId=2;
        }else if(petName.equals("renusurve"))
        {
            updateLabel(petName);
        	myId=3;
        }else if(petName.equals("spiritsons"))
        {
            updateLabel(petName);
        	myId=4;
        }   
    }

    protected void updateLabel(String name) {
        ImageIcon icon = createImageIcon("images/" + name + ".png");
        picture.setIcon(icon);
        picture.setToolTipText("A drawing of a " + name.toLowerCase());
        if (icon != null) {
            picture.setText(null);
        } else {
           // picture.setText("Image not found");
        }
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = myComboBox.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private static void createAndShowGUI() {

    	JFrame frame = new JFrame("myComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new myComboBox();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
