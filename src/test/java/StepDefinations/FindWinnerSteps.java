package StepDefinations;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FindWinnerSteps{

    DialogContent dc = new DialogContent();

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Draw Results");

    @Given("Click on all Campaigns")
    public void clickOnAllCampaigns() {
        dc.findAndClick("campaigns");
        dc.findAndContainsText("pageText", "Kampanyalar");
    }

    @And("Click on QNB Mobile Football Enthusiasm Lottery Results")
    public void clickOnQNBMobileFootballEnthusiasmLotteryResults() {
        dc.findAndClick("mobilFootBallCampaigns");
        dc.findAndContainsText("pageText", "QNB Mobil Futbol Coşkusu Çekilişi Sonuçları");

    }

    @When("Click on Lottery Results")
    public void clickOnLotteryResults() {
        dc.findAndClick("drawResults");
    }

    @Then("Print the winners in excel")
    public void printTheWinnersInExcel()  throws IOException {



        List<WebElement> kazananlar=dc.results;

        for (int i = 0; i < kazananlar.size(); i++) {
            WebElement result = kazananlar.get(i);
            String text = result.getText();
            String link = result.getAttribute("href");

            sheet.createRow(i).createCell(0).setCellValue(text);
            sheet.getRow(i).createCell(1).setCellValue(link);
        }

        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File("src/test/IphoneKazananlar.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("Search Results written successfully on disk.");

    }
}
