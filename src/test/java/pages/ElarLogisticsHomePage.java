package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class ElarLogisticsHomePage {
    WebDriver driver;
     public ElarLogisticsHomePage(){
         driver= Driver.getDriver();
         PageFactory.initElements(driver,this);
     }

     @FindBy(xpath = "//a[@href='#/panel/companies/list']")
    public WebElement companiesTab;


    @FindBy(xpath = "//tr[2]//td[1]")
    public WebElement AbcCompany;

    @FindBy(xpath = "//p[@class='title']")
    public  WebElement headerListOfCompanies;

    @FindBy(className = "link-btm-menu")
    public WebElement addCompanyBtn;

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M7.54444 0')]")
    public WebElement yardPageBtn;

    @FindBy(xpath = "//a[@class='link-btm-menu']")
    public WebElement addYardBtn;

    @FindBy(xpath = "//input[@id='id_yard_location']")
    public WebElement nameInput;

    @FindBy(xpath = "//select[@id='id_status']")
    public WebElement statusDropDwn;

    @FindBy(xpath = "//input[@id='id_address']")
    public WebElement streetInput;

    @FindBy(xpath = "//input[@id='id_apt_suite_company_co']")
    public WebElement aptSuiteInputNonRequired;

    @FindBy(xpath = "//input[@id='id_city']")
    public WebElement cityInput;

    @FindBy(xpath = "//select[@id='id_state']")
    public WebElement stateDropDwn;

    @FindBy(xpath = "//input[@id='id_zip_code']")
    public WebElement zipCodeInput;

    @FindBy(xpath = "//input[@class='input-form border disabled-company disabled-not-ext']")
    public WebElement servicePhoneInputNonRequired;

    @FindBy(xpath = "//div[@class='form-content']//div[1]//p[2]//span[1]//span[2]//input[1]")
    public WebElement contactNameNonRequired;

    @FindBy(xpath = "//input[@class='disabled-not-ext input-form border disabled-company']")
    public WebElement ownerPhoneInputNonRequired;

    @FindBy(xpath = "//div[@class='form-content']//div[1]//p[2]//span[1]//span[2]//input[1]")
    public WebElement contactNameInputNonRequired;

    @FindBy(xpath = "//input[@id='id_spots']")
    public WebElement spotsInput;

    @FindBy(xpath = "//input[@id='id_warning']")
    public WebElement warningInputNonRequired;

    @FindBy(xpath = "//textarea[@id='id_notes']")
    public WebElement notesInputNonRequired;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement saveAddYardBtn;














}
