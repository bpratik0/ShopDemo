package abhi.main.shopingdemo.model;

public class User {
    private String userName;
    private String userEmail;
    private String userPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private static User userReg = null;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMob() {
        return userMob;
    }

    public void setUserMob(String userMob) {
        this.userMob = userMob;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private String userMob;
    private String userType;

    public static synchronized User getUserRegDataHolder() {
        if (userReg == null) {
            userReg = new User();
        }
        return userReg;
    }


    public static void setTourDataHolder(User tourDataHolder) {
        User.userReg = tourDataHolder;
    }

}
