package com.example.dao;

import java.util.List;

import com.example.dto.Expense;

public interface ExpenseDao {
	void insert(Expense expense);
	void delete(int expenseId);
	Expense select(int expenseId);
	void update(Expense expense);
	List<Expense> selectAll(int userId);
}
