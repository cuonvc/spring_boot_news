package com.example.spring_boot_news.api;

import com.example.spring_boot_news.api.output.NewsOutput;
import com.example.spring_boot_news.dto.NewsDTO;
import com.example.spring_boot_news.entity.NewsEntity;
import com.example.spring_boot_news.service.impl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class NewsAPI {

    @Autowired NewsService newsService;

    @PostMapping("/news")
    public NewsDTO createNews(@RequestBody NewsDTO model) {
        return newsService.save(model);
    }

    @PutMapping("/news/{id}")
    public NewsDTO updateNews(@RequestBody NewsDTO model, @PathVariable("id") Long id) {
        model.setId(id);
        return newsService.save(model);
    }

    @DeleteMapping("/news")
    public void deteleNews(@RequestBody long[] ids) {
        newsService.delete(ids);
    }

    @GetMapping("/news")  //localhost:8081/news?page=...&limit=...
    public NewsOutput showNews(@RequestParam("page") int page,
                               @RequestParam("limit") int limit) {
        NewsOutput result = new NewsOutput();
        result.setCurrentPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        result.setTotalPage((int) Math.ceil((double) (newsService.totalItems()) / limit));
        result.setListResult(newsService.findAll(pageable));
        return result;
    }
}
