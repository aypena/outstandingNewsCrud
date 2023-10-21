package com.sodexo.news.data.gateway;

import com.sodexo.news.data.repository.FeaturedNewsRepository;
import com.sodexo.news.domain.model.ResponseDto;
import com.sodexo.news.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeaturedNewsDeleteGatewayImpl implements FeaturedNewsDelete {

    private final FeaturedNewsRepository featuredNewsRepository;
    @Override
    public ResponseDto deleteNewsById(Integer idNews) {
        try {
            featuredNewsRepository.deleteById(idNews);
            return new ResponseDto(Constants.SUCCESS_CODE, Constants.DELETE_MESSAGE);
        } catch (Exception e) {
            throw e;
        }
    }
}