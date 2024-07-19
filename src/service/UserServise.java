package service;

import model.Comment;
import model.User;

import java.util.ArrayList;
import java.util.UUID;

public class UserServise implements BaseService<User> {
    IOFileReadAndWrite<User> ioFileReadAndWrite = new IOFileReadAndWrite();

    private static final String PATH = "src/file/users.json";

    @Override
    public User add(User user) {
        ArrayList<User> users = ioFileReadAndWrite.fileRead(PATH);
      if (!hasUser(user.getName(), users)){
          users.add(user);
          ioFileReadAndWrite.fileWrite(users,PATH);
          return user;
      }
      return null;
    }

    @Override
    public boolean delete(User user) {
        ArrayList<User> users = ioFileReadAndWrite.fileRead(PATH);
        for (User user1 : users) {
            if(user.getUserName().equals(user1.getUserName())) {
                users.remove(user);
                ioFileReadAndWrite.fileWrite(users,PATH);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<User> list(UUID id) {
        ArrayList<User> users = ioFileReadAndWrite.fileRead(PATH);
        ArrayList<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getId().equals(id)) {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public ArrayList<User> list() {
        return ioFileReadAndWrite.fileRead(PATH);
    }

    private boolean hasUser(String username, ArrayList<User> users) {
        for (User user: users){
            if (user.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
