import java.io.IOException;

import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.DataChangedListener;
import com.sun.lwuit.events.SelectionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.list.ListModel;


public class cinemas_form extends Form{
	public cinemas_form() throws IOException 
	{
		super("Cinemas");
		
		Display.init(this);
		try {
			getStyle().setBgImage(Image.createImage("/bg_all.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final cinema_item cinema_items[] = yallabina_services.get_all_active_cinemas(); 
		
		final List l = new List(new ListModel() {
			
			private int selection;
			
			public void setSelectedIndex(int index) {
				// TODO Auto-generated method stub
				selection = index;
			}
			
			public void removeSelectionListener(SelectionListener arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void removeItem(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void removeDataChangedListener(DataChangedListener arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public int getSize() {
				// TODO Auto-generated method stub
				return cinema_items.length;
			}
			
			public int getSelectedIndex() {
				// TODO Auto-generated method stub
				return selection;
			}
			
			public Object getItemAt(int index) {
				// TODO Auto-generated method stub
				return cinema_items[index % cinema_items.length];
			}
			
			public void addSelectionListener(SelectionListener arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void addItem(Object arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void addDataChangedListener(DataChangedListener arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		l.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new display_cinema(cinema_items[l.getSelectedIndex() % cinema_items.length]).show();
			}
		});
		
		
		Thread tr = new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				l.setListCellRenderer(new cinema_renderer());
			}
		});
		
		tr.run();
		l.setFixedSelection(List.FIXED_NONE_CYCLIC);
		this.setLayout(new BorderLayout());
		this.addComponent(BorderLayout.CENTER, l);
	}
}
