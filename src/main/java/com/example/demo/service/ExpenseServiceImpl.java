package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Expense;
import com.example.demo.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository repo;

	@Override
	public List<Expense> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Expense> findByMonthAndYear(String month, int year) {
		return repo.findByMonthAndYear(month, year);
	}

	@Override
	public void saveOrUpdateExpense(Expense expense) {
		repo.save(expense);
	}

	@Override
	public void deleteExpense(String id) {
		repo.deleteById(id);		
	}

	@Override
	public List<Expense> findByYear(int year) {
		return repo.findByYear(year);
	}

}
