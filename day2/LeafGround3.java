package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		//Go to Home Page
		driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();
		//verify home page
		String title = driver.getTitle();
		String title1="TestLeaf - Selenium Playground";
		if(title.equals(title1))
		{
			System.out.println("Navigate to home page");
		}
		else
		{
			System.out.println("Doesnt Navigate to home page");
		}
		driver.navigate().back();
		//Find where am supposed to go without clicking me?
		String attr = driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']")).getAttribute("href");
		System.out.println(attr);
		
		
		//Verify am I broken?
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		String title2 = driver.getTitle();
		String title3="404 Not Found";
		if(title2.equals(title3))
		{
			System.out.println("Link is broken");
		}
		else
		{
			System.out.println("Link is not broken");
		}
		driver.navigate().back();
		
		//Go to Home Page (Interact with same link name)
		String homepage1 = driver.findElement(By.xpath("//a[text()='Go to Home Page']")).getAttribute("href");
		String homepage2 = driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).getAttribute("href");
	   if(homepage1.equals(homepage2))
	   {
		   driver.navigate().to(homepage1);
		   System.out.println("same link and navigate using first link");
	   }
	   else
	   {
		   System.out.println("not same link"); 
	   }
	   

	   //How many links are available in this page?
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    int size=links.size();
	   System.out.println("Link size:"+size);
	   
       
	}

}
