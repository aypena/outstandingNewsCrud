package com.sodexo.news.presentation.controller;

import com.sodexo.news.domain.model.FeaturedNewsDTO;
import com.sodexo.news.domain.model.ResponseDto;
import com.sodexo.news.domain.usecase.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeaturedNewsControllerTest {

    @Mock
    private FeaturedNewsSaveUseCase FeaturedNewsSaveUseCase;
    @Mock
    private FeaturedNewsModifyUseCase featuredNewsModifyUseCase;
    @Mock
    private FeaturedNewsDeleteUseCase featuredNewsDeleteUseCase;
    @Mock
    private FeaturedNewsFindAllUseCase featuredNewsFindAllUseCase;
    @Mock
    private FeaturedNewsFindByTitleUseCase featuredNewsFindByTitleUseCase;
    private FeaturedNewsController featuredNewsController;

    @BeforeEach
    void init (){
        featuredNewsController = new FeaturedNewsController(
                FeaturedNewsSaveUseCase,
                featuredNewsModifyUseCase,
                featuredNewsDeleteUseCase,
                featuredNewsFindAllUseCase,
                featuredNewsFindByTitleUseCase);
    }

    @Test
    void test_news_save (){
        FeaturedNewsDTO request  = new FeaturedNewsDTO();
        ResponseDto responseDto  = new ResponseDto ("01", "saved");
        when(FeaturedNewsSaveUseCase.execute(request)).thenReturn(responseDto);

        ResponseEntity response = featuredNewsController.saveNews(request);

        ResponseDto responseBody = (ResponseDto) response.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(responseBody.getCode(), responseDto.getCode());
        Assertions.assertEquals(responseBody.getDescription(), responseDto.getDescription());
    }

    @Test
    void test_news_update () {
        FeaturedNewsDTO request = new FeaturedNewsDTO();
        ResponseDto responseDto = new ResponseDto("01", "updated");
        when(featuredNewsModifyUseCase.modifyNews(1, request)).thenReturn(responseDto);

        ResponseEntity response = featuredNewsController.modifyNewById(1, request);

        ResponseDto responseBody = (ResponseDto) response.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(responseBody.getCode(), responseDto.getCode());
        Assertions.assertEquals(responseBody.getDescription(), responseDto.getDescription());
    }

    @Test
    void test_news_delete () {
        ResponseDto responseDto = new ResponseDto("01", "deleted");
        when(featuredNewsDeleteUseCase.deleteNewsById(1)).thenReturn(responseDto);

        ResponseEntity response = featuredNewsController.deleteNewsById(1);

        ResponseDto responseBody = (ResponseDto) response.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(responseBody.getCode(), responseDto.getCode());
        Assertions.assertEquals(responseBody.getDescription(), responseDto.getDescription());
    }

    @Test
    void test_find_news_by_title () {
        String title = "title";
        FeaturedNewsDTO responseDto = new FeaturedNewsDTO (1, "title", "description",
                "summary","2023-10-16");
        when(featuredNewsFindByTitleUseCase.findByTitle(title)).thenReturn(responseDto);

        ResponseEntity response = featuredNewsController.findNewByTitle(title);

        FeaturedNewsDTO responseBody = (FeaturedNewsDTO) response.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(responseBody.getDescription(), responseDto.getDescription());
        Assertions.assertEquals(responseBody.getTitle(), responseDto.getTitle());
        Assertions.assertEquals(responseBody.getIdNews(), responseDto.getIdNews());
        Assertions.assertEquals(responseBody.getSummary(), responseDto.getSummary());
        Assertions.assertEquals(responseBody.getDatePublication(), responseDto.getDatePublication());
    }

    @Test
    void test_find_all_news () {
        FeaturedNewsDTO responseDto = new FeaturedNewsDTO (1, "title", "description",
                "summary","2023-10-16");

        List<FeaturedNewsDTO> listResponse = new ArrayList<FeaturedNewsDTO>();
        listResponse.add(responseDto);

        when(featuredNewsFindAllUseCase.findAllNews()).thenReturn(listResponse);

        ResponseEntity response = featuredNewsController.findAllNews();

        List<FeaturedNewsDTO> responseBody = (List<FeaturedNewsDTO>) response.getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(responseBody.size(), listResponse.size());
    }

}