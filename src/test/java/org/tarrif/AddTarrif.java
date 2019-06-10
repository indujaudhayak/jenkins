package org.tarrif;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddTarrif {
	static WebDriver driver;
	@Given("the user navigates to the url")
	public void the_user_navigates_to_the_url() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\USER\\eclipse-workspace\\TelecomJenkins\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/");
	}

	@Given("the user click on AddTarrifPlan")
	public void the_user_click_on_AddTarrifPlan() {
		
	    driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	}

	@When("the user fill in the details")
	public void the_user_fill_in_the_details(DataTable customerTarrif) {
		
		List<String> customerTarrifplan = customerTarrif.asList(String.class);
		
		driver.findElement(By.id("rental1")).sendKeys(customerTarrifplan.get(0));
		driver.findElement(By.id("local_minutes")).sendKeys(customerTarrifplan.get(1));
		driver.findElement(By.id("inter_minutes")).sendKeys(customerTarrifplan.get(2));
		driver.findElement(By.id("sms_pack")).sendKeys(customerTarrifplan.get(3));
		driver.findElement(By.id("minutes_charges")).sendKeys(customerTarrifplan.get(4));
		driver.findElement(By.id("inter_charges")).sendKeys(customerTarrifplan.get(5));
		driver.findElement(By.id("sms_charges")).sendKeys(customerTarrifplan.get(6));
		
	}

	@Then("the user click on submit button")
	public void the_user_click_on_submit_button() {
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	
	}



}
