package com.xude.persistence.model;

import java.io.Serializable;

public class TVisitor implements Serializable {
    private Long id;

    private User user;

    private Post post;

    private Integer num;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}