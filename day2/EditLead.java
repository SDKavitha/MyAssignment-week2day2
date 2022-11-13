package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Enter UserName
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//Enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click login
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		//Click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		//click Leads
		driver.findElement(By.linkText("Leads")).click();
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		//Click find lead
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("a");
		//click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
	//click first resulting lead
		//WebElement user = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']"));
		//driver.executeScript("argument[0].click()", user);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
	    String title3="View Lead | opentaps CRM";
		String title4 = driver.getTitle();
		System.out.println(title4);
		
		if(title4.equalsIgnoreCase(title3))
		{
			System.out.println("Title matched");
		}
		else
		{
			System.out.println("Title not matched");
		}
		//click edit
		driver.findElement(By.xpath("(//a[@class='subMenuButton'])[3]")).click();
		//change company name
		WebElement change = driver.findElement(By.id("updateLeadForm_companyName"));
		change.clear();
		change.sendKeys("cts");
		//click update
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
        boolean displayed = driver.findElement(By.id("viewLead_companyName_sp")).isDisplayed();
        	System.out.println(displayed);
        	
        	driver.close();
        
	}

}
