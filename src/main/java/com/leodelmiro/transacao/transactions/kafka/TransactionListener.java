package com.leodelmiro.transacao.transactions.kafka;

import com.leodelmiro.transacao.transactions.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class TransactionListener {
    private static final Logger logger = LoggerFactory.getLogger(TransactionListener.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listener(TransactionMessage response) {
        logger.info("Mensagem recebida!");
        Transaction transaction = response.toModel();
        entityManager.merge(transaction);
        logger.info("Mensagem salva!");
    }
}
