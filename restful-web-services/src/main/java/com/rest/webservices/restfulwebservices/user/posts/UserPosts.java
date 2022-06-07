package com.rest.webservices.restfulwebservices.user.posts;


import java.util.Date;

public class UserPosts {
    private Integer id;
    private String details;


    public UserPosts(){};

    public UserPosts(Integer id, String details){
        this.id = id;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "UserPosts {" +
                "id=" + id +
                ", details='" + details + '\'' +
                '}';
    }
}
