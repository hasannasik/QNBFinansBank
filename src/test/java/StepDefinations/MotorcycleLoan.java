package StepDefinations;

import Pages.DialogContent;
import Pages.TopNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class MotorcycleLoan {
    DialogContent dc=new DialogContent();
    TopNav tn=new TopNav();
    @Given("Go to the credits page from the individual top menu")
    public void goToTheCreditsPageFromTheIndividualTopMenu() {
        tn.findAndClick("bireysel");
        tn.findAndClick("krediler");
        dc.findAndContainsText("pageText","Bireysel Krediler");

    }

    @When("Go to motorcycle loan section")
    public void goToMotorcycleLoanSection() {
        dc.findAndClick("tasitKredisi");
        dc.findAndContainsText("pageText","Taşıt Almak İçin");
        dc.findAndClick("motorcycleLoan");
        dc.findAndContainsText("pageText","Motosiklet Kredisi");

    }

    @Then("Make and verify the loan calculation")
    public void makeAndVerifyTheLoanCalculation() {
        dc.findAndClick("motorcycleLoanCalculate");
        dc.findAndSend("krediTutari","10101010");



    }
}
