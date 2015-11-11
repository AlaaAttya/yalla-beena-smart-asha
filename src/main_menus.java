import java.io.IOException;
import java.util.Vector;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.midlet.MIDletStateChangeException;

import com.nokia.mid.ui.CategoryBar;
import com.nokia.mid.ui.ElementListener;
import com.nokia.mid.ui.IconCommand;
import com.sun.lwuit.Button;
import com.sun.lwuit.Calendar;
import com.sun.lwuit.Component;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.Tabs;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.FocusListener;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.DefaultListModel;
import com.sun.lwuit.list.ListCellRenderer;
import com.sun.lwuit.plaf.Style;


public class main_menus extends Form implements ElementListener{
	
	javax.microedition.lcdui.Image movies_ico;
	javax.microedition.lcdui.Image cinemas_ico;
	//IconCommand back;
	Vector views;
	public main_menus() throws IOException
	{
		Display.init(this);
		
		views = new Vector();
		views.addElement(new movies_form());
		views.addElement(new cinemas_form());
		
		movies_ico = javax.microedition.lcdui.Image.createImage("/movies_ico.png");
				//new IconCommand("Movies", javax.microedition.lcdui.Image.createImage("/movies_ico.png"), null, Command.SCREEN , 4);
		cinemas_ico = javax.microedition.lcdui.Image.createImage("/cinemas_ico.png");
		//new IconCommand("Cinemas", javax.microedition.lcdui.Image.createImage("/cinemas_ico.png"), null, Command.SCREEN , 3);
		//styling the form
		
		getStyle().setBgImage(Image.createImage("/bg_all.png"));
		
		String labels[] = {"movies" , "cinemas"};
		javax.microedition.lcdui.Image ico_arr[] = {movies_ico , cinemas_ico};
		CategoryBar cat = new CategoryBar(ico_arr , ico_arr ,labels );
		//CategoryBar cat = new 
		cat.setElementListener(this);
		cat.setVisibility(true);
		
		new movies_form().show();
		//show();
	}

	public void notifyElementSelected(CategoryBar bar, int selectedIndex) {
		// TODO Auto-generated method stub
		if(selectedIndex == ElementListener.BACK)
		{
			Display.getInstance().exitApplication();
		}
		else
		//Dialog gf = new Dialog(selectedIndex+"");
		//gf.show();
		((Form)views.elementAt(selectedIndex)).show();
	}
	
}
