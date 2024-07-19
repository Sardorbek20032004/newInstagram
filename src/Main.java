import model.*;
import service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static User loginUser;
    static NotificationService notificationService = new NotificationService();
    static UserServise userServise = new UserServise();
    static PostService postService = new PostService();
    static LikeService likeService = new LikeService();
    static CommentService commentService = new CommentService();

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
        int stepCode = 9;
        while (stepCode != 0){
            User user = new User();
            System.out.println("Enter your name :");
            user.setName(scannerStr.nextLine());
            System.out.println("Enter your username :");
            user.setUserName(scannerStr.nextLine());
            System.out.println("Enter your email :");
            user.setUserName(scannerStr.nextLine());
            System.out.println("Enter your phoneNumber  :");
            user.setPhoneNumber(scannerStr.nextLine());
            System.out.println("Enter your bio ");
            user.setBio(scannerStr.nextLine());
            User add = userServise.add(user);
            if (add == null) {
                System.out.println("This user is already exist");
            }
            System.out.println("Registration is successfully done!");
        }

    }

    public static void login() {
        int stepCode = 9;
        while (stepCode != 0){
            System.out.println("Enter username : ");
            String username = scannerStr.nextLine();
            User login = userServise.getUsernameByUser(username);

            if(login == null) {
                System.out.println(" Wrong username ");
                //login username orqali tekshiriladi
            }
        else {
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
                System.out.println("Enter Post: ");
                String post = scannerStr.nextLine();
                Post post1 = new Post(loginUser.getId(),post);
                postService.add(post1);
                System.out.println("Your post is successfully added");
                ArrayList<User> users = userServise.list();
                for (User user: users) {
                    Notification notification1 = new Notification(loginUser.getId(), user.getId(), true, post1.getId());
                    notificationService.addNotification(notification1);
                }
            }
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
                    case 1 ->{
                        ArrayList<Post> posts = postService.list(loginUser.getId());
                        int n = 1;
                        for (Post post: posts){
                            System.out.println(n + ") " + post);
                        }
                        System.out.println("Choose post: ");
                        int index = scannerInt.nextInt();
                        Post post = postService.getPostByIndex(index);
                        int result = 10;
                        while (result!=0) {
                            System.out.println("1,Like, 2.Comment, 0.Exit ");
                            int s = scannerInt.nextInt();
                            switch (s){
                                case 0 -> result = 0;
                                case 1 -> {
                                    ArrayList<Like> likes = likeService.list(post.getId());
                                    int t = 1;
                                    for (Like like: likes){
                                        System.out.println(t + ") " + like + userServise.getUserById(like.getUserId()).getName());
                                    }
                                }
                                case 2 -> {
                                    ArrayList<Comment> comments = commentService.list(post.getId());
                                    int q = 1;
                                    for (Comment comment: comments){
                                        System.out.println(q + ") " + comment.getComment());
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }
}
