package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ExpenseDao;
import com.example.dto.Expense;

@Service
public class ExpenseServiceImple implements ExpenseService {
	
	@Autowired
	private ExpenseDao expenseDao;

	public void addExpense(Expense expense) {
		expenseDao.insert(expense);
		
	}

	public void removeExpense(int expenseId) {
		expenseDao.delete(expenseId);
	}

	public Expense getExpense(int expenseId) {
		return expenseDao.select(expenseId);
	}

	public void modifyExpense(Expense expense) {
		expenseDao.update(expense);
		
	}

	public List<Expense> expenseList(int userId) {
		
		return expenseDao.selectAll(userId);
	}
	
}
