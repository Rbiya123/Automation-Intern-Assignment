

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

	public class SocialAccount 
	{
	    private static final int MAX_DEPTH = 2;
	    private HashSet<String> links;

	    public  SocialAccount ()
	    {
	        links = new HashSet<>();
	    }

	    public void getPageLinks(String URL, int depth)
	    {
	        if ((!links.contains(URL) && (depth < MAX_DEPTH)))
	        {
	            System.out.println(">> Depth: " + depth + " [" + URL + "]");
	            try {
	                links.add(URL);

	                Document document = Jsoup.connect(URL).get();
	                Elements linksOnPage = document.select("a[href]");

	                depth++;
	                for (Element page : linksOnPage) 
	                {
	                    getPageLinks(page.attr("abs:href"), depth);
	                }
	            } catch (IOException e) 
	            {
	                System.err.println("For '" + URL + "': " + e.getMessage());
	            }
	        }
	    }

	public static void main(String[] args)
	{
		
		 new  SocialAccount ().getPageLinks("https://www.facebook.com/r.php", 0);
		
		Proxy p=new Proxy();


		 p.setHttpProxy("localhost:8888");


		DesiredCapabilities cap=new DesiredCapabilities();



		 cap.setCapability(CapabilityType.PROXY, p);

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		
		WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname.sendKeys("abcd");

		WebElement lastname=driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("xyz");
		
		WebElement reg_email=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		reg_email.sendKeys("abcd@gmail.com");
		
		
		WebElement confirmation_email=driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		confirmation_email.sendKeys("abcd@gmail.com");
		
		
		
		
		WebElement reg_passwd=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		reg_passwd.sendKeys("abc123");
	
	
		WebElement ele=driver.findElement(By.id("day"));
		Select s = new Select(ele);
		s.selectByValue("19");
		
		
		
		
		WebElement ele1=driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select s1 = new Select(ele1);
		s1.selectByValue("10");
		
		WebElement ele2=driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select s2 = new Select(ele2);
		s2.selectByValue("1996");
		
		
		

		WebElement FemaleRadiobtn=driver.findElement(By.xpath("//label[text()='Female']"));
		FemaleRadiobtn.click();
		
		

		WebElement MaleRadiobtn=driver.findElement(By.xpath("//label[text()='Male']"));
		MaleRadiobtn.click();
		
		

		WebElement Custom=driver.findElement(By.xpath("//label[text()='Custom']"));
				Custom.click();
		
		
				
		WebElement preferred_pronoun=driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select s3 = new Select(preferred_pronoun);		
		s3.selectByVisibleText("She: \"Wish her a happy birthday!\"");
		
		

		WebElement 	custom_gender=driver.findElement(By.xpath("//input[@class='_8esa']"));
		custom_gender.sendKeys("female");
		
		
		
		WebElement 	signupbtn=driver.findElement(By.xpath("//button[@name='websubmit']"));
		signupbtn.click();
		
		driver.close();

		
	
				
				
	}

}

