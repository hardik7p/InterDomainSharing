package myPackage;

public class domains{
	
	public static String getURL(int domainId)
	{
		switch(domainId)
		{
		case 1 : 
			return("http://www.cloud-hp.com/curl_swing.php");
		case 2 :
			return("http://www.vinitswar.com/curl_swing.php");
		case 3 :
			return("http://www.renusurve.com/curl_swing.php");
		case 4 :
			return("http://www.spiritsons.com/curl_swing.php");
		default :
			return "junk";
		}
	}
	public static String getLoginLink(int domainId)
	{
		switch(domainId)
		{
		case 1 : 
			return("http://www.cloud-hp.com/letMeLogin.php");
		case 2 :
			return("http://www.vinitswar.com/letMeLogin.php");
		case 3 :
			return("http://www.renusurve.com/letMeLogin.php");
		case 4 :
			return("http://www.spiritsons.com/letMeLogin.php");
		default :
			return "junk";
		}
	}
	public static String getGalleryLink(int domainId)
	{
		switch(domainId)
		{
		case 1 : 
			return("http://www.cloud-hp.com/combine.php");
		case 2 :
			return("http://www.vinitswar.com/combine.php");
		case 3 :
			return("http://www.renusurve.com/combine.php");
		case 4 :
			return("http://www.spiritsons.com/combine.php");
		default :
			return "junk";
		}
	}
	public static String getDomainName(int domainId)
	{
		switch(domainId)
		{
		case 1 : 
			return("www.cloud-hp.com");
		case 2 :
			return("www.vinitswar.com");
		case 3 :
			return("www.renusurve.com");
		case 4 :
			return("www.spiritsons.com");
		default :
			return "junk";
		}
	}
	public static String getRegistrationLink(int domainId)
	{
		switch(domainId)
		{
		case 1 : 
			return("http://www.cloud-hp.com/signup_ac.php");
		case 2 :
			return("http://www.vinitswar.com/signup_ac.php");
		case 3 :
			return("http://www.renusurve.com/signup_ac.php");
		case 4 :
			return("http://www.spiritsons.com/signup_ac.php");
		default :
			return "junk";
		}
	}
}
