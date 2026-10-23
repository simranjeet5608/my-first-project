package hooks;

import java.io.File;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@Before
	public void setup(Scenario scenario) {
		// System.out.println("==========Test Started=========");
		System.out.println("Scenario Start:" + scenario.getName()); // Scenario start hone par name print karega
		loadconfig(); // broswer open
		launchBrowser(); // Url open
	}

	// sirf smoke teste ke liye
	@Before("@smoke")

	public void beforeSmoke() {
		System.out.println("Running Smoke Test");
	}

	// sirf regression tests k liye

	@Before("@regression")

	public void beforerefression() {
		System.out.println("Running Regression Test");
	}

	@After

	// Ye har sceanrio ke baad chalega (pass ho ya fail
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) { // check karega ki scenario fail hua k nhi

			// screenshot capture save krna k file k path likha
			String folderPath = "ExtentReport/Screenshot";

			// screenshot capture kr k uska path likhege
			String imgPath = captureScreen(scenario.getName(), folderPath);
			System.out.println("Test Failed: " + scenario.getName());

			try {
				byte[] fileContent = java.nio.file.Files.readAllBytes(new File(imgPath).toPath());

				scenario.attach(fileContent, "image/png", "Failed Screenshot");
				String relativePath = "screenshots/" + new File(imgPath).getName();
				com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter
						.addTestStepScreenCaptureFromPath(relativePath);
			} catch (Exception e) {

				e.printStackTrace();
			}
			System.out.println("Test Failed: " + scenario.getName());
		} else {
			System.out.println("Test Passed:" + scenario.getName());
		}
		closeBrowser();

		System.out.println("========Test Finished========");
	}
}
