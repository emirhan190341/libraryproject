package com.emirhanarici.Library.repository;

import com.emirhanarici.Library.entity.Book;
import com.emirhanarici.Library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> , JpaSpecificationExecutor<Book> {

    Optional<Category> findByName(String name);

}
