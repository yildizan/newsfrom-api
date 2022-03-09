package com.yildizan.newsfrom.api.mapper;

import com.yildizan.newsfrom.api.dto.*;
import com.yildizan.newsfrom.api.entity.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoMapper {

    CategoryDto toCategoryDto(Category category);

    BaseDto toPublisherDto(Publisher publisher);

    LocationDto toLocationDto(Location location);
    List<LocationDto> toLocationDtos(List<Location> locations);

    FeedDto toFeedDto(Feed feed);
    List<FeedDto> toFeedDtos(List<Feed> feeds);

    @Named(value = "toNewsDto")
    @Mapping(source = "phrase.location", target = "location")
    NewsDto toNewsDto(BaseNews news);

    @IterableMapping(qualifiedByName = "toNewsDto")
    List<NewsDto> toNewsDtos(List<News> news);

    @Mappings(value = {
            @Mapping(source = "feed.category", target = "category"),
            @Mapping(source = "feed.publisher", target = "publisher"),
            @Mapping(source = "phrase.location", target = "location")
    })
    RichNewsDto toRichNewsDto(BaseNews news);

}
