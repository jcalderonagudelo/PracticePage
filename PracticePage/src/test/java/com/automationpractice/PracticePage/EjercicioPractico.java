package com.automationpractice.PracticePage;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjercicioPractico {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/java/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/");
	}
	
	@Test
	public void testAutomationPage() {
		
		WebElement searchbox = driver.findElement(By.className("login"));
		searchbox.click();
		// searchbox.submit();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement already_existing = driver.findElement(By.xpath("//*[@id=\"login_form\"]/h3"));

		System.out.println(already_existing.getText());

		if (already_existing.getText().equals("ALREADY REGISTERED?")) {
			System.out.println("ES VÁLIDO");
		} else {
			System.out.println("NO ES VÁLIDO");
		}

		WebElement user = driver.findElement(By.xpath("//*[@id=\"email\"]"));

		user.clear();
		user.sendKeys("tcttltklikdjvyrfns@wqcefp.com");

		WebElement pass = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		pass.clear();
		pass.sendKeys("123456789");

		WebElement enter_account = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		enter_account.click();

		WebElement user_name = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));

		System.out.println(user_name.getText());

		if (user_name.getText().equals("Pedro Pascual")) {
			System.out.println("ES VÁLIDO");
		} else {
			System.out.println("NO ES VÁLIDO");
		}

		WebElement out_account = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
		out_account.click();

		System.out.println("Prueba terminada");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
}
