package com.uday.ReadFromConfigClient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uday.ReadFromConfigClient.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value="Main Controller", description="This is description for my controller")
public class ClientController {

	@Value("${application.message:default message}")
    private String property;
	
//	@RequestMapping(name = "/getConfig")
//	public String printConfig(){
//		StringBuilder builder=new StringBuilder();		
//		builder.append(" || ");
//		builder.append(property);
//		return  builder.toString();
//	}
	@ApiOperation(value = "View a list of available products", response = Product.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved "),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	        }
	)

	
	@RequestMapping(value = "/getURI", method= RequestMethod.GET, produces = "application/json")
	public String getURLValue(HttpServletRequest httpServletRequest) {
		return httpServletRequest.getHeader("host");
	}
	
	
}
