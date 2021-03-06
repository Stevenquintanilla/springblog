package com.codeup.blog.controllers;

import com.codeup.blog.posts.Post;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.PostService;
import com.codeup.blog.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.chrono.JapaneseChronology;

@Controller
public class PostController {
    private final PostService postService;
    private UserRepository userDao;

    public PostController(PostService postService, UserRepository userDao){
        this.postService = postService;
        this.userDao = userDao;
    }
    //Comment here
    @GetMapping("/posts")
    public String postsAllDescription(Model model) {
        model.addAttribute("allPosts", postService.allPosts());
        System.out.println("There are " + userDao.count() + " users");
//        "The posts index page"
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsIndividualDescription(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.findOne(id));
        model.addAttribute("id", id);
        model.addAttribute("user", postService.findOne(id).getUser());
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

        postService.create(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String postsViewEditPosts(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.findOne(id));
//        model.addAttribute("id", id);
        return "posts/edit_post";
    }

    @PostMapping("/posts/{id}/edit")
    public String postsEditForm(@ModelAttribute Post post) {
        postService.edit(post);
        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable int id) {
        postService.deletePost(postService.findOne(id));
        return "redirect:/posts";
    }



}
