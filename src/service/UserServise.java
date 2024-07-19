package service;

import model.Comment;
import model.User;

import java.util.ArrayList;
import java.util.UUID;

public class UserServise implements BaseService<User> {
    IOFileReadAndWrite<Comment> ioFileReadAndWrite = new IOFileReadAndWrite();
    private static  final String PATH = "src/file/users.json";


    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public ArrayList<User> list(UUID id) {
        return null;
    }

    @Override
    public ArrayList<User> list() {
        return null;
    }
}
