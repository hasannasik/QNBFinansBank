package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent {
    WebElement myElement;

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='owl-dots']//*[text()='Tüm Kampanyalar']")
    private WebElement campaigns;

    @FindBy(css = "[id='pageh1']")
    private WebElement pageText;

    @FindBy(css = "[id='campaign'] > div:nth-child(5)")
    private WebElement mobilFootBallCampaigns;

    @FindBy(id = "acc-1")
    private WebElement drawResults;

    @FindBy(css = "[id='content-1']  > p")
    public List<WebElement> results;


    @FindBy(id = "select2-dllCity2-container")
    private WebElement city;

    @FindBy(id = "select2-dllDistricts2-container")
    private WebElement districts;

    @FindBy(className = "select2-search__field")
    private WebElement sendText;

    @FindBy(css = "[class*=basic-branch]")
    private WebElement branchSearchButton;

    @FindBy(css = "[class='atm-branch-list-item box border clearfx']")
    public List<WebElement> branchList;

    @FindBy(id = "Marketdata")
    private WebElement marketData;

    @FindBy(xpath = "//*[text()='BIST100']//following-sibling::span[1]")
    private WebElement bist100;

    @FindBy(css = "[class='Market-data-block-item']")
    public List<WebElement> marketDataVeri;

    @FindBy(xpath = "//*[contains(text(),'Özel Sigortalar')]")
    private WebElement kobi;

    @FindBy(xpath = "//*[text()='Mühendislik Sigortaları']")
    private WebElement engineerInsurance;

    @FindBy(xpath = "//*[text()='Taşıt Almak İçin']")
    private WebElement tasitKredisi;

    @FindBy(xpath = "//*[text()='Motosiklet Kredisi']")
    private WebElement motorcycleLoan;

    @FindBy(id = "acc-2")
    private WebElement motorcycleLoanCalculate;

    @FindBy(id = "loan-landing-subpage-credit")
    private WebElement krediTutari;

    @FindBy(id = "loan-landing-subpage-maturity")
    private WebElement vadeSuresi;

    @FindBy(xpath = "//*[contains(@class,'btn-calculate')]")
    private WebElement calculateButton;

    @FindBy(xpath = "//li//*[text()='QNB Finansbank ATM’lerimiz']")
    private WebElement atms;

    @FindBy(id = "eft")
    private WebElement eft;

    @FindBy(css = "[class='acc-content'] > div:nth-child(1)")
    private WebElement sube;

    @FindBy(xpath = "//*[text()='Hesaptan']")
    private WebElement hesaptan;

    @FindBy(id = "loan-home-credit")
    private WebElement krediTutariHome;

    @FindBy(xpath = "//*[contains(text(),'Toplam Geri')]")
    private WebElement geriOdeme;


    public void findAndSend(String strElement, String value) {
        switch (strElement) {


            case "sendText":
                myElement = sendText;
                break;
            case "krediTutari":
                myElement = krediTutari;
                break;
            case "krediTutariHome":
                myElement = krediTutariHome;
                break;

        }
        sendKeysFunction(myElement, value);

    }

    public void findAndClick(String strElement) {
        switch (strElement) {


            case "campaigns":
                myElement = campaigns;
                break;
            case "mobilFootBallCampaigns":
                myElement = mobilFootBallCampaigns;
                break;
            case "drawResults":
                myElement = drawResults;
                break;
            case "city":
                myElement = city;
                break;
            case "districts":
                myElement = districts;
                break;
            case "branchSearchButton":
                myElement = branchSearchButton;
                break;
            case "kobi":
                myElement = kobi;
                break;
            case "engineerInsurance":
                myElement = engineerInsurance;
                break;
            case "motorcycleLoan":
                myElement = motorcycleLoan;
                break;
            case "motorcycleLoanCalculate":
                myElement = motorcycleLoanCalculate;
                break;
            case "tasitKredisi":
                myElement = tasitKredisi;
                break;
            case "calculateButton":
                myElement = calculateButton;
                break;
            case "atms":
                myElement = atms;
                break;

            case "eft":
                myElement = eft;
                break;
            case "sube":
                myElement = sube;
                break;

//            case "":myElement = ;break;
//            case "":myElement = ;break;
//            case "":myElement = ;break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strlement, String text) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "pageText":
                myElement = pageText;
                break;

            case "marketData":
                myElement = marketData;
                break;

            case "bist100":
                myElement = bist100;
                break;

            case "hesaptan":
                myElement = hesaptan;
                break;
            case "geriOdeme":
                myElement = geriOdeme;
                break;
//            case "":myElement = ;break;
//            case "":myElement = ;break;
//            case "":myElement = ;break;
//            case "":myElement = ;break;
//            case "":myElement = ;break;
//            case "":myElement = ;break;

        }

        verifyContainsTextFunction(myElement, text);
    }

    public void findAndDelete(String searchText) {

        findAndSend("searchInput", searchText);  // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas

        //wait.until(ExpectedConditions.stalenessOf(deleteButton)); stale zamanını yakalayamadım
        //wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tbody[@role='rowgroup']//tr"),5));

        // findAndContainsText("searchResultCell", searchText); // arama sonuçlarının ilkinde aranan kelime gözükene kadar bekle.

        waitUntilLoading(); // progressbar ın çocukları 0 olana kadar bekle

        findAndClick("deleteButton"); // silme butonua bas, çöp kutusu
        findAndClick("deleteDialogBtn"); // dilogdaki silme butonuna bas

    }
}

