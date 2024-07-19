package service;

import model.Comment;
import model.Like;

import java.util.ArrayList;
import java.util.UUID;

public class LikeService implements BaseService<Like>{
    IOFileReadAndWrite<Comment> ioFileReadAndWrite = new IOFileReadAndWrite();
    private static  final String PATH = "src/file/likes.json";
    @Override
    public Like add(Like like) {
        return null;
    }

    @Override
    public boolean delete(Like like) {
        return false;
    }

    @Override
    public ArrayList<Like> list(UUID id) {
        return null;
    }

    @Override
    public ArrayList<Like> list() {
        return null;
    }
}
