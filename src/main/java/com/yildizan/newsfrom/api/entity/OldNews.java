package com.yildizan.newsfrom.api.entity;

import com.yildizan.newsfrom.api.utility.TimeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OldNews {

    @Id
    private Integer id;

    private Integer feedId;
    private Integer topPhraseId;
    private String title;
    private String description;
    private String link;
    private String thumbnailUrl;
    private Integer versionNo;

    @Convert(converter = TimeConverter.class)
    private Long publishDate;

    @Column(name = "process_time", insertable = false)
    @Convert(converter=TimeConverter.class)
    private Long processTime;

    public OldNews() { processTime = new Date().getTime(); }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFeedId() {
        return feedId;
    }

    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }

    public Integer getTopPhraseId() {
        return topPhraseId;
    }

    public void setTopPhraseId(Integer topPhraseId) {
        this.topPhraseId = topPhraseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public Long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Long publishDate) {
        this.publishDate = publishDate;
    }

    public Long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Long processTime) {
        this.processTime = processTime;
    }

}
