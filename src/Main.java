import model.User;

import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static User loginUser;
    public static void main(String[] args) {
        System.out.println("1.Register, 2.Login, 0.Exit");
        int res = scannerInt.nextInt();
        switch (res){
            case 0 -> {
                return;
            }
            case 1 -> register();
            case 2 -> login();
        }
    }

    public static void register(){

    }

    public static void login(){
           //login username orqali tekshiriladi
        if(true){
            int stepCode = 0;
            while (stepCode!=0) {
                System.out.println("1. Add Post      2. See Post      3. Notification      4. My Account      0. Exit");
                int res = scannerInt.nextInt();
                switch (res){
                    case 0 -> stepCode = 0;
                    case 1 -> addPost();
                    case 2 -> seePost();
                    case 3 -> notification();
                    case 4 -> myAccaunt();
                }
            }
        }


    }

    public static void addPost(){}
    public static void seePost(){}
    public static void notification(){}
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