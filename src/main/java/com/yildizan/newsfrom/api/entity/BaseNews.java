package com.yildizan.newsfrom.api.entity;

import com.yildizan.newsfrom.api.utility.TimeConverter;

import java.util.Objects;

import jakarta.persistence.Convert;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseNews {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    private Feed feed;

    private String title;
    private String description;
    private String link;
    private String thumbnailUrl;

    @Convert(converter = TimeConverter.class)
    private Long publishDate;

    private String place;
    private Double latitude;
    private Double longitude;

    public boolean isLocated() {
        return Objects.nonNull(place);
    }

    public boolean isNotLocated() {
        return !isLocated();
    }

}
