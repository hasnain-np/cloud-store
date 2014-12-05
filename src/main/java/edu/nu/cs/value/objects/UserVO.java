package edu.nu.cs.value.objects;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Hasnain
 * on 11/26/14.
 */
public class UserVO implements IValueObject {
    private Long userID;
    @NotBlank
    @Pattern(regexp = "[0-9a-zA-Z\\.\\-_]+", message = "Only allowed alphanumeric string with (. - _) characters.")
//    @Min(value = 8,message = "User name should be greater then or equal to 8 characters")
    private String userName;

    @NotBlank
//    @Min(value = 6, message = "should be greater then 6 characters")
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
