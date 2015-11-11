import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransport;

import com.sun.lwuit.Dialog;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;


public class yallabina_services {
	
	
	public static cinema_item[] get_all_active_cinemas()
	{
		
		String serviceUrl= "http://www.yallabina.com/YSAP/MoviesService.asmx";
		String namespace = "http://tempuri.org/";
		 String soapAction = "http://tempuri.org/GetAllActiveCinemas";
	     String methodName = "GetAllActiveCinemas";
	     SoapObject s_obj= new SoapObject(namespace, methodName);
	     PropertyInfo p = new PropertyInfo();
	     p.name="CityID";
	     p.type = Integer.class;
	     PropertyInfo p2 = new PropertyInfo();
	     p2.name="IsEnglish";
	     p2.type = Boolean.class;
	     
	    Integer i = new Integer(1);
	     s_obj.addProperty (p, i);
	     Boolean b = new Boolean(true);
	     s_obj.addProperty(p2, b);
	     SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	     envelope.bodyOut = s_obj;
	     envelope.dotNet = true;
	     envelope.encodingStyle = SoapSerializationEnvelope.XSD;
	     HttpTransport ht = new HttpTransport(serviceUrl);
	     ht.debug = true;
	     ht.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	     String result = null;
	     try
	     {
	     
		     ht.call(soapAction, envelope);
		     SoapObject response = (SoapObject) envelope.getResponse();     	
		     int cinemas_count = response.getPropertyCount();
		     cinema_item active_cinemas[]  = new cinema_item[cinemas_count];       
	         SoapObject obj;   	
		     for(int j=0; j<cinemas_count ; j++)
		     {
		            obj = (SoapObject)response.getProperty(j);			
		            
		            active_cinemas[j] = new cinema_item((String) obj.getProperty("VenueName").toString(),(String)obj.getProperty("Address").toString()  , loadImage("http://www.yallabina.com/Movies/UploadedFiles/"+obj.getProperty("VenueLogo").toString()));
		            //System.out.println("http://www.yallabina.com/Movies/UploadedFiles/"+(String)obj.getProperty("VenueLogo").toString());
		     }
	            
	         return active_cinemas;
	     }
	     catch(org.xmlpull.v1.XmlPullParserException ex2)
	     {
	       Alert alert = new Alert("Error",
	                        ex2.getMessage(),
	                        null, AlertType.ERROR);
	            alert.setTimeout(Alert.FOREVER);
	            //display.setCurrent(alert, f);
	     } catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	     return null;
	}
	
	public static Image loadImage(String url) throws IOException {
	    HttpConnection hpc = null;
	    DataInputStream dis = null;
	    try {
	      hpc = (HttpConnection) Connector.open(url);
	      int length = (int) hpc.getLength();
	      byte[] data = new byte[length];
	      dis = new DataInputStream(hpc.openInputStream());
	      dis.readFully(data);
	      return Image.createImage(data, 0, data.length);
	    } finally {
	      if (hpc != null)
	        hpc.close();
	      if (dis != null)
	        dis.close();
	    }
	}
	
	public static movie_item[] get_all_active_movies()
	{
		String serviceUrl= "http://www.yallabina.com/YSAP/MoviesService.asmx";
		String namespace = "http://tempuri.org/";
		 String soapAction = "http://tempuri.org/GetAllActiveMoviesInCinema";
	     String methodName = "GetAllActiveMoviesInCinema";
	     SoapObject s_obj= new SoapObject(namespace, methodName);
	     PropertyInfo p = new PropertyInfo();
	     p.name="CityID";
	     p.type = Integer.class;
	     PropertyInfo p2 = new PropertyInfo();
	     p2.name="IsEnglish";
	     p2.type = Boolean.class;
	     
	    Integer i = new Integer(1);
	     s_obj.addProperty (p, i);
	     Boolean b = new Boolean(true);
	     s_obj.addProperty(p2, b);
	     SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	     envelope.bodyOut = s_obj;
	     envelope.dotNet = true;
	     envelope.encodingStyle = SoapSerializationEnvelope.XSD;
	     HttpTransport ht = new HttpTransport(serviceUrl);
	     ht.debug = true;
	     ht.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	     String result = null;
	     try
	     {
	     
		     ht.call(soapAction, envelope);
		     
		     SoapObject response = (SoapObject) envelope.getResponse();     	
		     int cinemas_count = response.getPropertyCount();
		     movie_item active_movies[]  = new movie_item[cinemas_count];       
	         SoapObject obj;   	
		     for(int j=0; j<cinemas_count ; j++)
		     {
		            obj = (SoapObject)response.getProperty(j);			
		            
		            active_movies[j] = new movie_item(Image.createImage("/movies_ico.png"), (String) obj.getProperty("MovieName").toString(), (String) obj.getProperty("ProductionYear").toString()  , (String)obj.getProperty("GenreNames").toString() , (String)obj.getProperty("LanguageName").toString());
		            //System.out.println(obj.getProperty("ProductionYear"));
		     }
	           
		     
	         return active_movies;
	     }
	     catch(org.xmlpull.v1.XmlPullParserException ex2)
	     {
	       Alert alert = new Alert("Error",
	                        ex2.getMessage(),
	                        null, AlertType.ERROR);
	            alert.setTimeout(Alert.FOREVER);
	            //display.setCurrent(alert, f);
	     } catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	     return null;
	}

	
		
}
