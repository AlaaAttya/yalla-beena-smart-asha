import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.ListCellRenderer;
import com.sun.lwuit.plaf.Border;


public class movie_renderer extends Container implements ListCellRenderer {
	
	private Label icon = new Label("");
	private Label name = new Label("");
	private Label production_year = new Label("");
	private Label genres = new Label("");
	private Label language = new Label("");
	
	public movie_renderer()
	{
		 setLayout(new BorderLayout());
	     icon.getStyle().setBgTransparency(0);
		 addComponent(BorderLayout.WEST, icon);
	     Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
	     name.getStyle().setBgTransparency(0);
	     production_year.getStyle().setBgTransparency(0);
	     genres.getStyle().setBgTransparency(0);
	     language.getStyle().setBgTransparency(0);
	     cnt.addComponent(name);
	     cnt.addComponent(production_year);
	     cnt.addComponent(language);
	     cnt.addComponent(genres);
	     addComponent(BorderLayout.CENTER , cnt);
	     
	     this.getStyle().setBorder(Border.createRoundBorder(14, 14));
	     this.getStyle().setBgTransparency(190);
		 this.getStyle().setBgColor(547214);
	}
	
	public Component getListCellRendererComponent(List list, Object value,
			int index, boolean isSelected) {
		// TODO Auto-generated method stub
		movie_item movie = (movie_item)value;
		name.setText(movie.get_movie_name().toString());
		icon.setIcon(movie.get_movie_pic());
		production_year.setText("Production Year: "+movie.get_prod_year());
		genres.setText("Genres: "+movie.get_genres().toString());//must have way to handle it
		language.setText("Language: "+movie.get_lang().toString());
		
		return this;
	}

	public Component getListFocusComponent(List arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
