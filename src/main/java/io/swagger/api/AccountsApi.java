/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Account;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-26T17:58:10.113Z[GMT]")
@Api(value = "Accounts", description = "the Accounts API")
public interface AccountsApi {

    @ApiOperation(value = "create a new account", nickname = "createAccount", notes = "Calling this allows you to create a new Accounts.", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Accounts", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "create new  user"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Accounts",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createAccount(@ApiParam(value = ""  )  @Valid @RequestBody Account body
);


    @ApiOperation(value = "get account by IBAN", nickname = "getAccountByIBAN", notes = "Calling this allows you to get the account by IBAN", response = Account.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Accounts", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Accounts", response = Account.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Accounts/iban/{IBAN}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Account>> getAccountByIBAN(@ApiParam(value = "the IBAN",required=true) @PathVariable("IBAN") String IBAN
);


    @ApiOperation(value = "get account by username", nickname = "getAccountByUsername", notes = "Calling this allows you to get the accounts by username", response = Account.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Accounts", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Accounts", response = Account.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Accounts/username/{username}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Account>> getAccountByUsername(@ApiParam(value = "the username",required=true) @PathVariable("username") String username
);


    @ApiOperation(value = "gets all accounts", nickname = "getAllAccounts", notes = "Calling this allows you to fetch all the accounts of all users.", response = Account.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Accounts", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "get all accounts", response = Account.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Accounts",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Account>> getAllAccounts(@ApiParam(value = "The number of items to skip before starting to collect the result set") @Valid @RequestParam(value = "offset", required = false) Integer offset
,@ApiParam(value = "The numbers of items to return") @Valid @RequestParam(value = "limit", required = false) Integer limit
);


    @ApiOperation(value = "Get user accounts", nickname = "getUserAccountsByUserId", notes = "Calling this allows you to fetch all the Accounts by a user", response = Account.class, responseContainer = "List", authorizations = {
            @Authorization(value = "ApiKeyAuth")    }, tags={ "Accounts", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "list of accounts", response = Account.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad request", response = String.class),
            @ApiResponse(code = 401, message = "API key is missing or invalid"),
            @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Users/{id}/Accounts",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Account>> getUserAccountsByUserId(@Min(1)@ApiParam(value = "bad input parameter",required=true, allowableValues="") @PathVariable("id") Integer id
    );

}
