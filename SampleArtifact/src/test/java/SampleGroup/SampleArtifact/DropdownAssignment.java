package SampleGroup.SampleArtifact;

import io.github.bonigarcia.wdm.WebDriverManager;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Srinivas Chakrala");
		
		driver.findElement(By.name("email")).sendKeys("a@b.com");
		
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password");
		
		driver.findElement(By.xpath("//input[@class='form-check-input']")).click();
		
		WebElement dropDown = driver.findElement(By.cssSelector("[id='exampleFormControlSelect1']"));
		
		Select gender = new Select(dropDown);
		
		gender.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("10/10/2023");
		
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		String alert = driver.findElement(By.cssSelector(".alert-success")).getText().trim();
		System.out.println(alert);
		
		Assert.assertEquals(alert, "Success! The Form has been submitted successfully!.");

	}

}
