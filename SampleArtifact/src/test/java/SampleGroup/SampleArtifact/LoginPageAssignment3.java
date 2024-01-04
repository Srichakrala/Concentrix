package SampleGroup.SampleArtifact;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageAssignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[type='password'")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		
		driver.findElement(By.id("okayBtn")).click();
		
		//driver.switchTo().alert().accept();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usertype")));
		
		
		WebElement dropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select userType = new Select(dropdown);
		userType.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@name='terms']")).click();
		driver.findElement(By.cssSelector(".btn-info")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-link.btn.btn-primary")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".btn.btn-info"));
		
		for(int i=0; i<products.size(); i++)
		{
			products.get(i).click();
		}
		
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		

	}

}
