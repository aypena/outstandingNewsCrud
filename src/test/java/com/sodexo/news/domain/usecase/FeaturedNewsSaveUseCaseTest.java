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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeaturedNewsSaveUseCaseTest {
    @Mock
    private FeaturedNewsSave featuredNewsSave;
    private FeaturedNewsSaveUseCase featuredNewsSaveUseCase;

    @BeforeEach
    void init (){
        featuredNewsSaveUseCase = new FeaturedNewsSaveUseCase(featuredNewsSave);
    }

    @Test
    void when_use_case_save_featured_is_called_then_new_saved(){
        ResponseDto responseDto  = new ResponseDto ("01", "saved");
        FeaturedNewsDTO requestDto= new FeaturedNewsDTO();

        when(featuredNewsSave.saveNews(requestDto)).thenReturn(responseDto);
        ResponseDto response = featuredNewsSaveUseCase.execute(requestDto);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getCode(), responseDto.getCode());
        Assertions.assertEquals(response.getDescription(), responseDto.getDescription());
    }

}