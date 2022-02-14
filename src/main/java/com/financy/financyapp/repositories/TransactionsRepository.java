package com.financy.financyapp.repositories;

import com.financy.financyapp.enums.Type;
import com.financy.financyapp.models.Transaction;
import com.financy.financyapp.models.User;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Long>{

    List<Transaction> findAllByTitleContainingIgnoreCaseAndUser(String title, User user);
    Iterable<Transaction> findAllByUserOrderByDateDesc(User user);
    List<Transaction> findAllByDateBetweenAndTypeAndUser(LocalDate minusMonths, LocalDate now, Type type, User user);
    Iterable<Transaction> findAllByTypeAndUser(Type type, User user);
}
