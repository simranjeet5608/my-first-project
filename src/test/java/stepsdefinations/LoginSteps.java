package stepsdefinations;

import org.junit.Assert;
import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps extends BaseClass{
	
	LoginPage loginPageObj = new LoginPage();
	
	@Given ("user is on Login Page")
	public void user_is_on_Login_Page() {
		
	}
	
	@When ("user enters valid username aur passowrd")
	
	public void user_enters_valid_username_aur_passowrd() {
		
		loginPageObj.enterUserName(prop.getProperty("username"));
		loginPageObj.enterPassword(prop.getProperty("password"));
		loginPageObj.clickOnloginbtn();
		
		System.out.println("Enter Valid Credentials");
	}
	
	@Then("user should be logged in successfuly")
	public void user_should_be_logged_in_successfuly() {
		
		String logoText =driver.findElement(By.xpath("//div[@class=\"app_logo\"]")).getText();
		System.out.println("The name of text logo is : " + logoText);
		boolean logo= driver.findElement(By.xpath("//div[@class=\"app_logo\"]")).isDisplayed();
		Assert.assertTrue("login failed -Logo is not visible", logo);
		System.out.println("User Login Successfully");
	}
	
	@When("user enters invalid username aur passowrd")
	public void user_enters_invalid_username_aur_passowrd() {
		loginPageObj.enterUserName(prop.getProperty("username1"));
		loginPageObj.enterPassword(prop.getProperty("password2"));
		loginPageObj.clickOnloginbtn();
		
		System.out.println("Enter Invalid Credentials");
	
	}

	@Then("error  message should be displayed")
	public void error_message_should_be_displayed() {
	    
		boolean isErrorDisplayed = loginPageObj.isErroMessageDisplayed();{
			
			Assert.assertTrue("Error message not displayed", isErrorDisplayed);
			
			System.out.println("Error message displayed successfully");
		}
	}

}
