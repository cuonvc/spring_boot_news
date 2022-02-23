package com.example.spring_boot_news.repository;

import com.example.spring_boot_news.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    CategoryEntity findOneByCode(String code);
}
