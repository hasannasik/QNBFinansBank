package StepDefinations;

import Pages.DialogContent;
import Pages.TopNav;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InsuranceSteps {
    TopNav tn=new TopNav();
    DialogContent dc=new DialogContent();

    @Given("Enter the {string} in the search box")
    public void enterTheInTheSearchBox(String text) {
        tn.findAndClick("searchIkon");
        tn.findAndSend("searchTxt",text);
        tn.findAndClick("araButton");
        dc.findAndContainsText("pageText","Arama");
    }


    @When("Click on the first link and click on Engineering insurance on the page that appears")
    public void clickOnTheFirstLinkAndClickOnEngineeringInsuranceOnThePageThatAppears() {
        dc.findAndClick("kobi");
        dc.findAndContainsText("pageText","KOBİ Sigortaları");
        dc.findAndClick("engineerInsurance");




    }

    @Then("Verify that you are on the right page")
    public void verifyThatYouAreOnTheRightPage() {
        dc.findAndContainsText("pageText","Mühendislik Sigortaları");
    }


}
