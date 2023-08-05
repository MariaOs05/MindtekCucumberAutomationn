package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ElarLogisticProfileCompany;
import pages.ElarLogisticsHomePage;
import pages.ElarLogisticsLoginPages;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class ElarLogisticsSteps {
    WebDriver driver = Driver.getDriver();
    ElarLogisticsLoginPages elarLogisticsPages = new ElarLogisticsLoginPages();
    ElarLogisticsHomePage elarLogisticsHomePage = new ElarLogisticsHomePage();
    ElarLogisticProfileCompany elarLogisticProfileCompany = new ElarLogisticProfileCompany();

    @Given("User navigates to Elar Logistics application")
    public void user_navigates_to_elar_logistics_application() {
        driver.get(ConfigReader.getProperty("ElarLogisticsURL"));
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        elarLogisticsPages.loginInput.sendKeys(username);
        elarLogisticsPages.passwordInput.sendKeys(password);
        elarLogisticsPages.loginBtn.click();
    }

    @When("User click on companies tab")
    public void user_click_on_companies_tab() {
        elarLogisticsHomePage.companiesTab.click();

    }

    @When("User selects {string} company")
    public void user_selects_company(String string) {
//     for(WebElement company: elarLogisticsHomePage.existingCompanies) {
//         if (company.getText().toLowerCase().equals(string)) company.click();
//     }
        elarLogisticsHomePage.AbcCompany.click();
    }

    @When("User clicks on edit button")
    public void user_clicks_on_edit_button() {
        elarLogisticProfileCompany.editBtn.click();
        BrowserUtils.scrollDownBy(2000);
    }

    @Then("User validates fields are editable")
    public void user_validates_fields_are_editable() {
        Assert.assertTrue(elarLogisticProfileCompany.cancelBtn.getText().equalsIgnoreCase("cancel"));
    }

    @When("User clicks on cancel button")
    public void user_clicks_on_cancel_button() {
        elarLogisticProfileCompany.cancelBtn.click();
    }

    @Then("User validates fields remain the same")
    public void user_validates_fields_remain_the_same() {
        String actual = elarLogisticProfileCompany.nameInput.getAttribute("value");
        String expected = "AAABBBCCC";
        Assert.assertEquals(expected, actual);

    }

    @When("User clicks on company name and rename it")
    public void user_clicks_on_company_name_and_rename_it() {
        elarLogisticProfileCompany.nameInput.clear();
        elarLogisticProfileCompany.nameInput.sendKeys("Abcdefg");

    }

    @Then("User validates edited fields remain the same")
    public void user_validates_edited_fields_remain_the_same() {
        String actual = elarLogisticProfileCompany.CompanyNameHeader.getText();
        String expected = "AAABBBCCC";
        Assert.assertEquals(expected, actual);
    }

    @When("User clicks back to companies button")
    public void user_clicks_back_to_companies_button() {
        elarLogisticProfileCompany.backToCompBtn.click();
    }


    @Then("user validates list of companies is displayed")
    public void user_validates_list_of_companies_is_displayed() {
        String expected = "List of Companies";
        String actual = elarLogisticsHomePage.headerListOfCompanies.getText();
        Assert.assertEquals(expected, actual);
    }

    @When("User clicks on Add Company button")
    public void user_clicks_on_add_company_button() {
elarLogisticsHomePage.addCompanyBtn.click();
    }

    @Then("User validates navigation to company creation page")
    public void user_validates_navigation_to_company_creation_page() {
    Assert.assertTrue(elarLogisticProfileCompany.headerAddCompanyBtn.getText().equalsIgnoreCase("Add company"));



    }
    // Test case 6

    @Then("User validates Company name can't be cleared")
    public void user_validates_company_name_can_t_be_cleared() {
            try {
                elarLogisticProfileCompany.nameInput.clear();
                Assert.fail("Element is changeable");
            } catch (InvalidElementStateException exception) {
                Assert.assertTrue("Element not changeable as expected", true);
            }

    }

    // TC 7
    @Then("User validates existing companies are editable")
    public void user_validates_existing_companies_are_editable() {
    try {
        elarLogisticProfileCompany.nameInput.clear();
        Assert.assertTrue("Element is editable", true);
    }catch (InvalidElementStateException exception){
        Assert.fail("Element not editable");
    }
    }
    //TC 8
    @Then("Validating values of the field are immutable")
    public void validating_values_of_the_field_are_immutable() {
        try {
            elarLogisticProfileCompany.nameInput.clear();
            Assert.fail("Element is changeable");
        } catch (InvalidElementStateException exception) {
            Assert.assertTrue("Element not changeable as expected", true);
        }
    }
    @When("User clicks on company name and rename it to {string} Logistics")
    public void user_clicks_on_company_name_and_rename_it_to_logistics(String string) {
        elarLogisticProfileCompany.nameInput.clear();
        elarLogisticProfileCompany.nameInput.sendKeys("M&A");
    }


    @When("User clicks on save btn")
    public void user_clicks_on_save_btn() {
       elarLogisticProfileCompany.saveBtn.click();
    }

    @When("User clicks on Stay on current page when pop-up is visible")
    public void user_clicks_on_stay_on_current_page_when_pop_up_is_visible() {
elarLogisticProfileCompany.popUpBtn.click();
    }
    @Then("User validates input is saved")
    public void user_validates_input_is_saved() {
   String expected ="Abcdefg";
   Assert.assertEquals(expected,elarLogisticProfileCompany.nameInput.getAttribute("value"));

    }

    //TC10
    @When("User clicks on MC and change it")
    public void user_clicks_on_mc_and_change_it() {
        elarLogisticProfileCompany.mcInput.sendKeys("34368765");
    }

    @Then("User validates pop-up says {string}")
    public void user_validates_pop_up_says(String string) {
        String expected = "AAABBBCCC";
       Assert.assertEquals(expected,elarLogisticProfileCompany.nameInput.getAttribute("value"));
    }
}