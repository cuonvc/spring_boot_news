package com.example.spring_boot_news.converter;

import com.example.spring_boot_news.dto.NewsDTO;
import com.example.spring_boot_news.entity.NewsEntity;
import org.springframework.stereotype.Component;

@Component
public class NewsConverter {
    //convert DTO to Entity
    public NewsEntity toEntity(NewsDTO dto) {
        NewsEntity entity = new NewsEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }

    //covert Entity to DTO
    public NewsDTO toDTO(NewsEntity entity) {
        NewsDTO dto = new NewsDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setShortDescription(entity.getShortDescription());
        dto.setThumbnail(entity.getThumbnail());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    //convert DTO to Entity but this Entity was exist (overwrite)
    public NewsEntity toEntity(NewsDTO dto, NewsEntity entity) {
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }
}
