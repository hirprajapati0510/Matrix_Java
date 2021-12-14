package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class crossbrowser 
{

    public WebDriver driver;

	
	@Parameters("browsername")
    @BeforeTest
  
	public void  setup(String browsername) 
	{
	 System.out.println("Browser Name is :" + browsername );
	  if (browsername.equalsIgnoreCase("chrome")) 
	  {
		   
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		  driver = new ChromeDriver();
	  } 
	 
	 else if (browsername.equalsIgnoreCase("firefox")) 
	  {
		  System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  
	  } 
      else if (browsername.equalsIgnoreCase("edge")) 
      {
		  	
		  System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
		  driver = new EdgeDriver();
	  }	 

	}
    @Test
	public void  test() throws InterruptedException
	{

	  driver.get("https://matrix-stage.liveu.tv");	
	  driver.manage().window().maximize();	
	   Thread.sleep(4000);
	   
	   WebElement username = driver.findElement(By.xpath("//*[@id=\'txtUsername\']"));
	    username.sendKeys("Curator01");
	  //username.sendKeys("Affiliate01");
	  //username.sendKeys("MGcurator01");
	    Thread.sleep(2000);
	    
	    WebElement password = driver.findElement(By.xpath("//*[@id=\'txtPassword\']"));
	    password.sendKeys("LiveU123!");	    
	    Thread.sleep(3000);
	    
	    WebElement Login = driver.findElement(By.xpath("//*[@id=\'btnLogin\']"));
	    Login.click();
	    
	    Thread.sleep(55000);
	    
	    WebElement setting;
	    setting = driver.findElement(By.xpath("//*[@id=\'wrapper\']/header/div[1]/div[2]/div/div[3]/div[2]/div[3]"));
	    setting.click();              
	    Thread.sleep(1000);

	    
	    WebElement whatsnew;
	    whatsnew = driver.findElement(By.xpath("//*[@id=\'wrapper\']/header/div[1]/div[2]/div/div[3]/div[2]/div[3]/ul/li[9]"));
	    whatsnew.click();
	    Thread.sleep(1000);

	    WebElement whatsnewcancel;
	    whatsnewcancel = driver.findElement(By.xpath("//*[@id=\'openWhatsNew\']/div/div/div[1]/a"));
	    whatsnewcancel.click();
	    Thread.sleep(1000);                    
	                                       
	    WebElement chat;
	    chat = driver.findElement(By.className("chat_svg"));
	    chat.click();
	    Thread.sleep(10000);

	    WebElement chatbox;
	    chatbox = driver.findElement(By.id("textchat"));
	    chatbox.sendKeys("chat test");
	    Thread.sleep(8000);

	    WebElement chatsend;
	    chatsend = driver.findElement(By.className("svg_send"));
	    chatsend.click();
	    Thread.sleep(8000);
	    chat.click();
	    Thread.sleep(2000);
	    
	    setting.click();
	    Thread.sleep(2000);

	    WebElement logout;
	    logout = driver.findElement(By.xpath("//*[@id=\'wrapper\']/header/div[1]/div[2]/div/div[3]/div[2]/div[3]/ul/li[10]/a"));
	    logout.click();  
	    Thread.sleep(4000);
      
	 
	}
    @AfterTest
    public void afterTest()
    {
        driver.close();
        System.out.println("Test Completed Successfully");
        
    }
	
	
}
