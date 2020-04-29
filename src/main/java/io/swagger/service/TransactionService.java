package io.swagger.service;

import io.swagger.dao.TransactionRepository;
import io.swagger.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    public List<Transaction> getAllTransactionsWithQuery(int offset, int limit) {
        Pageable pageable = new PageRequest(offset,limit);
        Page<Transaction> page = transactionRepository.findAll(pageable);
        return page.getContent();
    }

    public List<Transaction> getAllTransactionsBetweenDates(LocalDate dateFrom, LocalDate dateTo) {
        return (List<Transaction>) transactionRepository.findTransactionsByTimestampBetween(dateFrom, dateTo);
    }

    public List<Transaction> getAllTransactionsByAccountId(long id) {
        return (List<Transaction>) transactionRepository.getTransactionsByAccountId(id);
    }
}
