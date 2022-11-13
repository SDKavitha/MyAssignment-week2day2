package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		//Enter First name
		driver.findElement(By.name("firstname")).sendKeys("kavitha");
		//Enter last name
		driver.findElement(By.name("lastname")).sendKeys("D");
		//Enter Mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("9944213148");
		//Enter Password
		driver.findElement(By.name("reg_passwd__")).sendKeys("kavikavitha@");
		
		//Select DOB
		WebElement Day = driver.findElement(By.name("birthday_day"));
		Select Drop=new Select(Day);
		Drop.selectByVisibleText("12");
		
		WebElement Month = driver.findElement(By.name("birthday_month"));
		Select Drop1=new Select(Month);
		Drop1.selectByVisibleText("Apr");
		
		WebElement Year = driver.findElement(By.name("birthday_year"));
		Select Drop3=new Select(Year);
		Drop3.selectByVisibleText("1995");
		
		//Select Gender
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		



	}

}
