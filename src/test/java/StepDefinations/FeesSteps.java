package StepDefinations;

import Pages.DialogContent;
import Pages.TopNav;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.DataProvider;

public class FeesSteps {

    DialogContent dc=new DialogContent();
    TopNav tn=new TopNav();
    @Given("Go to the product and fees page")
    public void goToTheProductAndFeesPage() {
        tn.findAndClick("urunler");
        dc.findAndContainsText("pageText","Ürün Hizmet Ücretleri");
    }

    @When("Select one of the Money Transfer options")
    public void selectOneOfTheMoneyTransferOptions() {
        dc.findAndClick("eft");
        dc.findAndClick("sube");

    }


    @Then("View the money transfer details from the branch")
    public void viewTheMoneyTransferDetailsFromTheBranch() {
        dc.findAndContainsText("hesaptan","Hesaptan");
    }
}
