package StepDefinations;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class MarketDataSteps {

    DialogContent dc = new DialogContent();

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Market Data Results");


    @Given("Navigate to Market Data And Check Data")
    public void navigateToMarketData() {
//        GWD.getDriver().get("https://www.google.com/search?q=bist+100&sxsrf=AJOqlzXUHXXIgI6t-7ldR5MRJX6Mvol9Gw%3A1674314246816&ei=BgLMY43KMcXSkwXWipyIBg&oq=Bist&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQARgAMg8IABCxAxCDARBDEEYQ-gEyBwgAELEDEEMyBwgAELEDEEMyCAgAEIAEELEDMgcIABCxAxBDMgcIABCxAxBDMggIABCABBCxAzILCAAQgAQQsQMQgwEyCAgAEIAEELEDMggIABCABBCxAzoECCMQJzoKCAAQsQMQgwEQQzoFCAAQgAQ6DgguEIMBENQCELEDEIAEOgQIABBDOgoILhDHARDRAxBDSgQIQRgASgQIRhgAUABY6gRgtRdoAHAAeACAAZUBiAGiBJIBAzAuNJgBAKABAcABAQ&sclient=gws-wiz-serp");
//        WebElement bist100=GWD.getDriver().findElement(By.cssSelector("[class='IsqQVc NprOob wT3VGc']"));
//        String googleDegeri=bist100.getText();
//        System.out.println("googleDegeri = " + googleDegeri);
//        GWD.getDriver().get("https://www.qnbfinansbank.com/");
        dc.findAndContainsText("marketData","Piyasa Verileri");
        dc.findAndContainsText("bist100","5.490,34");

    }



    @Then("Save data to excel")
    public void saveDataToExcel() throws IOException {
        List<WebElement> liste=dc.marketDataVeri;

        for (int i = 0; i < liste.size(); i++) {
            WebElement result = liste.get(i);
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
