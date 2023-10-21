package com.sodexo.news.domain.model;


public class FeaturedNewsDTO {

    private Integer idNews;
    private String title;

    private String description;

    private String summary;

    private String datePublication;

    public FeaturedNewsDTO(Integer idNews, String title, String description, String summary, String datePublication) {
        this.idNews = idNews;
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.datePublication = datePublication;
    }

    public FeaturedNewsDTO() {
    }

    public Integer getIdNews() {
        return idNews;
    }

    public void setIdNews(Integer idNews) {
        this.idNews = idNews;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }


    @Override
    public String toString() {
        return "FeaturedNewsEntity{" +
                "idNews=" + idNews +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", summary='" + summary + '\'' +
                ", datePublication=" + datePublication +
                '}';
    }
}
