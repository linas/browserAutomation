package com.google.plus.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Accept_Calls {

	private WebDriver driver;
	private WebDriverWait wait; 
//@BeforeSuite

//@BeforeTest	
	
@BeforeClass
public void setup(){
	driver = new FirefoxDriver(); 
	wait = new WebDriverWait(driver, 15);
	
}
@AfterClass
public void teardown() {
//	driver.close(); 
}
@BeforeMethod
public void checkROS(){
//initallize the ROS structure. 
}
@AfterMethod
public void deactiveDocker(){
//deinitallize the Docker	
}

@Test
public void signInloadPage()
{
	String emailId= "sophia.v1.api@gmail.com"; 
	String passwd= "v12345678";
	driver.get("https://plus.google.com");
	//Insert code for sign in Sophia. 
	
	WebElement account= driver.findElement(By.cssSelector("#Email"));
	wait.until(ExpectedConditions.elementToBeClickable(account));
	account.sendKeys(emailId);
	
	Assert.assertEquals(account.getAttribute("value"), emailId);
	System.out.println("Email Entered");
	
	account= driver.findElement(By.cssSelector("#next"));
	wait.until(ExpectedConditions.elementToBeClickable(account));
	account.click();
	
	
	account = driver.findElement(By.cssSelector("#email-display"));
	wait.until(ExpectedConditions.elementToBeClickable(account));
	Assert.assertEquals(account.getText(), emailId);
	
	
	//Now check whether the element is signed in. 
	
	account = driver.findElement(By.cssSelector("#Passwd"));
	wait.until(ExpectedConditions.elementToBeClickable(account));
	

	account.sendKeys(passwd);
	
	//Now Check the follow to this. 
	account = driver.findElement(By.cssSelector("#signIn"));
	wait.until(ExpectedConditions.elementToBeClickable(account));
	account.click();
	
	//Now clicked the button. 
	
	
	Assert.assertEquals(driver.getTitle(), "Google+");
	
}
@Test(dependsOnMethods="signInloadPage")
public void checkUserSophia()
{
	String userName= "Sophia";
	WebElement userID= driver.findElement(By.cssSelector(".gb_P.gb_R"));
	Assert.assertEquals(userID.getText(), userName);
	System.out.println("Sophia is Logged In");
}
@SuppressWarnings("unchecked")
@Test(dependsOnMethods="checkUserSophia")
public void awaitChatMessage()
{
	//Now Wait For the Elements to Continue.

	int count = 0;
	int maxTries = 1000;
	while(true) {
	    try {
	    	
	    	//Class file for the Hangouts PopUps in the system. 
	    	
	    	//Now this is a critical parameter for the system as it currently doesn't let anything that follows it to be executed 
	    	//as it doesn't pass the elements inspection.
	    	
	    	
	    	//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("//*[contains(@class,'Xv yR uq')]")));
	    	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(concat(' ',normalize-space(@class),' '),'Xv yR uq Q')]")));
	    	
	    	//This needs to be resolved. 
	    	WebElement button= driver.findElement(By.cssSelector(".Xv.yR.uq"));
	    	button.click();
	    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'Xv yR uq')]")));
	    	
	    	//WebElement element= fluentWait(By.cssSelector(":99"));
	    	
	    	//Get all the elements with the name of the specified file. 
	    	System.out.println("Wait the Elements");
	    	
	    	//List <WebElement> elements = driver.findElements(By.className(".Xv.yR.uq.Q"));
	    	
	    	//for (WebElement element : elements)
	    	//{
	    	//	System.out.println(element.getAttribute("title"));
	    	//}
	    	//Now the trick is getting the button with the title Video Call to start a video call. 
	    	
	    	//WebElement answerButton= driver.findElement(By.cssSelector(".LbWtad.cmX6We.Wxsg2c.hH1ADf.z-b-G"));
	    	
	    	//answerButton.click();
	    	
	    	System.out.println("Okay It Detects the button");
	    	break;
	    } catch(Exception e) {
	        // handle exception
	    	if(e.getClass().toString().contains("Time"))
	    	System.out.printf("Count now Reached %d \n",count);
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        if (++count == maxTries) 
	        	//throw e;
	        	{}
	    }
	}

}

public WebElement fluentWait(final By locator){
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(10, TimeUnit.SECONDS)
        .pollingEvery(1, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);

    WebElement foo = wait.until(
        new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        }
    );
    return foo;
};

}
