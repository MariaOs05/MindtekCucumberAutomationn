package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHome;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebOrdersSteps {
    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersHome webOrdersHome = new WebOrdersHome();
    WebOrdersOrderPage webOrdersOrderPage = new WebOrdersOrderPage();

    List<Map<String,Object>> data = new ArrayList<>();

    @Given("User navigates to application")
    public void user_navigates_to_application() {
        driver.get(ConfigReader.getProperty("WebOrdersURL"));
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        webOrdersLoginPage.usernameInput.sendKeys(username);
        webOrdersLoginPage.passwordInput.sendKeys(password);
        webOrdersLoginPage.loginBtn.click();
    }

    @Then("User is successfully lands on the homepage")
    public void user_is_successfully_lands_on_the_homepage() {
        Assert.assertEquals("Web Orders", driver.getTitle());
    }

    @Then("User validates error message {string}")
    public void user_validates_error_message(String invalidCredentialMessage) {
        Assert.assertEquals(invalidCredentialMessage, webOrdersLoginPage.errorMessage.getText());

    }

    //////////////////////////////////////////////////////////////////////////
    @When("User clicks on Order tab")
    public void user_clicks_on_order_tab() {
        webOrdersHome.orderTab.click();
    }

    @When("User selects product {string} and quantity {int}")
    public void user_selects_product_and_quantity(String product, Integer quantity) {
        BrowserUtils.selectDropdownByValue(webOrdersOrderPage.productDropdown, product);
        webOrdersOrderPage.quantityInput.sendKeys(Keys.BACK_SPACE+quantity.toString());
        webOrdersOrderPage.calculateBtn.click();

    }

    @Then("User validates the price is correctly calculated for {int}")
    public void user_validates_the_price_is_correctly_calculated_for(Integer quantity) {
        int priceInt =Integer.parseInt(webOrdersOrderPage.pricePerUnit.getAttribute("value"));
        int discountInt = Integer.parseInt(webOrdersOrderPage.discount.getAttribute("value"));
        int expectedTotal;
        if(quantity>= 10){
            expectedTotal= quantity*priceInt*(100-discountInt)/100;

//            expectedTotal = quantity*priceInt*discountInt/100;
//            expectedTotal = quantity*priceInt-expectedTotal;
        }else{
            expectedTotal = priceInt*quantity;
        }
        int actualTotal = Integer.parseInt(webOrdersOrderPage.total.getAttribute("value"));
        Assert.assertEquals(expectedTotal, actualTotal);
    }

    //////////////////////////////////////////////////////////////////////////////
    @When("User creates order with data")
    public void user_creates_order_with_data(DataTable dataTable) {
        data = dataTable.asMaps(String.class,Object.class);

        for(int i= 0; i<data.size(); i++){
            BrowserUtils.selectDropdownByValue(webOrdersOrderPage.productDropdown,data.get(i).get("PRODUCT").toString());
            webOrdersOrderPage.quantityInput.sendKeys(Keys.BACK_SPACE+data.get(i).get("QUANTITY").toString());
            webOrdersOrderPage.inputName.sendKeys(data.get(i).get("CUSTOMER NAME").toString());
            webOrdersOrderPage.inputStreet.sendKeys(data.get(i).get("STREET").toString());
            webOrdersOrderPage.inputCity.sendKeys(data.get(i).get("CITY").toString());
            webOrdersOrderPage.inputState.sendKeys(data.get(i).get("STATE").toString());
            webOrdersOrderPage.inputZip.sendKeys(data.get(i).get("ZIP").toString());
            webOrdersOrderPage.visaCardBtn.click();
            webOrdersOrderPage.inputCardNum.sendKeys(data.get(i).get("CARD NUM").toString());
            webOrdersOrderPage.inputExpDate.sendKeys(data.get(i).get("EXP DATE").toString());
            webOrdersOrderPage.processBtn.click();
            user_validates_success_message("New order has been successfully added.");
        }
    }

    @Then("User validates success message {string}")
    public void user_validates_success_message(String expectedMessage) {
       Assert.assertEquals(expectedMessage,webOrdersOrderPage.successMessage.getText());
    }


    @Then("User validates created order is in the list of all orders.")
    public void user_validates_created_order_is_in_the_list_of_all_orders() {
        webOrdersHome.viewAllOrdersTab.click();
       Assert.assertEquals(data.get(1).get("CUSTOMER NAME").toString(), webOrdersHome.firstRowOrder.get(1).getText());

    }


}
