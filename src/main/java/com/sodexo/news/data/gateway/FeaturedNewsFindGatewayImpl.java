package com.sodexo.news.data.gateway;

import com.sodexo.news.data.mapper.FeatureEntityToFeatureDTOMapper;
import com.sodexo.news.data.mapper.FeatureListEntityToFeatureListDTOMapper;
import com.sodexo.news.data.model.FeaturedNewsEntity;
import com.sodexo.news.data.repository.FeaturedNewsFindByTitleRepository;
import com.sodexo.news.data.repository.FeaturedNewsRepository;
import com.sodexo.news.domain.model.FeaturedNewsDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FeaturedNewsFindGatewayImpl implements FeaturedNewsFind {

    private final FeaturedNewsRepository featuredNewsRepository;
    private  final FeaturedNewsFindByTitleRepository featuredNewsFindByTitleRepository;

    private FeatureEntityToFeatureDTOMapper featureEntityToFeatureDTOMapper;
    private FeatureListEntityToFeatureListDTOMapper featureListEntityToFeatureListDTOMapper;


    public Optional<FeaturedNewsDTO> findNewsById(Integer idNews) {
        return Optional.ofNullable(
                featureEntityToFeatureDTOMapper.mapperOptional(Optional.ofNullable(featuredNewsRepository.findById(idNews).orElseThrow(() -> {
                    throw new EntityNotFoundException();
                }))));
    }

    @Override
    public FeaturedNewsDTO findNewsByTitle(String title) {
        FeaturedNewsEntity response = featuredNewsFindByTitleRepository.findByTitle(title);
        if (response == null){
            throw new EntityNotFoundException();
        }
        return featureEntityToFeatureDTOMapper.mapper(response);

    }

    @Override
    public List<FeaturedNewsDTO> findNewsAll() {
        return featureListEntityToFeatureListDTOMapper.mapper(featuredNewsRepository.findAll());
    }
}
