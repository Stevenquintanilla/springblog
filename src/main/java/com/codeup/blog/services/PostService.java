package com.codeup.blog.services;
import com.codeup.blog.posts.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postDao;

    public PostService(PostRepository postDao){
        this.postDao = postDao;
    }

    public List<Post> allPosts() {
        return (List<Post>) postDao.findAll();
    }

    public Post create(Post post){
        postDao.save(post);
        return post;

    }

    public Post edit(Post post){
        return postDao.save(post);
    }

    public Post getThisPostByID(long id){
        return postDao.findOne(id);
    }

    public void deletePost(Post post){
        postDao.delete(post);
    }
}
