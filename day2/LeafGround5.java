package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		
		//Using index
		WebElement drop1 = driver.findElement(By.id("dropdown1"));
		Select index=new Select(drop1);
		index.selectByIndex(2);
		
		//Using text
		WebElement drop2 = driver.findElement(By.xpath("(//div[@class='example']/select)[2]"));
		Select text=new Select(drop2);
		text.selectByVisibleText("Loadrunner");
		
		//Using value
		WebElement drop3 = driver.findElement(By.id("dropdown3"));
		Select value=new Select(drop3);
		value.selectByValue("3");
		
		//Number of drop down
		
       //Print each element in the drop down box
       Select options =new Select( driver.findElement(By.className("dropdown")));
       List<WebElement> options2 = options.getOptions();
       int size=options2.size();
       System.out.println("Size:"+size);
       for(int i=0;i<size;i++) {
    	   String text2 = options2.get(i).getText();
    	   System.out.println(text2);
       }
		
       //use send keys to select
		driver.findElement(By.xpath("(//div[@class='example']/select)[5]")).sendKeys("Loadrunner");
		
		//Select program
		driver.findElement(By.xpath("(//div[@class='example']/select)[6]")).click();
		
	}

}
