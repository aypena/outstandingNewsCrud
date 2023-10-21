package com.sodexo.news.domain.usecase;

import com.sodexo.news.data.gateway.FeaturedNewsSave;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import com.sodexo.news.domain.model.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class FeaturedNewsModifyUseCase {
    private final FeaturedNewsSave featuredNewsSave;

    public FeaturedNewsModifyUseCase(FeaturedNewsSave featuredNewsSave) {
        this.featuredNewsSave = featuredNewsSave;
    }

    public ResponseDto modifyNews(Integer id, FeaturedNewsDTO featuredNewsDTO){
        return featuredNewsSave.modifyNewsById( id, featuredNewsDTO );
    }
}
