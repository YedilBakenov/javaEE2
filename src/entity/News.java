package entity;

import java.sql.Timestamp;

public class News {

    private int id;

    private String content;

    private User user;

    private Timestamp date;

    public News() {
    }

    public News(int id, String content, User user, Timestamp date) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
