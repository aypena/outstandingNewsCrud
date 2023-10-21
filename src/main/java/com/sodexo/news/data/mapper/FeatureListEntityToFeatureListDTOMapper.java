package com.sodexo.news.data.mapper;


import com.sodexo.news.data.model.FeaturedNewsEntity;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeatureListEntityToFeatureListDTOMapper {

    public List<FeaturedNewsDTO> mapper (List<FeaturedNewsEntity> listEntity){
       List<FeaturedNewsDTO> listFeaturedNewsDTO  = listEntity.stream().map(news->{
           FeaturedNewsDTO  featuredNewsDTO = new FeaturedNewsDTO();
           featuredNewsDTO.setIdNews(news.getIdNews());
           featuredNewsDTO.setDescription(news.getDescription());
           featuredNewsDTO.setDatePublication(news.getDatePublication().toString());
           featuredNewsDTO.setTitle(news.getTitle());
           featuredNewsDTO.setSummary(news.getSummary());
           return featuredNewsDTO;
       }).collect(Collectors.toList());


        return listFeaturedNewsDTO;
    }
}
