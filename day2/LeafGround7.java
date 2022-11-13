package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//System.out.println(driver.getTitle());
		
		//Select the languages that you know?
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		
		//Confirm Selenium is checked
		WebElement Checked = driver.findElement(By.xpath("(//input[@type='checkbox'])[6]"));
		if(Checked.isSelected())
		{
			System.out.println("Selenium is checked");
		}
		else
		{
			System.out.println("Selenium is not checked");
		}
		
		//DeSelect only checked
		/*WebElement Decheck = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
		if(Decheck.isSelected())
		{
			driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
		}
		WebElement Decheck1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
		if(Decheck1.isSelected())
		{
			driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
		}
		*/
		//Deselect check box
		List<WebElement> noselect = driver.findElements(By.xpath("//label[text()='DeSelect only checked']/following::input"));
		for(int i=0;i<noselect.size();i++)
		{
			if(noselect.get(i).isSelected())
			{
				noselect.get(i).click();
			}
			
		}
		
		//Select all below check boxes
		List<WebElement> checkall = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));
		int size=checkall.size();
		for(int i=0;i<size;i++)
		{
			checkall.get(i).click();
		}
	}

}
