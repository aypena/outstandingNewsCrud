package com.sodexo.news.data.gateway;

import com.sodexo.news.domain.model.FeaturedNewsDTO;
import com.sodexo.news.domain.model.ResponseDto;

public interface FeaturedNewsSave {
    ResponseDto saveNews(FeaturedNewsDTO featuredNewsDTO );
    ResponseDto modifyNewsById(Integer id,FeaturedNewsDTO featuredNews );

}
