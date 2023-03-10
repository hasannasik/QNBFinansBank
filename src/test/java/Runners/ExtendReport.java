package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (

                features = {"src/test/java/FeatureFiles/TC1.feature"},
                glue = {"StepDefinations"},
                plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        )
public class ExtendReport extends AbstractTestNGCucumberTests {


}
