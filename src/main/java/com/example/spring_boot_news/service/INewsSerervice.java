package com.example.spring_boot_news.service;

import com.example.spring_boot_news.dto.NewsDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewsSerervice {
    NewsDTO save(NewsDTO newsDTO);
//    NewsDTO update(NewsDTO newsDTO);
    void delete(long[] ids);
    List<NewsDTO> findAll(Pageable pageable);  //get all items in DB
    int totalItems();  //number of items in DB
}
