package stepDefinitions.API;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.internal.LinkedTreeMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reuseLib.ApiLib;
import reuseLib.ApiResponse;


public class APISteps {
	private ApiLib api;
	private ApiResponse response;
	private String tenantName;
	private String username;
	private String password;
	private String token;

	
    public APISteps(ApiLib api) {
        this.api = api;
    }
    
    @Given("^I want to open login using tentat \"([^\"]*)\", username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_want_to_open_login_using_tentat_username_and_password(String tenantName, String username, String password) throws Throwable {
    	this.tenantName = tenantName;
    	this.username = username;
    	this.password = password;
    }

    @When("^I login into Orchestrator Web Serivce and receive session token$")
    public void i_login_into_Orchestrator_Web_Serivce_and_receive_session_Token() throws Throwable {
    	this.token = api.GetSessionToken(tenantName, username, password);
    }

    @Then("^I check that session token is not empty$")
    public void i_check_that_session_tocken_is_not_empty() throws Throwable {
    	assertFalse(token.isEmpty());
    }
    
    @Then("^I check that session token is empty$")
    public void i_check_that_session_tocken_is_empty() throws Throwable {
    	assertTrue(token.isEmpty());
    }
    
    @When("^I send request to receive all assets data$")
    public void i_send_request_to_receive_all_assets_data() throws Throwable {
		HashMap<String,String> header = new HashMap<String,String>();
		header.put("Authorization", "Bearer " + token);
		this.response = api.CallService("/odata/Assets", "get", null, header);
    }

    @SuppressWarnings("unchecked")
	@Then("^I check that assets count greater then (\\d+)$")
    public void i_check_that_assets_count_greater_then(int arg1) throws Throwable {
    	assertTrue(((List<String>)response.body.get("value")).size() > arg1);
    }
    
    @When("^I send request to create new \"([^\"]*)\" asset with type \"([^\"]*)\" and value \"([^\"]*)\"$")
    public void i_send_request_to_create_new_asset_with_type_and_value(String assetName, String valueType, String valueText) throws Throwable {
		HashMap<String,String> params = new HashMap<String,String>();
		HashMap<String,String> header = new HashMap<String,String>();
		params.put("Name", assetName);
		params.put("ValueType", valueType);
		params.put("ValueScope", "Global");
		params.put("StringValue", valueText);
		header.put("Authorization", "Bearer " + token);
		this.response = api.CallService("/odata/Assets", "post", params, header);
    }

    @Then("^I check response code (\\d+)$")
    public void i_check_response_code_that_it_is(int responseCode) throws Throwable {
    	assertTrue(response.responseCode == responseCode);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Then("^I search asset in assets list by asset name \"([^\"]*)\"$")
    public void i_search_in_assets_list_new_created_asset_by_asset_name(String assetName) throws Throwable {
    	boolean result = false;
		ArrayList<LinkedTreeMap> res = (ArrayList<LinkedTreeMap>) (response.body.get("value"));
		for (LinkedTreeMap linkedTreeMap : res) {
			if(linkedTreeMap.get("Name").toString().equals(assetName)) {
				result = true;
				break;
			}
		}
		assertTrue(result);	
    }
    
}

