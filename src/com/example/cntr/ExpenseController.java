package com.example.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.Expense;
import com.example.dto.User;
import com.example.service.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping(value = "/expense_add_form",method = RequestMethod.GET)
	public String expenseAddForm(ModelMap model) {
		model.put("expense", new Expense());
		return "expense_add_form";
	}
	
	@RequestMapping(value = "/expense_add",method = RequestMethod.POST)
	public String expenseAdd(Expense expense,ModelMap model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		expense.setUser(user);
		expenseService.addExpense(expense);
		model.put("expense", new Expense());
		return "expense_add_form";
	}
	
	@RequestMapping(value = "/expense_list",method = RequestMethod.GET)
	public String expenseList(ModelMap model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		List<Expense> expList = expenseService.expenseList(user.getUserId());
		model.put("list", expList);
		return "expense_list";
	}
	
	@RequestMapping(value = "/expense_delete",method = RequestMethod.GET)
	public String expenseDelete(@RequestParam int expenseId, ModelMap model,HttpSession session) {
		expenseService.removeExpense(expenseId);
		User user = (User)session.getAttribute("user");
		
		List<Expense> expList = expenseService.expenseList(user.getUserId());
		model.put("list", expList);
		return "expense_list";
	}
	
	@RequestMapping(value = "/expense_update_form",method = RequestMethod.GET)
	public String expenseUpdateForm(@RequestParam int expenseId, ModelMap model) {
		Expense expense = expenseService.getExpense(expenseId);
		model.put("expense", expense);
		return "expense_update_form";
	}
	
	@RequestMapping(value = "/expense_update",method = RequestMethod.POST)
	public String expenseUpdate(Expense expense, ModelMap model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		expense.setUser(user);
		expenseService.modifyExpense(expense);
		
		
		List<Expense> expList = expenseService.expenseList(user.getUserId());
		model.put("list", expList);
		return "expense_list";
	}
	
	
}
