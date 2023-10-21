package com.sodexo.news.domain.usecase;

import com.sodexo.news.data.gateway.FeaturedNewsSave;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import com.sodexo.news.domain.model.ResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeaturedNewsModifyUseCaseTest {

    @Mock
    private FeaturedNewsSave featuredNewsSave;
    private FeaturedNewsModifyUseCase featuredNewsModifyUseCase;

    @BeforeEach
    void init (){
        featuredNewsModifyUseCase = new FeaturedNewsModifyUseCase(featuredNewsSave);
    }

    @Test
    void when_use_case_update_featured_is_called_then_new_updated(){
        ResponseDto responseDto  = new ResponseDto ("01", "updated");
        FeaturedNewsDTO requestDto= new FeaturedNewsDTO();

        when(featuredNewsSave.modifyNewsById(1,requestDto)).thenReturn(responseDto);
        ResponseDto response = featuredNewsModifyUseCase.modifyNews(1,requestDto);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getCode(), responseDto.getCode());
        Assertions.assertEquals(response.getDescription(), responseDto.getDescription());
    }

}