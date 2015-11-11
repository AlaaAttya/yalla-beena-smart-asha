import java.io.IOException;

import com.sun.lwuit.Container;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.plaf.Border;


public class display_cinema extends Form{
	
	private Label cinema_icon = new Label("");
	private Label cinema_name = new Label("");
	private Label cinema_address = new Label("");
	
	public display_cinema(cinema_item item)
	{
		super(item.get_name());
		
		Display.init(this);
		
		try {
			getStyle().setBgImage(Image.createImage("/bg_all.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		cinema_icon.setIcon(item.get_icon());
		cinema_name.setText(item.get_name());
		cinema_address.setText(item.get_address());
		
		setLayout(new BorderLayout());
		cinema_icon.getStyle().setBgTransparency(0);
		addComponent(BorderLayout.WEST , cinema_icon);
		Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		cinema_name.getStyle().setBgTransparency(0);
		cinema_address.getStyle().setBgTransparency(0);
		cnt.addComponent(cinema_name);
		cnt.addComponent(cinema_address);
		
		cnt.getStyle().setBorder(Border.createRoundBorder(14, 14));
		cnt.getStyle().setBgTransparency(190);
		cnt.getStyle().setBgColor(547214);
		
		addComponent(BorderLayout.SOUTH , cnt);
		
		
	}
}
