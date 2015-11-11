import com.sun.lwuit.Image;


public class cinema_item {
	private String cinema_name;
	private Image cinema_icon;
	private String cinema_address;
	
	public cinema_item(String name , String address , Image icon)
	{
		this.cinema_address = address;
		this.cinema_name = name;
		this.cinema_icon = icon;
	}
	
	public String get_name()
	{
		return this.cinema_name;
	}
	
	public String get_address()
	{
		return this.cinema_address;
	}
	
	public Image get_icon()
	{
		return this.cinema_icon;
	}
}
