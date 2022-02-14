package com.financy.financyapp.repositories;

import com.financy.financyapp.models.Category;
import com.financy.financyapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByUser (User user);
}
