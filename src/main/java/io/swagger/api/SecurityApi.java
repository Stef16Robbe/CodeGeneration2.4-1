/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.SessionToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-30T13:49:21.820Z[GMT]")
@Api(value = "Security", description = "the Security API")
public interface SecurityApi {

    @ApiOperation(value = "Logout", nickname = "logout", notes = "delete the sessionToken so the user is logged out.", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Security", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucessfully logged out"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Logout",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<String> logout();


    @ApiOperation(value = "Login", nickname = "login", notes = "Get api token from user login request", tags={ "Security", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucessfully logged in"),
            @ApiResponse(code = 400, message = "bad request", response = String.class),
            @ApiResponse(code = 401, message = "API key is missing or invalid"),
            @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Login",
            produces = { "application/json" },
            consumes = { "application/x-www-form-urlencoded" },
            method = RequestMethod.POST)
    ResponseEntity<String> login(@ApiParam(value = "") @RequestParam(value="username", required=false)  String username
            ,@ApiParam(value = "") @RequestParam(value="password", required=false)  String password
    );

    @ApiOperation(value = "Get session token by auth key", nickname = "getSessionTokenByAuthKey", notes = "Calling this allows you to fetch a user from a given ID", response = SessionToken.class, authorizations = {
            @Authorization(value = "ApiKeyAuth")    }, tags={ "Security", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "requested Auth Key", response = SessionToken.class),
            @ApiResponse(code = 400, message = "bad request", response = String.class),
            @ApiResponse(code = 401, message = "API key is missing or invalid"),
            @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/SessionToken/{APIkey}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<SessionToken> getSessionTokenByAuthKey(@ApiParam(value = "",required=true, allowableValues="") @PathVariable("APIkey") String key
    );


}
