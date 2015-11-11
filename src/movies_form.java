import java.io.IOException;

import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.List;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.animations.Transition3D;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.DataChangedListener;
import com.sun.lwuit.events.SelectionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.list.ListModel;


public class movies_form extends Form {
	public movies_form() throws IOException 
	{
		super("Movies");
		Display.init(this);
		try {
			getStyle().setBgImage(Image.createImage("/bg_all.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		final movie_item []items = yallabina_services.get_all_active_movies();
		this.setScrollable(false);
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
				return 3;
			}
			
			public int getSelectedIndex() {
				// TODO Auto-generated method stub
				return selection;
			}
			
			public Object getItemAt(int index) {
				// TODO Auto-generated method stub
				return items[index % items.length];
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
		
		//this.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 200));
		//this.setTransitionInAnimator(Transition3D.createRotation(250, true));
		
		l.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new display_movie(items[l.getSelectedIndex() % items.length]).show();
			}
		});
		
		Thread tr = new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				l.setListCellRenderer(new movie_renderer());
			}
		});
		
		tr.run();
		l.setFixedSelection(List.FIXED_NONE_CYCLIC);
		this.setLayout(new BorderLayout());
		this.addComponent(BorderLayout.CENTER, l);
	}
}
