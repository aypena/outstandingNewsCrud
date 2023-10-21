package com.sodexo.news.data.repository;

import com.sodexo.news.data.model.FeaturedNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeaturedNewsFindByTitleRepository extends JpaRepository<FeaturedNewsEntity,String> {
    @Query("select f from FeaturedNewsEntity f where f.title = :title")
     FeaturedNewsEntity findByTitle(@Param("title") String title);
}
