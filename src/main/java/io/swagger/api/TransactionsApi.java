/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Transaction;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-28T09:19:06.758Z[GMT]")
@Api(value = "Transactions", description = "the Transactions API")
public interface TransactionsApi {

    @ApiOperation(value = "create a new transaction", nickname = "createTransaction", notes = "Calling this allows you to create a transaction", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Transactions", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "created transaction"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Transactions",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createTransaction(@ApiParam(value = ""  )  @Valid @RequestBody Transaction body
);


    @ApiOperation(value = "gets all transactions", nickname = "getAllTransactions", notes = "Calling this allows you to fetch all the transactions of all users.", response = Transaction.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Transactions", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "get all transactions", response = Transaction.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Transactions",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Transaction>> getAllTransactions(@ApiParam(value = "transactions to date") @Valid @RequestParam(value = "dateTo", required = false) String dateTo
,@ApiParam(value = "transactions from date") @Valid @RequestParam(value = "dateFrom", required = false) String dateFrom
,@ApiParam(value = "The number of items to skip before starting to collect the result set") @Valid @RequestParam(value = "offset", required = false) Integer offset
,@ApiParam(value = "The numbers of items to return") @Valid @RequestParam(value = "limit", required = false) Integer limit
);


    @ApiOperation(value = "gets all transactions from the given accountId", nickname = "getTransactionsFromAccountId", notes = "Calling this allows you to get all transactions from an account.", response = Transaction.class, responseContainer = "List", authorizations = {
            @Authorization(value = "ApiKeyAuth")    }, tags={ "Transactions", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transactions", response = Transaction.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad request", response = String.class),
            @ApiResponse(code = 401, message = "API key is missing or invalid"),
            @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Accounts/{id}/Transactions",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Transaction>> getTransactionsFromAccountId(@Min(1)@ApiParam(value = "",required=true, allowableValues="") @PathVariable("id") Long id
,@ApiParam(value = "The number of items to skip before starting to collect the result set") @Valid @RequestParam(value = "offset", required = false) Integer offset
,@ApiParam(value = "The numbers of items to return") @Valid @RequestParam(value = "limit", required = false) Integer limit
    );


    @ApiOperation(value = "gets all transactions from the given userId", nickname = "getTransactionsFromUserId", notes = "Calling this allows you to get all transactions from a user.", response = Transaction.class, responseContainer = "List", authorizations = {
            @Authorization(value = "ApiKeyAuth")    }, tags={ "Transactions", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transactions", response = Transaction.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad request", response = String.class),
            @ApiResponse(code = 401, message = "API key is missing or invalid"),
            @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Users/{id}/Transactions",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Transaction>> getTransactionsFromUserId(@Min(1)@ApiParam(value = "",required=true, allowableValues="") @PathVariable("id") Long id
,@ApiParam(value = "The number of items to skip before starting to collect the result set") @Valid @RequestParam(value = "offset", required = false) Integer offset
,@ApiParam(value = "The numbers of items to return") @Valid @RequestParam(value = "limit", required = false) Integer limit
    );

}
