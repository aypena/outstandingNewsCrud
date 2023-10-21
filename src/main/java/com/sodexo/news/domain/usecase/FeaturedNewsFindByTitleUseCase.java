package com.sodexo.news.domain.usecase;

import com.sodexo.news.data.gateway.FeaturedNewsFind;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import org.springframework.stereotype.Service;

@Service
public class FeaturedNewsFindByTitleUseCase {
    private final FeaturedNewsFind featuredNewsFind;

    public FeaturedNewsFindByTitleUseCase(FeaturedNewsFind featuredNewsFind) {
        this.featuredNewsFind = featuredNewsFind;
    }

    public FeaturedNewsDTO findByTitle(String title) {
        return featuredNewsFind.findNewsByTitle(title);
    }
}
