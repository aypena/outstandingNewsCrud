package com.sodexo.news.presentation.controller;

import com.sodexo.news.domain.model.FeaturedNewsDTO;
import com.sodexo.news.domain.model.ResponseDto;
import com.sodexo.news.domain.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/news")
public class FeaturedNewsController {
    private FeaturedNewsSaveUseCase FeaturedNewsSaveUseCase;
    private FeaturedNewsModifyUseCase featuredNewsModifyUseCase;
    private FeaturedNewsDeleteUseCase featuredNewsDeleteUseCase;
    private FeaturedNewsFindAllUseCase featuredNewsFindAllUseCase;
    private FeaturedNewsFindByTitleUseCase featuredNewsFindByTitleUseCase;

    public FeaturedNewsController(FeaturedNewsSaveUseCase featuredNewsSaveUseCase,
                                  FeaturedNewsModifyUseCase featuredNewsModifyUseCase,
                                  FeaturedNewsDeleteUseCase featuredNewsDeleteUseCase,
                                  FeaturedNewsFindAllUseCase featuredNewsFindAllUseCase,
                                  FeaturedNewsFindByTitleUseCase featuredNewsFindByTitleUseCase) {
       this.FeaturedNewsSaveUseCase = featuredNewsSaveUseCase;
        this.featuredNewsModifyUseCase = featuredNewsModifyUseCase;
        this.featuredNewsDeleteUseCase = featuredNewsDeleteUseCase;
        this.featuredNewsFindAllUseCase = featuredNewsFindAllUseCase;
        this.featuredNewsFindByTitleUseCase = featuredNewsFindByTitleUseCase;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveNews(@RequestBody FeaturedNewsDTO featuredNewsdto){
        return  new ResponseEntity<ResponseDto>(FeaturedNewsSaveUseCase.execute(featuredNewsdto), HttpStatus.CREATED);
    }
    @GetMapping("/title/{title}")
    public  ResponseEntity findNewByTitle (@PathVariable("title") String title ){
        return new ResponseEntity<>(featuredNewsFindByTitleUseCase.findByTitle(title),HttpStatus.OK);
    }
    @GetMapping("/all")
    public  ResponseEntity findAllNews (){
        return new ResponseEntity (featuredNewsFindAllUseCase.findAllNews(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity  modifyNewById(@PathVariable("id") Integer idNews,@RequestBody FeaturedNewsDTO featuredNewsdto){
        return new ResponseEntity(featuredNewsModifyUseCase.modifyNews(idNews,featuredNewsdto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteNewsById(@PathVariable("id") Integer idNews){
        return new ResponseEntity(featuredNewsDeleteUseCase.deleteNewsById(idNews),HttpStatus.OK);
    }

}
