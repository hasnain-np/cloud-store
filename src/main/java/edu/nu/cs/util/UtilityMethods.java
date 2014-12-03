package edu.nu.cs.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by Hasnain on 12/1/2014.
 */
public class UtilityMethods {
    public static String getMD5(String input){
        String md5 = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md5 = new BigInteger(1, md.digest(input.getBytes())).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }
}