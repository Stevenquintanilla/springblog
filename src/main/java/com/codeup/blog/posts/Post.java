package com.codeup.blog.posts;

import com.codeup.blog.users.User;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    //You can just remove the length since it defaults to 255 anyway
    @Column(nullable = false, length= 1000)
    private String body;

    @Column(nullable = false, length= 300)
    private String title;

    @Id @GeneratedValue
    private long id;

    @OneToOne
    private User owner;


    public Post(){

    }

    public Post(String title, String body, User owner){
        this.body = body;
        this.title = title;
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
