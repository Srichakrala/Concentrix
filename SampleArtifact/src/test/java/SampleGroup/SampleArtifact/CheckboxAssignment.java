package SampleGroup.SampleArtifact;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		if(!driver.findElement(By.id("checkBoxOption1")).isSelected())
		{
			driver.findElement(By.id("checkBoxOption1")).click();
		}
		else
		{
			System.out.println("Checkbox is selected");
		}
		
		int NoOfCBs = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		
		System.out.println(NoOfCBs);
		Thread.sleep(2000);
		driver.quit();
	}

}
