package SampleGroup.SampleArtifact;

import java.time.Duration;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String ProdName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.saucedemo.com/");
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("chakralasri@gmail.com");
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("userPassword")).sendKeys("Abcd1234");
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login")).click();
		//driver.findElement(By.id("login-button")).click();

		//System.out.println(driver.findElement(By.xpath("//label[@class='m-2.blink_me']")).getText().trim());
		//Assert.assertEquals(driver.findElement(By.cssSelector(".m-2.blink_me")).getText().trim(), "User can only see maximum 9 products on a page");
		//driver.wait(2);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		
		
		WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(ProdName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa.fa-shopping-cart")));		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector(".fa.fa-shopping-cart")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		
		String PName = driver.findElement(By.cssSelector(".cartSection h3")).getText();
		
		Assert.assertEquals(ProdName, PName);
		
		driver.findElement(By.xpath("//li[@class='totalRow']/button[@class='btn btn-primary']")).click();
		
		//driver.findElement(By.cssSelector(".form-group input.txt.text-validated")).sendKeys("India");
		WebElement country = driver.findElement(By.cssSelector(".form-group input.txt.text-validated"));
		
		Actions a = new Actions(driver);
		a.sendKeys(country, "Ind").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-star-inserted:nth-of-type(2)")));
		a.click(driver.findElement(By.cssSelector(".ng-star-inserted:nth-of-type(2)"))).build().perform();
		
		
		
		//List<WebElement> 
		//driver.quit();

	}

}
