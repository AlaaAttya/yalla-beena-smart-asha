import java.io.IOException;

import javax.microedition.m3g.Background;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import com.sun.lwuit.Button;
import com.sun.lwuit.Container;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.Display;





public class main extends MIDlet {

	public main() throws IOException {
		// TODO Auto-generated constructor stub
		com.sun.lwuit.Display.init(this);
		final Form main_form = new Form("Yallabina");
		main_form.getStyle().setBgImage(Image.createImage("/main_bg.png"));
		//main_form.getStyle().setBackgroundType(BACKGROUND_ALIGNMENT);
		
		Container cont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Button enlish = new Button("English");
		Button arabic = new Button("ÚÑÈí");
		cont.addComponent(enlish);
		cont.addComponent(arabic);
		main_form.setLayout(new BorderLayout());
		Container co = new Container();
		
		
		//main_form.addComponent(enlish);
		//main_form.addComponent(arabic);
		main_form.addComponent(BorderLayout.SOUTH , cont);
		
		enlish.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					
					main_menus m = new main_menus();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		main_form.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 200));
		main_form.show();
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

}
