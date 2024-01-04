package SampleGroup.SampleArtifact;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowsAssignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.partialLinkText("Multiple")).click();
		
		driver.findElement(By.partialLinkText("Click")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
			
		String parent = it.next();
		driver.switchTo().window(it.next());
		
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		
		driver.switchTo().window(parent);
		
		System.out.println(driver.findElement(By.cssSelector("[id='content'] div h3")).getText());
		
		
	}

}
