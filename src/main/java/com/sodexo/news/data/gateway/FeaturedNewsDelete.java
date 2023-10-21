package com.sodexo.news.data.gateway;

import com.sodexo.news.domain.model.ResponseDto;

public interface FeaturedNewsDelete {
    ResponseDto deleteNewsById(Integer id);
}
