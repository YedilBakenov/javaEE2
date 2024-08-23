package entity;

import java.sql.Timestamp;

public class Comment {
    private int id;
    private String text;
    private Timestamp date;
    private User user;

    private News news;

    public Comment() {
    }

    public Comment(int id, String text, Timestamp date, User user, News news) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.user = user;
        this.news = news;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
