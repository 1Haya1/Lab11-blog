package org.example.lab11.Repository;

import org.example.lab11.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("select c from Category c  where c.id=?1")
    Category findCategoryById(Integer id);

    Category findByName(String name);
}
