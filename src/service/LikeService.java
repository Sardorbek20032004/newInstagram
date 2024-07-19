package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Comment;
import model.Like;

import java.util.ArrayList;
import java.util.UUID;

public class LikeService implements BaseService<Like>{
    IOFileReadAndWrite<Like> ioFileReadAndWrite = new IOFileReadAndWrite();
    private static  final String PATH = "src/file/likes.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Like add(Like like) {
        ArrayList<Like> likes = ioFileReadAndWrite.fileRead(PATH);
        likes.add(like);
        ioFileReadAndWrite.fileWrite(likes,PATH);
        return like;
    }

    @Override
    public boolean delete(Like like) {
        ArrayList<Like> likes = ioFileReadAndWrite.fileRead(PATH);
        for (Like like1: likes){
            if (like1.getPostId().equals(like.getPostId())){
                likes.remove(like1);
                ioFileReadAndWrite.fileWrite(likes,PATH);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Like> list() {
        ArrayList<Like> likes = ioFileReadAndWrite.fileRead(PATH);
        return likes;
    }

    @Override
    public ArrayList<Like> list(UUID postId) {
        ArrayList<Like> likes = ioFileReadAndWrite.fileRead(PATH);
        ArrayList<Like> likes1 = new ArrayList<>();
        for (Like like: likes){
            if (like.getPostId().equals(postId)){
                likes1.add(like);
            }
        }
        return likes1;
    }
}
