package com.codeup.blog.services;
import com.codeup.blog.posts.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> allPosts() {
        return posts;
    }

    public Post createOnePost(Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post getThisPostByID(long id){
        return posts.get((int) (id - 1));
    }

    private void createPosts(){
        createOnePost(new Post("Post 1", "Lorem blah blah"));
        createOnePost(new Post("Post 2", "Lorem blah blah"));
        createOnePost(new Post("Post 3", "Lorem blah blah"));
        createOnePost(new Post("Post 4", "Lorem blah blah"));
    }

    public Post editPost(Post post){
        Post editedPost = posts.get((int) post.getId() -1);
        editedPost.setTitle(post.getTitle());
        editedPost.setBody(post.getBody());
        return editedPost;
    }
}
