package com.example.service;

import java.util.List;

import com.example.dto.Expense;

public interface ExpenseService {
	void addExpense(Expense expense);
	void removeExpense(int expenseId);
	Expense getExpense(int expenseId);
	void modifyExpense(Expense expense);
	List<Expense> expenseList(int userId);
}
