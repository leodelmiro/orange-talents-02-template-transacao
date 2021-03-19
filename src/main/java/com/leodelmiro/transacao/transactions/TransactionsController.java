package com.leodelmiro.transacao.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    @Autowired
    private TransactionRepository repository;

    @RequestMapping("/{cardId}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findLasts10TransactionsByCardId(@PathVariable String cardId) {
        if (cardId == null || !repository.existsByCardId(cardId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão informado não existe!");
        }

        List<Transaction> transactions = repository.findTop10ByCardIdOrderByCreatedAtDesc(cardId);

        return ResponseEntity.ok().body(transactions);
    }
}
