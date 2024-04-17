package com.nadaabuissa.Inventory_Management_System_Rest_APIs.service;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long id);

    Transaction createTransaction(Transaction transaction);

    Transaction updateTransaction(Long id, Transaction transaction);

    void deleteTransaction(Long id);
}