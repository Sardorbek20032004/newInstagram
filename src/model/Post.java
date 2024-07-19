package model;

import java.util.UUID;

public class Post {
    private UUID id;
    private UUID userId;
    private String post;

    public Post() {
        this.id = UUID.randomUUID();
    }

    public Post(UUID userId, String post) {
        this();
        this.userId = userId;
        this.post = post;
    }

    public UUID getId() {
        return id;
    }


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return post;
    }
}
