package service;

import model.Comment;
import model.Post;

import java.util.ArrayList;
import java.util.UUID;

public class PostService implements BaseService<Post>{
    IOFileReadAndWrite<Comment> ioFileReadAndWrite = new IOFileReadAndWrite();
    private static  final String PATH = "src/file/posts.json";

    @Override
    public Post add(Post post) {
        return null;
    }

    @Override
    public boolean delete(Post post) {
        return false;
    }

    @Override
    public ArrayList<Post> list(UUID id) {
        return null;
    }

    @Override
    public ArrayList<Post> list() {
        return null;
    }
}
