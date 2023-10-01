package com.yildizan.newsfrom.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {

    private Integer id;
    private String title;
    private String description;
    private String link;
    private String thumbnailUrl;
    private Long publishDate;
    private LocationDto location;

}
