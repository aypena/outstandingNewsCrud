package com.sodexo.news.domain.usecase;

import com.sodexo.news.data.gateway.FeaturedNewsSave;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import com.sodexo.news.domain.model.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class FeaturedNewsSaveUseCase {
    private final FeaturedNewsSave featuredNewsSave;

    public FeaturedNewsSaveUseCase(FeaturedNewsSave featuredNewsSave) {
        this.featuredNewsSave = featuredNewsSave;
    }

    public ResponseDto execute(FeaturedNewsDTO featuredNewsdto){
        return featuredNewsSave.saveNews(featuredNewsdto);
    }
}
