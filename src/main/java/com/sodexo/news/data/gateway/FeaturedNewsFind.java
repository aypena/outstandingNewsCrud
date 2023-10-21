package com.sodexo.news.data.gateway;

import com.sodexo.news.domain.model.FeaturedNewsDTO;

import java.util.List;

public interface FeaturedNewsFind {
    List<FeaturedNewsDTO> findNewsAll();
    FeaturedNewsDTO findNewsByTitle(String title);
}
