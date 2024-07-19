package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotificationService {
    private static final String PATH = "src/file/notifications.json";
    private IOFileReadAndWrite<Notification> ioFileReadAndWrite = new IOFileReadAndWrite<>();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void addNotification(Notification notification) {
        ArrayList<Notification> notifications = ioFileReadAndWrite.fileRead(PATH);
        notifications.add(notification);
        ioFileReadAndWrite.fileWrite(notifications, PATH);
    }

    public void markAsRead(UUID notificationId) {
        ArrayList<Notification> notifications = ioFileReadAndWrite.fileRead(PATH);
        for (Notification notification : notifications) {
            if (notification.getFromUserId().equals(notificationId)) {
                notification.setStatus(true);
                break;
            }
        }
        ioFileReadAndWrite.fileWrite(notifications, PATH);
    }

    public void userViewNotifications(UUID userId) {
        ArrayList<Notification> notifications = ioFileReadAndWrite.fileRead(PATH);
        for (Notification notification : notifications) {
            if (notification.getToUserId().equals(userId)) {
                notification.setStatus(false);
            }
        }
        ioFileReadAndWrite.fileWrite(notifications, PATH);
    }

    public ArrayList<Notification> getNotifications(UUID id) {
        ArrayList<Notification> notifications = ioFileReadAndWrite.fileRead(PATH);
        ArrayList<Notification> notificationArrayList = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getFromUserId().equals(id) && notification.isStatus()) {
                notificationArrayList.add(notification);
            }
        }
        return notificationArrayList;
    }
}
