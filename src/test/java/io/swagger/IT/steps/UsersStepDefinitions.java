package io.swagger.IT.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.swagger.model.Account;
import io.swagger.model.AccountBalance;
import io.swagger.model.User;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.threeten.bp.LocalDate;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class UsersStepDefinitions {

    HttpHeaders headers = new HttpHeaders();
    RestTemplate template = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();
    ResponseEntity<String> responseEntity;
    String baseUrl = "http://localhost:8080/api/Users";
    URI uri;

    public UsersStepDefinitions() throws URISyntaxException {
        this.headers.add("session","testEmployee");
        this.uri = new URI(baseUrl);
    }

    @When("I retrieve all users")
    public void iRetrieveAllUsers() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        responseEntity = template.exchange(uri, HttpMethod.GET, entity, String.class);
    }

    @When("I retrieve user by id {int}")
    public void iGetUserById(Integer id) throws URISyntaxException{
        URI uri = new URI(baseUrl+"/"+id);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        responseEntity = template.exchange(uri, HttpMethod.GET, entity, String.class);
    }

    //can only be tested when birthday is not required
    @When("I create an user")
    public void iCreateUser() throws JsonProcessingException {

        JSONObject obj = new JSONObject();

        obj.put("username", "test123");
        obj.put("password", "Welcome567?");
        obj.put("firstName", "test");
        obj.put("prefix", "t");
        obj.put("lastName", "Tester");
        obj.put("email", "test@test.nl");
        obj.put("birthday", "2020-05-05");
        obj.put("address", "Haarlem");
        obj.put("postalcode", "1544MK");
        obj.put("city", "Haarlem");
        obj.put("phoneNumber", "0611111111");
        obj.put("type", User.TypeEnum.CUSTOMER);
        obj.put("active", true);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(obj), headers);
        responseEntity = template.exchange(uri, HttpMethod.POST, entity, String.class);
    }

    //can only be tested when birthday is not required
    @When("I update an user")
    public void iUpdateUser() throws JsonProcessingException {

        JSONObject obj = new JSONObject();

        obj.put("username", "test12345");
        obj.put("password", "Welcome567?");
        obj.put("firstName", "test");
        obj.put("prefix", "t");
        obj.put("lastName", "Tester");
        obj.put("email", "test@test.nl");
        obj.put("birthday", "2020-05-05");
        obj.put("address", "Haarlem");
        obj.put("postalcode", "1544MK");
        obj.put("city", "Haarlem");
        obj.put("phoneNumber", "0611111111");
        obj.put("type", User.TypeEnum.CUSTOMER);
        obj.put("active", true);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(obj), headers);
        responseEntity = template.exchange(uri, HttpMethod.POST, entity, String.class);
    }

    @When("I retrieve an user by lastname {string}")
    public void GetUsersByLastname(String lastname) throws URISyntaxException{
        URI uri = new URI(baseUrl);
        String s =  "{\"offset\": 0,\n" +
                "\"limit\": 100,\n" +
                "\"searchname\": "+lastname+" }";
        HttpEntity<String> entity = new HttpEntity<>(s, headers);
        responseEntity = template.exchange(uri, HttpMethod.GET, entity, String.class);
    }

    @When("I retrieve an user by username {string}")
    public void GetUsersByUsername(String username) throws URISyntaxException{
        URI uri = new URI(baseUrl);
        String s =  "{\"offset\": 0,\n" +
                "\"limit\": 100,\n" +
                "\"searchname\": "+username+" }";
        HttpEntity<String> entity = new HttpEntity<>(s, headers);
        responseEntity = template.exchange(uri, HttpMethod.GET, entity, String.class);
    }

    @Then("I get http status users {int}")
    public void iGetHttpStatusUsers(int status) {
        Assert.assertEquals(responseEntity.getStatusCodeValue(), status);
    }
}
