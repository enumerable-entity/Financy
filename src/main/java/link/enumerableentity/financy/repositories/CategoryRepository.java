package link.enumerableentity.financy.repositories;

import link.enumerableentity.financy.models.Category;
import link.enumerableentity.financy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByUser (User user);
}
