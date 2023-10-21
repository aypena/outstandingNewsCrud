package com.sodexo.news.data.mapper;

import com.sodexo.news.data.model.FeaturedNewsEntity;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeatureEntityToFeatureDTOMapper {

    public FeaturedNewsDTO mapperOptional (Optional<FeaturedNewsEntity> entity){
        FeaturedNewsDTO featuredNewsDTO = new FeaturedNewsDTO(
                entity.get().getIdNews(),
                entity.get().getTitle(),
                entity.get().getDescription(),
                entity.get().getSummary(),
                entity.get().getDatePublication().toString());
        return featuredNewsDTO;
    }

    public FeaturedNewsDTO mapper (FeaturedNewsEntity entity){
        FeaturedNewsDTO featuredNewsDTO = new FeaturedNewsDTO(
                entity.getIdNews(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getSummary(),
                entity.getDatePublication().toString());
        return featuredNewsDTO;
    }
}
