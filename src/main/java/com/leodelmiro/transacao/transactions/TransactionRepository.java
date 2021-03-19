package com.leodelmiro.transacao.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    List<Transaction> findTop10ByCardIdOrderByCreatedAtDesc(String cardId);

    boolean existsByCardId(String cardId);
}
