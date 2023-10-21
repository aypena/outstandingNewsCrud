package com.sodexo.news.data.gateway;

import com.sodexo.news.data.model.FeaturedNewsEntity;
import com.sodexo.news.data.repository.FeaturedNewsRepository;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import com.sodexo.news.domain.model.ResponseDto;
import com.sodexo.news.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class FeaturedNewsSaveGatewayImpl implements FeaturedNewsSave {

    private final FeaturedNewsRepository featuredNewsRepository;

    @Override
    public ResponseDto saveNews(FeaturedNewsDTO featuredNewsDto) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(featuredNewsDto.getDatePublication(), format);

        FeaturedNewsEntity featuredNewsEntity = new FeaturedNewsEntity(
                featuredNewsDto.getTitle(),
                featuredNewsDto.getDescription(),
                featuredNewsDto.getSummary(),
                date);
        featuredNewsRepository.save(featuredNewsEntity);

        return new ResponseDto(Constants.SUCCESS_CODE,Constants.SAVED_MESSAGE);
    }


    @Override
    public ResponseDto modifyNewsById(Integer idNews, FeaturedNewsDTO featuredNews) {
        try {
            FeaturedNewsEntity findNewById = featuredNewsRepository.findById(idNews).get();
            findNewById.setDescription(featuredNews.getDescription());
            findNewById.setTitle(featuredNews.getTitle());
            featuredNewsRepository.save(findNewById);
            return new ResponseDto(Constants.SUCCESS_CODE, Constants.UPDATE_MESSAGE);
        }
        catch (NoSuchElementException exception){
            throw exception;
        }
    }
}
