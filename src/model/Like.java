package model;

import java.util.UUID;

public class Like {
    private UUID id;
    private UUID userId;
    private UUID postId;
    private String like ;
    private boolean status;

    public Like(UUID id, UUID userId, UUID postId, boolean status) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.postId = postId;
        this.like = "❤\uFE0F";
        this.status = status;
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

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return like;
    }
}
