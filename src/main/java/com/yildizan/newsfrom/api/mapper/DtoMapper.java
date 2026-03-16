package com.yildizan.newsfrom.api.mapper;

import com.yildizan.newsfrom.api.dto.*;
import com.yildizan.newsfrom.api.entity.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoMapper {

    CategoryDto toCategoryDto(Category category);

    BaseDto toPublisherDto(Publisher publisher);

    FeedDto toFeedDto(Feed feed);
    List<FeedDto> toFeedDtos(List<Feed> feeds);

    @Named(value = "toNewsDto")
    NewsDto toNewsDto(BaseNews news);

    @IterableMapping(qualifiedByName = "toNewsDto")
    List<NewsDto> toNewsDtos(List<News> news);

    @Mappings(value = {
            @Mapping(source = "feed.category", target = "category"),
            @Mapping(source = "feed.publisher", target = "publisher")
    })
    RichNewsDto toRichNewsDto(BaseNews news);

}
