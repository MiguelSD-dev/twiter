package com.ceica.twiter.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "twit")
public class Twit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String twitext;
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

    public String getTwitext() {
        return twitext;
    }

    public void setTwitext(String twitext) {
        this.twitext = twitext;
    }

    @Override
    public String toString() {
        return "Twit{" +
                "id=" + id +
                ", twitext='" + twitext + '\'' +
                ", user_id=" + user_id +
                ", date=" + date +
                '}';
    }
}
