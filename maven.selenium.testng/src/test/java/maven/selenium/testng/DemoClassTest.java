package maven.selenium.testng;


import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;



public class DemoClassTest {


	public static void main(String[] args) throws Throwable {
		 
//	Navigating to the URL 
			
		WebDriverManager.chromedriver().setup();	
		
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("http://Securepay.com.au");
	    
//  Finding the WebElements
	    
	    Actions builder = new Actions(driver); 
	    
	    builder.moveToElement(driver.findElement(By.id("menu-item-3367"))).build().perform();
	    
	    WebElement ContactUs = driver.findElement(By.id("menu-item-179"));
	    ContactUs.click();
	    Thread.sleep(3000);
	    
	    WebElement FirstNameTextbox = driver.findElement(By.name("first-name"));
	    
	    WebElement LastNameTextbox = driver.findElement(By.name("last-name"));
	    
	    WebElement EmailTextbox = driver.findElement(By.xpath("//*[@id=\"wpcf7-f3455-p95-o1\"]/form/p[3]/label/span/input"));
	    
	    WebElement PhoneTextbox = driver.findElement(By.xpath("//*[@id=\"wpcf7-f3455-p95-o1\"]/form/p[4]/label/span/input"));
	    
        WebElement WebsiteURLTextbox = driver.findElement(By.xpath("//*[@id=\"wpcf7-f3455-p95-o1\"]/form/p[5]/label/span/input"));
        
        WebElement CompanyTextbox = driver.findElement(By.xpath("//*[@id=\"wpcf7-f3455-p95-o1\"]/form/p[6]/label/span/input"));
        
        WebElement MessageTextbox = driver.findElement(By.xpath("//*[@id=\"wpcf7-f3455-p95-o1\"]/form/p[8]/label/span/textarea"));
        
        WebElement ReasonForEnqdropdown = driver.findElement(By.xpath("//*[@id=\"wpcf7-f3455-p95-o1\"]/form/p[7]/label/span/select"));     
        
	    Thread.sleep(3000);
	    
//   Generate random data using FAKER API
	   
		Locale locale = new Locale("en-AU");
		Faker faker = new Faker(locale);
		
		String email = faker.internet().emailAddress();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String phoneNumber = faker.phoneNumber().phoneNumber();
		String website = faker.internet().url();
		String companyName = faker.company().name();
		
		EmailTextbox.sendKeys(email);
		FirstNameTextbox.sendKeys(firstName);
		LastNameTextbox.sendKeys(lastName);
		PhoneTextbox.sendKeys(phoneNumber);
		WebsiteURLTextbox.sendKeys(website);
		CompanyTextbox.sendKeys(companyName);
		ReasonForEnqdropdown.click();
		
//	Select 'Support' Reason from the drop down window   
		
        Select Reason = new Select(ReasonForEnqdropdown);
        Reason.selectByVisibleText("Support");
        
//  Populate Message box with the text        
        
		MessageTextbox.sendKeys("Please contact me via my e-mail or phone. Thank you");
		
	    Thread.sleep(5000);
	   
	    driver.manage().window().maximize();
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	     
	    
	    js.executeScript("window.scrollBy(0,4000)");
	   
	    driver.quit();
	}

}

