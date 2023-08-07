package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ElarLogisticsHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import java.util.List;
import java.util.Map;

public class ElarLogisticStepsNew {

    WebDriver driver = Driver.getDriver();
ElarLogisticsHomePage elarLogisticsHomePage= new ElarLogisticsHomePage();
List<Map<String,Object>> data;

    @When("User click on Yards tab")
    public void user_click_on_yards_tab() {
    elarLogisticsHomePage.yardPageBtn.click();

    }
    @When("User clicks on Add Yard")
    public void user_clicks_on_add_yard() {
       elarLogisticsHomePage.addYardBtn.click();

    }
    @When("user inputs required data")
    public void user_inputs_required_data(io.cucumber.datatable.DataTable dataTable) {
        data = dataTable.asMaps(String.class, Object.class);
        for(int i= 0; i<data.size(); i++) {
        elarLogisticsHomePage.nameInput.sendKeys(data.get(i).get("NAME").toString());
        elarLogisticsHomePage.streetInput.sendKeys(data.get(i).get("STREET").toString());
        elarLogisticsHomePage.cityInput.sendKeys(data.get(i).get("CITY").toString());
        BrowserUtils.selectDropdownByValue(elarLogisticsHomePage.stateDropDwn,data.get(i).get("STATE").toString());
        elarLogisticsHomePage.zipCodeInput.sendKeys(data.get(i).get("ZIP CODE").toString());
        elarLogisticsHomePage.spotsInput.sendKeys(data.get(i).get("SPOTS").toString());
        elarLogisticsHomePage.saveAddYardBtn.click();

        }
    }
//    @When("user inputs required data")
//    public void user_inputs_required_data(DataTable dataTable) {
//        data = dataTable.asMaps(String.class, Object.class);
//        for(Map map: data){

   //     }
  //  }
    @When("user clicks on add yard button")
    public void user_clicks_on_add_yard_button() {

    }
    @Then("User validates Yard is correctly inserted into core_yard table in Data Base")
    public void user_validates_yard_is_correctly_inserted_into_core_yard_table_in_data_base() {

    }
}
