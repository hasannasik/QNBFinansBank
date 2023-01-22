package StepDefinations;

import Pages.DialogContent;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class ConsomerLoan {
    DialogContent dc = new DialogContent();
    @Given("Enter the required values")
    public void enterTheRequiredValues(DataTable dataTable) {
        List<List<String >> listElemanlar=dataTable.asLists(String.class);
        for (int i = 0; i < listElemanlar.size(); i++) {
            dc.findAndSend(listElemanlar.get(i).get(0),listElemanlar.get(i).get(1));
        }
    }

    @Then("Verify credit has been calculated")
    public void verifyCreditHasBeenCalculated() {
        dc.findAndContainsText("geriOdeme","Ödeme");
    }
}
