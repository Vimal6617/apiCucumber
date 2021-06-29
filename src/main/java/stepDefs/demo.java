package stepDefs;

import common.Init;
import common.constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import utils.YamlReader;
import java.util.List;


public class demo implements Init {

    @Before
    public void beforescenario(){
        constants.queryMap.clear();
        constants.headerMap.clear();
    }

    @Given("^api endpoint for \"([^\"]*)\"$")
    public void apiEndpoint(String endpoint_name) {
        constants.endpoint = YamlReader.getYamlValue("api", endpoint_name + ".endpoint");
    }

    @And("^set Query Param for \"([^\"]*)\" as \"([^\"]*)\"$")
    public void setQueryParam(String queryParamName, String queryParamValue) {
        constants.queryMap.put(queryParamName, queryParamValue);
    }


    @When("^method is \"([^\"]*)\"$")
    public void methodIs(String restApiMethodType) {
        switch (restApiMethodType) {
            case "get":
                restApi.get_api();
                break;
            case "post":
                restApi.post_api();
                break;
            case "patch":
                restApi.patch_api();
                break;
            case "delete":
                restApi.delete_api();
                break;
        }
    }

    @Then("^validate status code \"([^\"]*)\"$")
    public void validateStatusCode(int statusCode) {
        System.out.println("Status Code : " + constants.response.getStatusCode());
        Assert.assertEquals(constants.response.getStatusCode(), statusCode);
    }

    @Then("^validate result for size as \"([^\"]*)\"$")
    public void validateResultForSizeAs(int size) {
        List<String> content = constants.response.jsonPath().get("content");
        int contentsize = content.size();
        Assert.assertEquals(contentsize, size, "List of user not as per Query");

        int response_size = constants.response.jsonPath().get("page.size");
        Assert.assertEquals(response_size, size, "List of User is Different wrt to mentioned in Response");
    }


    @Then("^validate result for Totalpage as \"([^\"]*)\" where size is \"([^\"]*)\"$")
    public void validateResultForPageWRTSize(int pageNumber, int sizeValue) {
        int pagenumeber = constants.response.jsonPath().get("page.number");
        Assert.assertEquals(pagenumeber, pageNumber, "Page Number Mentioned does not match the response");
        int totalelements = constants.response.jsonPath().get("page.totalElements");
        int totalPages = constants.response.jsonPath().get("page.totalPages");
        int pagecount = util.countNumberOfPages(totalelements, sizeValue);
        Assert.assertEquals(totalPages,pagecount,"Pagecount is not correct as per calculations");
    }

    @Then("^Save user Details$")
    public void saveUserDetails() {
        constants.userId = constants.response.jsonPath().get("content[0].id").toString();
        constants.firstName = constants.response.jsonPath().get("content[0].firstName").toString();
        constants.lastName = constants.response.jsonPath().get("content[0].lastName").toString();
        constants.email = constants.response.jsonPath().get("content[0].email").toString();
        constants.dayOfBirth = constants.response.jsonPath().get("content[0].dayOfBirth").toString();
    }

    @And("^Add endpoint \"([^\"]*)\"$")
    public void addEndpoint(String endPoint){
        constants.endpoint += endPoint.replace("id",constants.userId);
    }

    @Then("^validate user Details$")
    public void validateUserDetails() {
        Assert.assertEquals(constants.response.jsonPath().get("firstName").toString(),constants.firstName);
        Assert.assertEquals(constants.response.jsonPath().get("lastName").toString(),constants.lastName);
        Assert.assertEquals(constants.response.jsonPath().get("email").toString(),constants.email);
        Assert.assertEquals(constants.response.jsonPath().get("dayOfBirth").toString(),constants.dayOfBirth);
    }

    @And("^Validate user Field Details$")
    public void validateUserFieldDetails() {
            Assert.assertTrue( util.validateStringLength(constants.firstName,2,15),"Firstname length Does not match the Constraints mentioned");
            Assert.assertTrue( util.validateStringLength(constants.lastName,2,30),"Lastname length Does not match the Constraints mentioned");
            Assert.assertTrue(util.isValidEmailAddress(constants.email),"Email is not valid");
            Assert.assertTrue(util.validateDOB(constants.dayOfBirth),"Date of birth is Invalid as per the format given");

    }
}
