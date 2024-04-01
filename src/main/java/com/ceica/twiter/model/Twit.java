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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;
    private Date date;

    public Twit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
