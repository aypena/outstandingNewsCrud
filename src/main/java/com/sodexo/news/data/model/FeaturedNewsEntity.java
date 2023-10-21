package com.sodexo.news.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table
public class FeaturedNewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNews;
    @Size(min=2, message = "The title should be 2 characters")
    @Column(nullable = false)
    private String title;
    @Size(min=2, message = "The title should be 10 characters")
    @Column(nullable = false)
    private String description;
    @Size(min=2, message = "The summary should be 20 characters")
    @Column(nullable = false)
    private String summary;
    @Past(message = "The Date should be in Past")
    @Column(nullable = true)
    private LocalDate datePublication;

    public FeaturedNewsEntity( String title, String description, String summary, LocalDate datePublication) {
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.datePublication = datePublication;
    }

    public FeaturedNewsEntity() {
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

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
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
