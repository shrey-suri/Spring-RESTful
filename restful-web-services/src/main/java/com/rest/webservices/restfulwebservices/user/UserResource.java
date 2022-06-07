package com.rest.webservices.restfulwebservices.user;

import com.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.rest.webservices.restfulwebservices.user.posts.UserPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private  UserDaoService service;

    /*
            METHODS FOR USER
     */
    //getAllUsers
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.findAll();
    }

    //getUser(int id)
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user = service.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id: " + id);
        return user;
    }

    //Add User
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = service.save(user);
         URI location = ServletUriComponentsBuilder
                 .fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(savedUser.getId())
                 .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if (user == null)
            throw new UserNotFoundException("id: " + id);
    }

    /*
                METHODS FOR POSTS
     */

    //Add New Post to a User
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody UserPosts post){
        User user = getUser(id);
        UserPosts savedPost = user.addPost(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{post_id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    //Get All Posts of a User
    @GetMapping("/users/{id}/posts")
    public List<UserPosts> getAllPosts(@PathVariable int id){
        User user = getUser(id);
        return user.getAllPosts();
    }

    //Get a specific Post of User
    @GetMapping("/users/{id}/posts/{post_id}")
    public UserPosts findAPost(@PathVariable int id, @PathVariable  int post_id){
        User user = getUser(id);
        UserPosts singlePost = user.getUserPost(post_id);
        if (singlePost == null)
            throw new PostNotFoundException("User ID: " + id + " Post ID: " + post_id);
        return singlePost;
    }

    //Delete a User's Post
    @DeleteMapping("/users/{id}/posts/{post_id}")
    public void deletePost(@PathVariable int id, @PathVariable int post_id){
        User user = getUser(id);
        UserPosts post = user.deletePost(post_id);
        if (post == null)
            throw new PostNotFoundException("User ID: " + id + " Post ID: " + post_id);
    }



}
