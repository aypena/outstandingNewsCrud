package com.sodexo.news.domain.usecase;

import com.sodexo.news.data.gateway.FeaturedNewsDelete;
import com.sodexo.news.domain.model.ResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeaturedNewsDeleteUseCaseTest {
    @Mock
    private FeaturedNewsDelete featuredNewsDelete;
    private FeaturedNewsDeleteUseCase featuredNewsDeleteUseCase;

    @BeforeEach
    void init (){
        featuredNewsDeleteUseCase = new FeaturedNewsDeleteUseCase(featuredNewsDelete);
    }

    @Test
    void when_use_case_delete_featured_is_called_then_new_deleted(){
        ResponseDto responseDto  = new ResponseDto ("01", "deleted");

        when(featuredNewsDelete.deleteNewsById(1)).thenReturn(responseDto);
        ResponseDto response = featuredNewsDeleteUseCase.deleteNewsById(1);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getCode(), responseDto.getCode());
        Assertions.assertEquals(response.getDescription(), responseDto.getDescription());
    }

}