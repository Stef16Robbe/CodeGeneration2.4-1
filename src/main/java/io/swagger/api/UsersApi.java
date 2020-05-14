/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-28T09:19:06.758Z[GMT]")
@Api(value = "Users", description = "the Users API")
public interface UsersApi {

    @ApiOperation(value = "create a new user", nickname = "createUser", notes = "Create a user", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "created user"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Users",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> createUser(@ApiParam(value = ""  )  @Valid @RequestBody User body
);


    @ApiOperation(value = "gets all users", nickname = "getlAllUsers", notes = "Calling this allows you to fetch all users", response = User.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Users", response = User.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<User>> getAllUsers(@ApiParam(value = "get users based on lastname") @Valid @RequestParam(value = "lastname", required = false) String lastname
,@ApiParam(value = "get users based on username") @Valid @RequestParam(value = "username", required = false) String username
,@ApiParam(value = "The number of items to skip before starting to collect the result set") @Valid @RequestParam(value = "offset", required = false) Integer offset
,@ApiParam(value = "The numbers of items to return") @Valid @RequestParam(value = "limit", required = false) Integer limit
);


    @ApiOperation(value = "gets a user from a given ID", nickname = "getUserById", notes = "Calling this allows you to fetch a user from a given ID", response = User.class, authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "requested user", response = User.class),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getUserById(@Min(1)@ApiParam(value = "",required=true, allowableValues="") @PathVariable("id") Long id
);


    @ApiOperation(value = "updates the user", nickname = "updateUser", notes = "update user", authorizations = {
        @Authorization(value = "ApiKeyAuth")    }, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "updated user"),
        @ApiResponse(code = 400, message = "bad request", response = String.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 404, message = "The specified resource was not found", response = String.class) })
    @RequestMapping(value = "/Users",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<String> updateUser(@ApiParam(value = ""  )  @Valid @RequestBody User body
);

}
