package com.example.financetracker.service;

import com.example.financetracker.model.Category;
import com.example.financetracker.model.Expense;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ExpenseService {
    private final List<Expense> expenses = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Expense addExpense(Expense expense) {
        expense.setId(idGenerator.incrementAndGet());
        expenses.add(expense);
        return expense;
    }


    public List<Expense> getAllExpenses(Optional<Category> categoryFilter) {
        return categoryFilter
                .map(category -> expenses.stream()
                    .filter(exp -> exp.getCategory() == category)
                    .collect(Collectors.toList()))
                .orElse(new ArrayList<>(expenses));
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenses.stream().filter(exp -> exp.getId().equals(id)).findFirst();
    }

    public Optional<Expense> updateExpense(Long id, Expense updatedExpense) {
        return getExpenseById(id).map(existing -> {
            existing.setDescription(updatedExpense.getDescription());
            existing.setAmount(updatedExpense.getAmount());
            existing.setCategory(updatedExpense.getCategory());
            existing.setDate(updatedExpense.getDate());
            return existing;
        });
    }

    public boolean deleteExpense(Long id) {
        return expenses.removeIf(exp -> exp.getId().equals(id));
    }

    public Map<Category, Double> getSummaryByCategory() {
        return expenses.stream()
                .collect(Collectors.groupingBy(
                        Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)
                ));
    }
}
