package StepDefinations;

import Pages.DialogContent;
import Pages.TopNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BankBranchSteps {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Draw Results");


    @Given("Click on ATM and Branchs Buttons")
    public void clickOnATMAndBranchsButtons() {
        tn.findAndClick("atmAndBranchs");



    }

    @And("Choose your city")
    public void chooseYourCity(DataTable dataTable) throws AWTException, InterruptedException {
        Thread.sleep(5);
        Robot rbt = new Robot();
        dc.findAndClick("city");

        List<List<String>> listElemanlar = dataTable.asLists(String.class);

        for (int i = 0; i < listElemanlar.size(); i++)

            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1));


        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

    }

    @And("Choose your District")
    public void chooseYourDistrict(DataTable dataTable) throws AWTException, InterruptedException {
        Robot rbt = new Robot();
        Thread.sleep(5);
        dc.findAndClick("districts");
        List<List<String>> listElemanlar = dataTable.asLists(String.class);

        for (int i = 0; i < listElemanlar.size(); i++)
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1));
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);
    }


    @And("Click search button and view the list")
    public void clickSearchButtonAndViewTheList() throws IOException {
        dc.findAndClick("branchSearchButton");

        List<WebElement> subeler=dc.branchList;

        for (int i = 0; i < subeler.size(); i++) {
            WebElement result = subeler.get(i);
            String text = result.getText();
            String link = result.getAttribute("href");

            sheet.createRow(i).createCell(0).setCellValue(text);
            sheet.getRow(i).createCell(1).setCellValue(link);
        }

        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File("src/test/Sube.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("Search Results written successfully on disk.");
    }


    @Given("Click on ATM and Branchs Buttons Choose Atm")
    public void clickOnATMAndBranchsButtonsChooseAtm() {
        tn.findAndClick("atmAndBranchs");
        dc.findAndClick("atms");
    }
}
