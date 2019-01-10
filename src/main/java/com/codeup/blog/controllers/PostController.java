package com.codeup.blog.controllers;

import com.codeup.blog.posts.Post;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String postsAllDescription(Model model) {
        model.addAttribute("allPosts", postService.allPosts());
//        "The posts index page"
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsIndividualDescription(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.getThisPostByID(id));
        model.addAttribute("id", id);
//        "View the information of an individual post of" + id
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsViewForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create_post";
    }

    @PostMapping("/posts/create")
    public String postsCreateForm(@ModelAttribute Post post) {
        postService.createOnePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String postsViewEditPosts(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.getThisPostByID(id));
//        model.addAttribute("id", id);
        return "posts/edit_post";
    }

    @PostMapping("/posts/{id}/edit")
    public String postsEditForm(@ModelAttribute Post post) {
        postService.editPost(post);
        return "redirect:/posts/" + post.getId();
    }

}
