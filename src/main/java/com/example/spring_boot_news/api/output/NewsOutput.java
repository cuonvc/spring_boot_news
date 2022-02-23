package com.example.spring_boot_news.api.output;

import com.example.spring_boot_news.dto.NewsDTO;

import java.util.ArrayList;
import java.util.List;

public class NewsOutput {
    private int currentPage;
    private int totalPage;
    private List<NewsDTO> listResult = new ArrayList<>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<NewsDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<NewsDTO> listResult) {
        this.listResult = listResult;
    }
}
