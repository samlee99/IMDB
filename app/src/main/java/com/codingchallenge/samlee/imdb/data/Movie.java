package com.codingchallenge.samlee.imdb.data;

import com.codingchallenge.samlee.imdb.utils.ConvertUtil;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sam on 3/4/2018.
 */

public class Movie implements Serializable {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("originalTitle")
    @Expose
    private String originalTitle;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("directors")
    @Expose
    private List<Director> directors = null;
    @SerializedName("writers")
    @Expose
    private List<Writer> writers = null;
    @SerializedName("runtime")
    @Expose
    private String runtime;
    @SerializedName("urlPoster")
    @Expose
    private String urlPoster;
    @SerializedName("countries")
    @Expose
    private List<String> countries = null;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("simplePlot")
    @Expose
    private String simplePlot;
    @SerializedName("idIMDB")
    @Expose
    private String idIMDB;
    @SerializedName("urlIMDB")
    @Expose
    private String urlIMDB;
    @SerializedName("rated")
    @Expose
    private String rated;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("votes")
    @Expose
    private String votes;
    @SerializedName("metascore")
    @Expose
    private String metascore;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public String getRuntime() {
        return ConvertUtil.convertMinutesToHrMin(runtime);
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public void setUrlPoster(String urlPoster) {
        this.urlPoster = urlPoster;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getSimplePlot() {
        return simplePlot;
    }

    public void setSimplePlot(String simplePlot) {
        this.simplePlot = simplePlot;
    }

    public String getIdIMDB() {
        return idIMDB;
    }

    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
    }

    public String getUrlIMDB() {
        return urlIMDB;
    }

    public void setUrlIMDB(String urlIMDB) {
        this.urlIMDB = urlIMDB;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }
}
