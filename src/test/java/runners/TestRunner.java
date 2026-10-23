package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//runwith annotation ka use karke bol rhe hain ki is class ko cucumber ke sath run kro
@RunWith(Cucumber.class)

@CucumberOptions(


features="src/test/resources/features",

glue= {"stepsdefinations", "hooks"},


plugin= {
		
		"pretty",
		"html:target/cucumber-report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		
		
},

monochrome=true,// console output ko readable bananta hai

tags = "@regression or @smoke"
)
public class TestRunner {

}
