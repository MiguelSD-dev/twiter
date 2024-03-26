package com.ceica.twiter.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="fav")
public class Fav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Integer twit_id;
    private Integer user_id;

    public Fav() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTwit_id() {
        return twit_id;
    }

    public void setTwit_id(Integer twit_id) {
        this.twit_id = twit_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Fav{" +
                "id=" + id +
                ", date=" + date +
                ", twit_id=" + twit_id +
                ", user_id=" + user_id +
                '}';
    }
}
