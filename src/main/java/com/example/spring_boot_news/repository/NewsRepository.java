package com.example.spring_boot_news.repository;

import com.example.spring_boot_news.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

}
