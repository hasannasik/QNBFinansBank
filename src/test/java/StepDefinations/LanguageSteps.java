package StepDefinations;

import Pages.TopNav;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguageSteps {
    TopNav tn=new TopNav();
    @Given("Change Language")
    public void changeLanguage() {
        tn.findAndClick("language");
    }

    @Then("Verify that the page language has changed")
    public void verifyThatThePageLanguageHasChanged() {
        GWD.getDriver().getCurrentUrl().contains("en");
    }

    @Given("Go to the French site")
    public void goToTheFrenchSite() {
        tn.findAndClick("turkey");
        tn.findAndClick("fransa");
    }

    @Then("Verify that the page has changed")
    public void verifyThatThePageHasChanged() {
        GWD.getDriver().getCurrentUrl().equalsIgnoreCase("france");
    }
}
