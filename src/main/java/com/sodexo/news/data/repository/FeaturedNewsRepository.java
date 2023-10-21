package com.sodexo.news.data.repository;

import com.sodexo.news.data.model.FeaturedNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeaturedNewsRepository extends JpaRepository<FeaturedNewsEntity,Integer> {


}
