package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		//Click on this image to go home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.navigate().back();
		//Am I Broken Image?
		WebElement image = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"));
        if(image.getAttribute("src")!="0")
        {
        	System.out.println("Image is broken");
        }
        else
        {
        	System.out.println("Image is not broken");
        }
        
        //Click me using Keyboard or Mouse
        WebElement keyboard = driver.findElement(By.xpath("//img[@src='../images/keyboard.png']"));
        Actions obj=new Actions(driver);
        obj.click(keyboard).perform();
        String title = driver.getTitle();
        System.out.println(title);
	}

}
