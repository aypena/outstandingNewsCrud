package com.sodexo.news.domain.usecase;

import com.sodexo.news.data.gateway.FeaturedNewsFind;
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
class FeaturedNewsFindByTitleUseCaseTest {

    @Mock
    private FeaturedNewsFind featuredNewsFind;
    private FeaturedNewsFindByTitleUseCase featuredNewsFindByTitleUseCase;

    @BeforeEach
    void init (){
        featuredNewsFindByTitleUseCase = new FeaturedNewsFindByTitleUseCase(featuredNewsFind);
    }

    @Test
    void when_use_case_update_featured_is_called_then_new_updated(){
        FeaturedNewsDTO responseDto = new FeaturedNewsDTO (1, "title", "description",
                "summary","2023-10-16");
        String title = "title";

        when(featuredNewsFind.findNewsByTitle(title)).thenReturn(responseDto);
        FeaturedNewsDTO response = featuredNewsFindByTitleUseCase.findByTitle(title);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getTitle(), responseDto.getTitle());
        Assertions.assertEquals(response.getDescription(), responseDto.getDescription());
        Assertions.assertEquals(response.getIdNews(), responseDto.getIdNews());
        Assertions.assertEquals(response.getSummary(), responseDto.getSummary());
        Assertions.assertEquals(response.getDatePublication(), responseDto.getDatePublication());
    }

}