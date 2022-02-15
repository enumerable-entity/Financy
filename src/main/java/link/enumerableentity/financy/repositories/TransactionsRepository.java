package link.enumerableentity.financy.repositories;

import link.enumerableentity.financy.enums.Type;
import link.enumerableentity.financy.models.Transaction;
import link.enumerableentity.financy.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Long>{

    List<Transaction> findAllByTitleContainingIgnoreCaseAndUser(String title, User user);
    Iterable<Transaction> findAllByUserOrderByDateDesc(User user);
    List<Transaction> findAllByUser(User user, Pageable pageable);
    List<Transaction> findAllByDateBetweenAndTypeAndUser(LocalDate minusMonths, LocalDate now, Type type, User user);
    Iterable<Transaction> findAllByTypeAndUser(Type type, User user);
    List<Transaction> findAllByDateAndTypeAndUser(LocalDate minusDays, Type type, User user);
}
