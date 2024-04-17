package com.nadaabuissa.Inventory_Management_System_Rest_APIs.service.impl;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.Transaction;
import com.nadaabuissa.Inventory_Management_System_Rest_APIs.repository.TransactionRepository;
import com.nadaabuissa.Inventory_Management_System_Rest_APIs.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
        if (existingTransaction != null) {
            existingTransaction.setUser(transaction.getUser());
            existingTransaction.setItem(transaction.getItem());
            existingTransaction.setQuantity(transaction.getQuantity());
            existingTransaction.setDate(transaction.getDate());
            existingTransaction.setAddress(transaction.getAddress());
            return transactionRepository.save(existingTransaction);
        }
        return null;
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}