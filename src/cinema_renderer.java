import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.ListCellRenderer;
import com.sun.lwuit.plaf.Border;


public class cinema_renderer extends Container implements ListCellRenderer{

	private Label cinema_icon = new Label("");
	private Label cinema_name = new Label("");
	private Label cinema_address = new Label("");
	
	public cinema_renderer()
	{
		setLayout(new BorderLayout());
		cinema_icon.getStyle().setBgTransparency(0);
		addComponent(BorderLayout.WEST , cinema_icon);
		Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		cinema_name.getStyle().setBgTransparency(0);
		cinema_address.getStyle().setBgTransparency(0);
		cnt.addComponent(cinema_name);
		cnt.addComponent(cinema_address);
		addComponent(BorderLayout.CENTER , cnt);
		
		this.getStyle().setBorder(Border.createRoundBorder(14, 14));
		this.getStyle().setBgTransparency(190);
		this.getStyle().setBgColor(547214);
	}
	
	public Component getListCellRendererComponent(List list, Object value,
			int index, boolean isSelected) {
		// TODO Auto-generated method stub
		cinema_item cinema = (cinema_item) value;
		cinema_icon.setIcon(cinema.get_icon());
		cinema_address.setText("Address: "+cinema.get_address());
		cinema_name.setText(cinema.get_name());
		
		return this;
	}

	public Component getListFocusComponent(List arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
