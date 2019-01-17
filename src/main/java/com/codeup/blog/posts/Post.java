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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //Adding a comment
    public Post(){

    }

    public Post(String title, String body, User user){
        this.body = body;
        this.title = title;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
