package io.swagger.api;

import io.swagger.model.Account;
import io.swagger.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-29T09:56:10.359Z[GMT]")
@Controller
public class AccountsApiController implements AccountsApi {

    private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createAccount(@ApiParam(value = ""  )  @Valid @RequestBody Account body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Account> getAccountByIBAN(@ApiParam(value = "the IBAN",required=true) @PathVariable("iban") String iban
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Account>(objectMapper.readValue("{\n  \"balance\" : {\n    \"accountId\" : 10000000001,\n    \"balance\" : 250,\n    \"id\" : 10000000001\n  },\n  \"iban\" : \"NLxxINHO0xxxxxxxxx\",\n  \"active\" : true,\n  \"currency\" : \"EUR\",\n  \"id\" : 10000000001,\n  \"type\" : \"Savings\",\n  \"userId\" : 10000000002\n}", Account.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Account>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Account>> getAllAccounts(@ApiParam(value = "The number of items to skip before starting to collect the result set") @Valid @RequestParam(value = "offset", required = false) Integer offset
,@ApiParam(value = "The numbers of items to return") @Valid @RequestParam(value = "limit", required = false) Integer limit
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Account>>(objectMapper.readValue("[ {\n  \"balance\" : {\n    \"accountId\" : 10000000001,\n    \"balance\" : 250,\n    \"id\" : 10000000001\n  },\n  \"iban\" : \"NLxxINHO0xxxxxxxxx\",\n  \"active\" : true,\n  \"currency\" : \"EUR\",\n  \"id\" : 10000000001,\n  \"type\" : \"Savings\",\n  \"userId\" : 10000000002\n}, {\n  \"balance\" : {\n    \"accountId\" : 10000000001,\n    \"balance\" : 250,\n    \"id\" : 10000000001\n  },\n  \"iban\" : \"NLxxINHO0xxxxxxxxx\",\n  \"active\" : true,\n  \"currency\" : \"EUR\",\n  \"id\" : 10000000001,\n  \"type\" : \"Savings\",\n  \"userId\" : 10000000002\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Account>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Account>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Transaction>> getTransactionsFromAccountId(@Min(1L)@ApiParam(value = "",required=true, allowableValues="") @PathVariable("id") Long id
,@ApiParam(value = "The number of items to skip before starting to collect the result set") @Valid @RequestParam(value = "offset", required = false) Integer offset
,@ApiParam(value = "The numbers of items to return") @Valid @RequestParam(value = "limit", required = false) Integer limit
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Transaction>>(objectMapper.readValue("[ {\n  \"transactionType\" : \"Deposit\",\n  \"accountTo\" : \"NL01INHO0000000001\",\n  \"amount\" : 100,\n  \"userPerformingId\" : 10000000001,\n  \"description\" : \"Money for your boat\",\n  \"id\" : 10000000001,\n  \"accountFrom\" : \"NL01INHO0000000001\",\n  \"timestamp\" : \"2020-04-21T17:32:28Z\"\n}, {\n  \"transactionType\" : \"Deposit\",\n  \"accountTo\" : \"NL01INHO0000000001\",\n  \"amount\" : 100,\n  \"userPerformingId\" : 10000000001,\n  \"description\" : \"Money for your boat\",\n  \"id\" : 10000000001,\n  \"accountFrom\" : \"NL01INHO0000000001\",\n  \"timestamp\" : \"2020-04-21T17:32:28Z\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Transaction>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateAccount(@ApiParam(value = ""  )  @Valid @RequestBody Account body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
