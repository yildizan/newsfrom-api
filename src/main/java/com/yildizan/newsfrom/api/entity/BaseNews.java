package com.yildizan.newsfrom.api.entity;

import com.yildizan.newsfrom.api.utility.TimeConverter;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseNews {

    @Id
    private Integer id;

    private String title;
    private String description;
    private String link;
    private String thumbnailUrl;
    private Integer versionNo;

    @Convert(converter = TimeConverter.class)
    private Long publishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "top_phrase_id")
    private Phrase phrase;

    public boolean isLocated() {
        return phrase != null && phrase.getLocation() != null;
    }

    public boolean isNotLocated() {
        return !isLocated();
    }

}
