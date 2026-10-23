package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class LoginPage extends BaseClass {

	//Constructor, Actions
	
	public LoginPage() {
		
		initiPageFactory(this);
	}
	
	// user name
	@FindBy(id="user-name")  // User Name box se ID liya hai 
	WebElement Username;   // ek element bnaya hai
	
   // Password
	
	@FindBy(id="password")
	WebElement password1;
	
	//Login button per click
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	@FindBy(xpath="//h3[contains(text(),'Epic sadface: Username and password do not match')]")
	WebElement errormessage;
	
	//Actions
	//Methof for Username Type
	
	public void enterUserName(String user) {
		
		Username.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		
		password1.sendKeys(pass);
	}
	
	public void clickOnloginbtn() {
		
		loginbutton.click();
	}
	
	public boolean  isErroMessageDisplayed(){
		return errormessage.isDisplayed();
		
		
	}
	
}
