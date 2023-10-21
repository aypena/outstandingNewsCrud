package com.sodexo.news.data.gateway;

import com.sodexo.news.data.repository.FeaturedNewsRepository;
import com.sodexo.news.domain.model.ResponseDto;
import com.sodexo.news.domain.usecase.FeaturedNewsDeleteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeaturedNewsDeleteGatewayImplTest {
    @Mock
    private FeaturedNewsRepository featuredNewsRepository;
    private FeaturedNewsDeleteGatewayImpl featuredNewsDeleteGateway;

    @BeforeEach
    void init (){
        featuredNewsDeleteGateway = new FeaturedNewsDeleteGatewayImpl(featuredNewsRepository);
    }

    @Test
    void when_gateway_delete_featured_is_called_then_new_deleted(){
        ResponseDto responseDto  = new ResponseDto ("01", "News deleted successfully");

        ResponseDto response = featuredNewsDeleteGateway.deleteNewsById(1);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getCode(), responseDto.getCode());
        Assertions.assertEquals(response.getDescription(), responseDto.getDescription());
    }


}