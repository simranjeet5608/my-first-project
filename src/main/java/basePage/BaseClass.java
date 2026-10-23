package basePage;



import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;



public class BaseClass {

	public static WebDriver driver;
	//public static String Base_Url = "https://www.saucedemo.com/ ";
	
	// Properties obejct jo config.properties file read karega
	
	public static Properties prop;
	
	
	//yeh method config.properties file load/read karega
	
	public void loadconfig() {
		
		try {
			
			prop = new Properties();
			
			FileInputStream fis = new FileInputStream("src/main/resources/config/config.properties");
			
			prop.load(fis);
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	public void launchBrowser() {
		
		//config.properties se browser le rhe hai
		
		String browserName = prop.getProperty("browser");
		
		//Yaha hum check karenge Browser konsa hai or kaunsa use krna h
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			
			driver = new ChromeDriver();
			
			// agra browser firefox hai
			
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
		
	
	driver = new FirefoxDriver();
	
	} else {
		
		System.out.println("Browser not supported");
	}
		
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	
	}
	
//	public void openUrl() {
//		
//		driver.get(Base_Url);
//	}
//	
	public void initiPageFactory(Object page) {
		PageFactory.initElements(driver, page);
		
	}
	
	public String captureScreen(String testName, String folderPath) {
		
		try {
			
			// step 1: Current browser ka screenshot capture karo
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			//Step 2; Screenshot ka final path capture kro
			// folder path = kaha save karna hai
			// testName = file ka naam (eg LoginTest.png)
			
			String path = folderPath + "/" + testName + ".png";
			
			// step 3; Destination file object create karo
			File dest = new File(path);
			
			// step 4; Agar folder exist nahi karta to create krdo
			
			dest.getParentFile().mkdirs();
			
			// step5; Screenshot ko sourse se destination pe copy karo
			
			Files.copy(src.toPath(), dest.toPath());
			// step 6: Return karo path use hoga report me attach karne ke liye)
			return path;
					
		}
		  catch (Exception e) {
			  // Agar koi error aaye toh concole me print karo
			  e.printStackTrace();
			  return null;
		
		}
		
	}
		
		
	public void closeBrowser() {
		
		if(driver !=null) {
			driver.quit();
		}
	}
}
