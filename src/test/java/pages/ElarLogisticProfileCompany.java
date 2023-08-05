package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogisticProfileCompany {
    WebDriver driver;
    public ElarLogisticProfileCompany(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='arrow-doc']//a//p")
    public WebElement editBtn;

    @FindBy(name = "company_name")
    public  WebElement nameInput;

    @FindBy(className = "confirm-cancel")
    public WebElement cancelBtn;

    @FindBy(xpath = "//div[@class='profile-title-text']//span[contains(text(),'AAABBBCCC')]")
    public WebElement CompanyNameHeader;

    @FindBy(className = "return-span")
    public WebElement backToCompBtn;

    @FindBy(xpath = "//div[@class='title']")
    public  WebElement headerAddCompanyBtn;

    @FindBy(className = "confirm-cancel")
    public WebElement popUpBtn;

    @FindBy(className = "confirm-save")
    public WebElement saveBtn;

    @FindBy(xpath = "//input[@id='id_mc_number']")
    public WebElement mcInput;

}
