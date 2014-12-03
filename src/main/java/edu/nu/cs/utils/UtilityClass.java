package edu.nu.cs.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author Ayaz Ali Qureshi
 * @version 1.0
 *          <p/>
 *          This class will contain utility functions
 */
public class UtilityClass {


    private static final String srcDir = Properties.sourceDirectory;

    /**
     * Method will split file URL on source directory path
     *
     * @param fullPath
     * @return
     */
    public static String getRelPathToFile(String fullPath) {

        return fullPath.split(srcDir)[1];

    }
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
