package com.sodexo.news.domain.usecase;

import com.sodexo.news.data.gateway.FeaturedNewsDelete;
import com.sodexo.news.domain.model.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class FeaturedNewsDeleteUseCase {
private final FeaturedNewsDelete featuredNewsDelete;
    public FeaturedNewsDeleteUseCase(FeaturedNewsDelete featuredNewsDelete) {
        this.featuredNewsDelete = featuredNewsDelete;
    }

    public ResponseDto deleteNewsById (Integer id){
        return featuredNewsDelete.deleteNewsById(id);
    }
}
