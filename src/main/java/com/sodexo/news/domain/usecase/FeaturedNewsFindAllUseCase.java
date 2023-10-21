package com.sodexo.news.domain.usecase;

import com.sodexo.news.data.gateway.FeaturedNewsFind;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeaturedNewsFindAllUseCase {
   private final FeaturedNewsFind featuredNewsFind;

    public FeaturedNewsFindAllUseCase(FeaturedNewsFind featuredNewsFind) {
        this.featuredNewsFind = featuredNewsFind;
    }

    public List<FeaturedNewsDTO> findAllNews(){
        return featuredNewsFind.findNewsAll();
    }
}
