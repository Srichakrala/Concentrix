package SampleGroup.SampleArtifact;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeExAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();

		//By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		String optTxt = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText().trim();
		System.out.println(optTxt);
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		
		Select sel = new Select(dropDown);
		sel.selectByVisibleText(optTxt);
		
		driver.findElement(By.id("name")).sendKeys(optTxt);
		driver.findElement(By.id("alertbtn")).click();
		
		String altTxt = driver.switchTo().alert().getText();
		
		System.out.println(altTxt);
		
		if(altTxt.contains(optTxt))
		{
			System.out.println(optTxt + " text is present in the Alert text");
		}
		else
		{
			System.out.println(optTxt + " text is not present in the Alert text");			
		}
		
		driver.switchTo().alert().accept();
		
	}

}
