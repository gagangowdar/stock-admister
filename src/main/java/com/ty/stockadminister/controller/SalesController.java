package com.ty.stockadminister.controller;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ty.stockadminister.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.ty.stockadminister.dto.Sales;
import com.ty.stockadminister.service.SalesService;

@RestController
public class SalesController {

	@Autowired
	SalesService service;
	@PostMapping("sales/stockid/{stockid}/userid/{userid}")
	@ApiOperation("To save the sales")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sales Saved"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Sales>> save(@RequestBody @Valid Sales sales, @PathVariable int stockid,
			@PathVariable String userid) {
		return service.save(sales, stockid, userid);
	}

	@GetMapping("sales")
	@ApiOperation("To Get all the sales") 
	@ApiResponses({ @ApiResponse(code = 200, message = "List of Sales Founds"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<Sales>>> getAll() {
		return service.getAll();

	} 

	@GetMapping("sales/customername/{name}")
	@ApiOperation("To Get all the sales by name")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sales Founds"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Sales>> getByName(@PathVariable String name) {
		return service.getByName(name);
	}

	@GetMapping("sales/{id}")
	@ApiOperation("To Get sales by ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sales Founds"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Sales>> getById(@PathVariable int id) {
		return service.getById(id);
	}


	@PutMapping("sales/{id}/userid/{userid}")
	@ApiOperation("To Update sales")
	@ApiResponses({ @ApiResponse(code = 200, message = "sales Updated"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Sales>> update(@ApiParam("Update for Staff") @PathVariable int id,
			@PathVariable String userid, @RequestBody Sales sales) {
		return service.update(id, userid, sales);
	}

	@GetMapping("salesobject")
	public Sales imSalesObject() {
		return new Sales();
	}

}
