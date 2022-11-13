package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class LeafGround1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Enter Email Address
		driver.findElement(By.id("email")).sendKeys("Kavi@gmail.com");
		//Append
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Hello");
		//Get text
		String text2 = driver.findElement(By.xpath("(//input[@name='username'])[1]")).getAttribute("value");
		System.out.println(text2);
		//clear text
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		//check is enabled
		System.out.println(driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled());
		
		
		
	}

}
