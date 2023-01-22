package StepDefinations;

import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomePageSteps {
    @Given("Navigate To the bank's website")
    public void navigateToTheBankSWebsite() {
        GWD.getDriver().get("https://www.qnbfinansbank.com/");
        GWD.getDriver().manage().window().maximize();
    }

    @Then("Verify that you are on their website")
    public void verifyThatYouAreOnTheirWebsite() {
        String title=GWD.getDriver().getTitle();
        Assert.assertEquals("Basarisiz giris",title,"QNB Finansbank Bankacılık ve Finans Hizmetleri");
    }
}
