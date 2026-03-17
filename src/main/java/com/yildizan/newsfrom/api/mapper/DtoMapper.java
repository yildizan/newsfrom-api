package com.yildizan.newsfrom.api.mapper;

import com.yildizan.newsfrom.api.dto.*;
import com.yildizan.newsfrom.api.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoMapper {

    FeedDto toFeedDto(Feed feed);
    List<FeedDto> toFeedDtos(List<Feed> feeds);

    @Mappings(value = {
            @Mapping(source = "feed.category", target = "category"),
            @Mapping(source = "feed.publisher", target = "publisher")
    })
    RichNewsDto toRichNewsDto(BaseNews news);

}
