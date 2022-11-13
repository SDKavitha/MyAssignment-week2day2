package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		//check if navigate to home page
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String title1="TestLeaf - Selenium Playground";
		//System.out.println(driver.getCurrentUrl());
		if(title.equals(title1))
		{
			System.out.println("Navigate to home page");
		}
		else
		{
			System.out.println("Doesn't Navigate to home page");
		}
		driver.findElement(By.xpath("//h5[text()='Button']")).click();
		//get position
		Point loc= driver.findElement(By.xpath("//button[@id='position']")).getLocation();
		int x=loc.getX();
		System.out.println("X"+x);
		int y=loc.getY();
		System.out.println("Y"+y);
		//find color
		String cssValue = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("cssValue:"+cssValue);
		
		//find length
		Dimension size = driver.findElement(By.id("size")).getSize();
		int height=size.height;
		System.out.println("Height:"+height);
		
		int width=size.width;
		System.out.println("Width:"+width);
	}

}
