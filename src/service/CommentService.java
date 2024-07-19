package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Comment;
import model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class CommentService implements  BaseService<Comment>{
    IOFileReadAndWrite<Comment> ioFileReadAndWrite = new IOFileReadAndWrite();
       private static  final String PATH = "src/file/comments.json";
       private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public Comment add(Comment comment){
        ArrayList<Comment> comments = ioFileReadAndWrite.fileRead(PATH);
        comments.add(comment);
        ioFileReadAndWrite.fileWrite(comments,PATH);
        return comment;
    }

    @Override
    public boolean delete(Comment comment) {
        ArrayList<Comment> comments = ioFileReadAndWrite.fileRead(PATH);
        for(Comment comment1: comments){
            if (comment1.getUserId().equals(comment.getUserId()) && comment1.getComment().equals(comment.getComment()) ){
                comments.remove(comment1);
                ioFileReadAndWrite.fileWrite(comments,PATH);
                return true;
            }
        }
        return false;
    }



    public ArrayList<Comment> list(){
        ArrayList<Comment> comments = ioFileReadAndWrite.fileRead(PATH);

        return comments;
    }
    public ArrayList<Comment> list(UUID id){
        ArrayList<Comment> comments = ioFileReadAndWrite.fileRead(PATH);
        ArrayList<Comment> commentArrayList = new ArrayList<>();
        for (Comment comment: comments){
            if (comment.getPostId().equals(id)){
                commentArrayList.add(comment);
            }
        }
        return commentArrayList;
    }




}
