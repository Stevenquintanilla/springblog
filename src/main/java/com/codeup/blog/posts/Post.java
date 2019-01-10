package com.codeup.blog.posts;

public class Post {

    private String body;
    private String title;
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
