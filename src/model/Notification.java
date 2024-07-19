package model;

import java.util.UUID;

public class Notification {
    private UUID id;
    private UUID toUserId;
    private UUID fromUserId;
    private UUID postId;
    private boolean status;

    public Notification() {
        this.id = UUID.randomUUID();
    }

    public Notification(UUID toUserId, UUID fromUserId, UUID postId, boolean status) {
        this();
        this.toUserId = toUserId;
        this.fromUserId = fromUserId;
        this.postId = postId;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getToUserId() {
        return toUserId;
    }

    public void setToUserId(UUID toUserId) {
        this.toUserId = toUserId;
    }

    public UUID getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(UUID fromUserId) {
        this.fromUserId = fromUserId;
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

}
