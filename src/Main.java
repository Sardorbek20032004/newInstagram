import model.Post;
import model.User;
import model.Notification;
import service.NotificationService;
import service.PostService;
import service.UserServise;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static User loginUser;
    static NotificationService notificationService = new NotificationService();
    static UserServise userServise = new UserServise();
    static PostService postService = new PostService();

    public static void main(String[] args) {
        System.out.println("1.Register, 2.Login, 0.Exit");
        int res = scannerInt.nextInt();
        switch (res) {
            case 0 -> {
                return;
            }
            case 1 -> register();
            case 2 -> login();
        }
    }

    public static void register() {

    }

    public static void login() {
        //login username orqali tekshiriladi
        if (true) {
            int stepCode = 0;
            while (stepCode != 1) {
                int n = 0; // Go to notification service and take the notification list
                System.out.println("1. Add Post      2. See Post      3. Notification + " + n + "       4. My Account      0. Exit");
                int res = scannerInt.nextInt();
                switch (res) {
                    case 0 -> stepCode = 0;
                    case 1 -> addPost();
                    case 2 -> seePost();
                    case 3 ->
                            notification(); // When you enter notification, Print all notification and its name send by who, When notification is seen notification status should be false
                    //according to notificationService, when while go once after this process the number of notification should be lowered -1,
                    case 4 -> myAccaunt();
                }
            }
        }


    }

    public static void addPost() {
    }

    public static void seePost() {
    }

    public static void notification() {
        int stepcode = 10;
        while (stepcode != 0) {
            System.out.println("1. Notification        0.Exit");
            stepcode = scannerInt.nextInt();
            switch (stepcode){
                case 1 -> {
                    ArrayList<Notification> notifications = notificationService.getNotifications(loginUser.getId());
                    if (notifications.isEmpty()) {
                        System.out.println("No new notifications.");
                        return;
                    }
                    int i = 1;
                    for (Notification notification : notifications) {
                        User user = userServise.userById(notification.getFromUserId());
                        System.out.println(i + " Notification from: " + user.getName());
                        i++;
                    }
                    System.out.println("Enter notification index: ");
                    i = scannerInt.nextInt();
                    try {
                        Notification notification = notifications.get(i);
                        Post post = postService.postById(notification.getPostId());
                        System.out.println(post.getPost());
                        notification.setStatus(false);
                    } catch (Exception e){
                        System.out.println("Index Out Bound exception!");
                    }
                }
                default -> {
                    stepcode = 0;
                }
              }
            }
    }


    public static void myAccaunt(){
        int steepcode = 10;
        while (steepcode!=0){
            System.out.println("1.My post, 0.Exit");
            int res = scannerInt.nextInt();
            switch (res){
                case 0 -> steepcode = 0;
                case 1 ->{}
            }
        }
    }
}
