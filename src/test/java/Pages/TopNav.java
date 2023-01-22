package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNav extends Parent {
    WebElement myElement;

    public TopNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='Header-navigation-top-item'][2]")
    private WebElement atmAndBranchs;

    @FindBy(css = "[class='list-nav'] [class='icon-Arama']")
    private WebElement searchIkon;

    @FindBy(id = "searchTxt")
    private WebElement searchTxt;

    @FindBy(xpath = "//a[text()='Ara']")
    private WebElement araButton;

    @FindBy(xpath = "//nav[@aria-label='Ana Menü']//*[text()='Bireysel']")
    private WebElement bireysel;

    @FindBy(css = "[class=menu-col-2] > div:nth-child(2)")
    private WebElement krediler;

    @FindBy(css = "[class='Header-navigation-top-item']")
    private WebElement urunler;

    @FindBy(css = "[class='languegeRedirectionLink']")
    private WebElement language;

    @FindBy(css = "[class='lang-item']")
    private WebElement turkey;

    @FindBy(xpath = "//a[text()='Fransa']")
    private WebElement fransa;


    public void findAndSend(String strElement, String value) {
        switch (strElement) {


            case "searchTxt":
                myElement = searchTxt;
                break;
//            case "":myElement = ;break;
//            case "":myElement = ;break;

        }
        sendKeysFunction(myElement, value);

    }


    public void findAndClick(String strElement) {
        switch (strElement) {


            case "atmAndBranchs":
                myElement = atmAndBranchs;
                break;
            case "searchIkon":
                myElement = searchIkon;
                break;
            case "araButton":
                myElement = araButton;
                break;
            case "bireysel":
                myElement = bireysel;
                break;
            case "krediler":
                myElement = krediler;
                break;
            case "urunler":
                myElement = urunler;
                break;
            case "language":
                myElement = language;
                break;
            case "turkey":
                myElement = turkey;
                break;
            case "fransa":
                myElement = fransa;
                break;
            //            case "":myElement = ;break;
            //            case "":myElement = ;break;
            //            case "":myElement = ;break;
            //            case "":myElement = ;break;

        }
        clickFunction(myElement);
    }


}

