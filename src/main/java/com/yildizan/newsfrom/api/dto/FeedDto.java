package com.yildizan.newsfrom.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedDto {

    private Integer id;
    private CategoryDto category;
    private BaseDto publisher;
    private List<NewsDto> newsList;

}
