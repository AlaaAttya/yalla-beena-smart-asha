import java.io.IOException;

import com.sun.lwuit.Container;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.plaf.Border;


public class display_movie extends Form{
	
	private Label icon = new Label("");
	private Label name = new Label("");
	private Label production_year = new Label("");
	private Label genres = new Label("");
	private Label language = new Label("");
	
	public display_movie(movie_item item) {
		// TODO Auto-generated constructor stub
		super(item.get_movie_name());
		Display.init(this);
		
		try {
			getStyle().setBgImage(Image.createImage("/bg_all.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		icon.setIcon(item.get_movie_pic());
	    name.setText(item.get_movie_name());
		production_year.setText("Year: "+item.get_prod_year());
		genres.setText("Genres: "+item.get_genres());
		language.setText("Language: "+item.get_lang());
	    
		setLayout(new BorderLayout());
	    icon.getStyle().setBgTransparency(0);
		addComponent(BorderLayout.WEST, icon);
	    Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
	    name.getStyle().setBgTransparency(0);
	    production_year.getStyle().setBgTransparency(0);
	    genres.getStyle().setBgTransparency(0);
	    language.getStyle().setBgTransparency(0);
	     
	    cnt.getStyle().setBorder(Border.createRoundBorder(14, 14)); 
	    cnt.getStyle().setBgTransparency(190); 
	    cnt.getStyle().setBgColor(547214);
	    
	    cnt.addComponent(name);
	    cnt.addComponent(production_year);
	    cnt.addComponent(language);
	    cnt.addComponent(genres);
	    addComponent(BorderLayout.SOUTH , cnt);
	     
	     //this.getStyle().setBorder(Border.createRoundBorder(14, 14));
	     //this.getStyle().setBgTransparency(190);
		 //this.getStyle().setBgColor(547214);
	}
}
