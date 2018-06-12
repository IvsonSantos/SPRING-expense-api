package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Expense;

public interface ExpenseService {

	List<Expense> findAll();

	List<Expense> findByMonthAndYear(String month, int year);

	List<Expense> findByYear(int year);

	void saveOrUpdateExpense(Expense expense);

	void deleteExpense(String id);
}
