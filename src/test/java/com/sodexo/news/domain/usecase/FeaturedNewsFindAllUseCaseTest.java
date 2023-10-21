package com.sodexo.news.domain.usecase;

import com.sodexo.news.data.gateway.FeaturedNewsFind;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeaturedNewsFindAllUseCaseTest {

    @Mock
    private FeaturedNewsFind featuredNewsFind;
    private FeaturedNewsFindAllUseCase featuredNewsFindAllUseCase;

    @BeforeEach
    void init (){
        featuredNewsFindAllUseCase = new FeaturedNewsFindAllUseCase(featuredNewsFind);
    }

    @Test
    void when_use_case_find_All_featured_is_called_then_list_news() {
        FeaturedNewsDTO responseDto = new FeaturedNewsDTO(1, "title", "description",
                "summary", "2023-10-16");
        List<FeaturedNewsDTO> listResponse = new ArrayList<FeaturedNewsDTO>();
        listResponse.add(responseDto);

        when(featuredNewsFind.findNewsAll()).thenReturn(listResponse);
        List<FeaturedNewsDTO> response = featuredNewsFindAllUseCase.findAllNews();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.size(), listResponse.size());
    }
}