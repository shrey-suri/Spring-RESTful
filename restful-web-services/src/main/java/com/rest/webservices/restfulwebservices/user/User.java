package com.rest.webservices.restfulwebservices.user;

import com.rest.webservices.restfulwebservices.user.posts.UserPosts;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class User {

    private Integer id;
    private String name;
    private Date birthDate;

    private List<UserPosts> posts;

    private static int postCount;

    public User(){}

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.posts = new ArrayList<>();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public UserPosts addPost(UserPosts post){
        if (post.getId() == null)
            post.setId(++postCount);
        posts.add(post);
        return post;
    }

    public UserPosts getUserPost(int post_id){
        for (UserPosts post: posts){
            if (post.getId() == post_id)
                return post;
        }
        return null;
    }

    public List<UserPosts> getAllPosts(){
        return posts;
    }

    public UserPosts deletePost(int post_id){
        Iterator<UserPosts> iterator = posts.iterator();
        while (iterator.hasNext()){
            UserPosts post = iterator.next();
            if (post.getId() == post_id){
                iterator.remove();
                return post;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", posts=" + allPostString() +
                '}';
    }



    private String allPostString(){
        String s = "";
        for (UserPosts post: posts){
            s += post.toString() + " \n";
        }
        return s;
    }
}
