package edu.nu.cs.model.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

/**
 * Shared Files Entity
 * @author Ayaz Ali Qureshi
 * @version 1.0
 */

@Entity
@Table(name = "SharedFiles")
public class SharedFiles implements IEntityBean {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "content_type")
    private String contentType;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "hash", unique = true)
    private String hash;

    @Column(name = "expiry")
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

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date created) {
        this.expiry = created;
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

}