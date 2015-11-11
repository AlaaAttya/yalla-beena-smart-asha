import com.sun.lwuit.Image;

/* Movie class
 * 
 * */
public class movie_item {
	private Image movie_pic;
	private String movie_name;
	private String production_year;
	private String genres;
	private String lang;
	
	public movie_item(Image m_pic , String m_name , String pro_year , String gen , String lan)
	{
		this.movie_pic = m_pic;
		this.movie_name = m_name;
		this.production_year = pro_year;
		this.genres = gen;
		this.lang = lan;
	}
	
	public Image get_movie_pic()
	{
		return this.movie_pic;
	}
	
	public String get_movie_name()
	{
		return this.movie_name;
	}
	
	public String get_prod_year()
	{
		return this.production_year;
	}
	
	public String get_genres()
	{
		return this.genres;
	}
	
	public String get_lang()
	{
		return this.lang;
	}
}
