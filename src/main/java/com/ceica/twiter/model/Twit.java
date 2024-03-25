package com.ceica.twiter.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="twit")
public class Twit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String twitcol;
    private Integer user_id;
    private Date date;

    public Twit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTwitcol() {
        return twitcol;
    }

    public void setTwitcol(String twitcol) {
        this.twitcol = twitcol;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Twit{" +
                "id=" + id +
                ", twitcol='" + twitcol + '\'' +
                ", user_id=" + user_id +
                ", date=" + date +
                '}';
    }
}
