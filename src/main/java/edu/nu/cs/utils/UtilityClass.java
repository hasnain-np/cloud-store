package edu.nu.cs.utils;

import edu.nu.cs.constants.Constants;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.List;

/**
 * @author Ayaz Ali Qureshi
 * @version 1.0
 *          <p/>
 *          This class will contain utility functions
 */
public class UtilityClass {    /**
     * Method will split file URL on source directory path
     *
     * @param fullPath
     * @return
     */
    public static String getRelPathToFile(String fullPath) {
        return fullPath.split(Constants.SOURCE_DIRECTORY)[1];
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


    public static String getBaseDirectory(){
        return Constants.BASE_DIRECTORY + "/" + Constants.SOURCE_DIRECTORY;
    }


    public static void verifyUserDirectory(String userName) {
        Path dir = Paths.get(getBaseDirectory() + "/" + userName);

        if(!Files.exists(dir)) {
            try {
                Files.createDirectory(dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    public static void loadFilesAndFolders(List<String> files, List<String> folders, String pathStr){
        Path path = Paths.get(pathStr);

        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(path);

            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    folders.add(entry.getFileName().toString());
                }else{
                    files.add(entry.getFileName().toString());
                }
            }
            stream.close();

        }catch (IOException e){}
    }
}
