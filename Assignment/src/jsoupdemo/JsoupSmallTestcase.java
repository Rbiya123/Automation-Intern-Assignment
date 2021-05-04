package jsoupdemo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupSmallTestcase {

	public static void main(String[] args) throws IOException
	{
		
		Document doc = Jsoup.connect("https://www.moneycontrol.com/india/stockpricequote/diamondjewellery/kalyanjewellersindia/KJI01").get();
		
		String title = doc.title(); //Get title
		System.out.println("  Title: " + title);
		
	    

		 Elements links = doc.select("a[href]");
	      for (Element link : links)
	      {
	     
	        System.out.println("nlink: " + link.attr("href"));
	        System.out.println("text: " + link.text());
	      }
	      
	      System.out.println("Menu Items Names");
	      Elements MenuItems=doc.select("div.navmenu_sub");
	      for (Element menu : MenuItems)
	      {
	       
	        System.out.println("text: " + menu.text());
	      }
	      
	      System.out.println("Menbar Names");
	      Elements MenuBar=doc.select("div.mega_menu");
	      for (Element menu : MenuBar)
	      {
	     
	        System.out.println("text\n: " + menu.text());
	      }
	      
	      Elements MenuBar1=doc.select("div.bottom_nav");
	      for (Element menu : MenuBar1)
	      {
	     
	        System.out.println("text\n: " + menu.text());
	      }
	      
        
			
}
	

}
