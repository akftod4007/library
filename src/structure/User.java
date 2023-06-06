package structure;

public class User {
    private static String userId;
    private static String userPw;

    public void User(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }

    public static String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId=userId; }

    public static String getUserPw() { return userPw; }
    public void setUserPw(String userPw) { this.userPw=userPw; }
}