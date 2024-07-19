package service;

import model.Comment;
import model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostService implements BaseService<Post>{
    IOFileReadAndWrite<Post> ioFileReadAndWrite = new IOFileReadAndWrite();
    private static  final String PATH = "src/file/posts.json";

    @Override
    public Post add(Post post) {
        ArrayList<Post> posts = ioFileReadAndWrite.fileRead(PATH);
        posts.add(post);
        ioFileReadAndWrite.fileWrite(posts,PATH);
        return post;
    }

    @Override
    public boolean delete(Post post) {
        ArrayList<Post> posts = ioFileReadAndWrite.fileRead(PATH);
        for (Post post1 : posts) {
            if (post1.getId().equals(post.getId())) {
                posts.remove(post);
                ioFileReadAndWrite.fileWrite(posts,PATH);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Post> list(UUID id) {
        ArrayList<Post> postArrayList = ioFileReadAndWrite.fileRead(PATH);
        ArrayList<Post> posts = new ArrayList<>();
        for (Post post : postArrayList) {
            if (post.getUserId().equals(id)) {
                posts.add(post);
            }
        }
        return posts;
    }

    @Override
    public ArrayList<Post> list() {
        return ioFileReadAndWrite.fileRead(PATH);
    }
}
