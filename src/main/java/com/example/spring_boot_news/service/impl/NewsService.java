package com.example.spring_boot_news.service.impl;

import com.example.spring_boot_news.converter.NewsConverter;
import com.example.spring_boot_news.dto.NewsDTO;
import com.example.spring_boot_news.entity.CategoryEntity;
import com.example.spring_boot_news.entity.NewsEntity;
import com.example.spring_boot_news.repository.CategoryRepository;
import com.example.spring_boot_news.repository.NewsRepository;
import com.example.spring_boot_news.service.INewsSerervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService implements INewsSerervice {

    @Autowired  //dependency injection
    private NewsRepository newsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewsConverter newsConverter;

    @Override
    //save() function in JPA can be SAVE or UPDATE
    public NewsDTO save(NewsDTO newsDTO) {
        NewsEntity newsEntity = new NewsEntity();
        if (newsDTO.getId() != null) {  //is exist > UPDATE
            NewsEntity oldNewsEntity = newsRepository.getById(newsDTO.getId());  //error - can not be apply findById() or findOne()
            newsEntity = newsConverter.toEntity(newsDTO, oldNewsEntity);
        } else {  //is not exist -> SAVE
            newsEntity = newsConverter.toEntity(newsDTO);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode()); //find one category by CategoryCode
        newsEntity.setCategory(categoryEntity);
        newsEntity = newsRepository.save(newsEntity);  //save to repo
        return newsConverter.toDTO(newsEntity);  //return DTO
    }

//    @Override
//    public NewsDTO update(NewsDTO newsDTO) {
//
//
//        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
//        newsEntity.setCategory(categoryEntity);
//        newsEntity = newsRepository.save(newsEntity);  //update in repo
//        return newsConverter.toDTO(newsEntity);
//    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            newsRepository.deleteById(id);
        }
    }

    @Override
    public List<NewsDTO> findAll(Pageable pageable) {
        List<NewsDTO> newsList = new ArrayList<>();
        List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
        for (NewsEntity item : entities) {
            NewsDTO newsDTO = newsConverter.toDTO(item);
            newsList.add(newsDTO);
        }
        return newsList;
    }

    @Override
    public int totalItems() {
        return (int) newsRepository.count();
    }
}
