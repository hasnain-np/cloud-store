package edu.nu.cs.value.objects;

import java.io.Serializable;

/**
 * Created by Hasnain
 * on 11/26/14.
 */
public class UserVO implements IValueObject {
    private Long userID;

    private String userName;

    private String password;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
