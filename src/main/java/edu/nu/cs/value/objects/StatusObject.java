package edu.nu.cs.value.objects;

/**
 * Created by Hasnain on 12/9/14.
 */
public class StatusObject {
    private int statusCode;
    private String statusText;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
}
