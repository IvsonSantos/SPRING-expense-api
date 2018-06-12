package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Expense;
import com.example.demo.service.ExpenseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	ExpenseService service;
		
	@GetMapping
	public ResponseEntity<?> getAll() {
		List<Expense> result = service.findAll();
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@GetMapping("/{year}/{month}")
	public ResponseEntity<?> getByMonthYear(@PathVariable("year") int year, @PathVariable("month") String month) {
		List<Expense> result = new ArrayList<>();
		if("All".equals(month)) {
			result = service.findByYear(year);
		} else {
			result = service.findByMonthAndYear(month, year);			
		}
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addorUpdateExpense(@RequestBody Expense expense) {
		service.saveOrUpdateExpense(expense);
		return new ResponseEntity("Expense added succcessfully", HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteExpense(@RequestParam("id") String id) {
		service.deleteExpense(id);
	}
}
