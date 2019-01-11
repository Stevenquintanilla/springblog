package com.codeup.blog.posts;

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

    public Post(){

    }

    public Post(String title, String body){
        this.body = body;
        this.title = title;
    }

    public Post(String title, String body, long id){
        this.body = body;
        this.title = title;
        this.id = id;
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
