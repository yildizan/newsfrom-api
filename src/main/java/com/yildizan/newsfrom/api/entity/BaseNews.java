package com.yildizan.newsfrom.api.entity;

import com.yildizan.newsfrom.api.utility.TimeConverter;

import java.util.Objects;

import javax.persistence.Convert;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseNews {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @ManyToOne
    @JoinColumn(name = "phrase_id")
    private Phrase phrase;

    private String title;
    private String description;
    private String link;
    private String thumbnailUrl;

    @Convert(converter = TimeConverter.class)
    private Long publishDate;

    public boolean isLocated() {
        return Objects.nonNull(phrase) && Objects.nonNull(phrase.getLocation());
    }

    public boolean isNotLocated() {
        return !isLocated();
    }

}
