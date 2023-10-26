package com.sodexo.news.data.repository;

import com.sodexo.news.data.model.FeaturedNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path ="FeaturedNewsEntitys", collectionResourceRel ="FeaturedNewsEntitys" )
public interface FeaturedNewsRepository extends JpaRepository<FeaturedNewsEntity,Integer> {


}
