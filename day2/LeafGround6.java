package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		
		//Are you enjoying the classes?
		driver.findElement(By.id("yes")).click();
		
		//Find default selected radio button
		WebElement Unchecked = driver.findElement(By.xpath("//input[@name='news']"));
		WebElement Checked = driver.findElement(By.xpath("(//input[@name='news'])[2]"));
		if(Unchecked.isSelected())
		{
			System.out.println("Unchecked selected has default");
		}
		if(Checked.isSelected())
		{
			System.out.println("Checked selected has default");
		}
		
		//Select your age group (Only if choice wasn't selected)
		WebElement agegroup = driver.findElement(By.xpath("(//input[@name='age'])[2]"));
		if(agegroup.isSelected())
		{
			System.out.println("Already selected my age group");
		}
		else
		{
			driver.findElement(By.xpath("(//input[@name='age'])[2]")).click();
		}
	}

}
