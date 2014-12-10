package edu.nu.cs.value.objects;

import edu.nu.cs.model.entity.User;

import java.sql.Date;

/**
 * Shared Files
 *
 * @author Ayaz Ali Qureshi
 * @version 1.0
 */

public class SharedFilesVO implements IValueObject {

    private Integer id;

    private String filename;

    private String contentType;

    private User user;

    private String hash;

    private Date expiry;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date created) {
        this.expiry = created;
    }
}