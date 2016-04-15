package myPackage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.swing.JOptionPane;

public class Login {
	 
    public static boolean authenticate(String username, String password, int myId) throws IOException
    {

   	   	URL url;
	    URLConnection   urlConn;
	    DataOutputStream    printout;
	    url = new URL (domains.getLoginLink(myId));
	 // url = new URL ("http://www.cloud-hp.com/letMeLogin.php");
	    urlConn = url.openConnection();
	    urlConn.setDoInput (true);
	    urlConn.setDoOutput (true);
	    urlConn.setUseCaches (false);
	    urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

	    printout = new DataOutputStream (urlConn.getOutputStream ());
	    String content ="username=" + URLEncoder.encode (username, "UTF-8") + "&password=" + URLEncoder.encode (password,"UTF-8");
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
	    	    else if(line.equals("OK"))
	    	    {
	    	    	return true;
	    	    }
	    	  }
	    }
   	    catch (IOException ex) {
 			JOptionPane.showMessageDialog(null,"Errror : " + ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
		}
		return false;   
    }
    
}