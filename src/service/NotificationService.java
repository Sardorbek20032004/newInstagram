package service;

import model.Comment;
import model.Notification;

import java.util.ArrayList;
import java.util.UUID;

public class NotificationService implements BaseService<Notification>{
    IOFileReadAndWrite<Comment> ioFileReadAndWrite = new IOFileReadAndWrite();
    private static  final String PATH = "src/file/notification.json";
    @Override
    public Notification add(Notification notification) {
        return null;
    }

    @Override
    public boolean delete(Notification notification) {
        return false;
    }

    @Override
    public ArrayList<Notification> list(UUID id) {
        return null;
    }

    @Override
    public ArrayList<Notification> list() {
        return null;
    }
}
