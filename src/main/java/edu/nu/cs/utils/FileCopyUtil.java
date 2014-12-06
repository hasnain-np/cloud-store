package edu.nu.cs.utils;

import edu.nu.cs.constants.Constants;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Hasnain on 12/6/2014.
 */
public class FileCopyUtil {
    /**
     *
     * @param sourceFileName: in form of '\\sourceHost\folder\***\filename.extension'
     * @param destFileName: in form of '\\destHost\folder\***\'
     */
    public static void copyFile(String sourceFileName, String destFileName){
        try {
            File sourceFile = new File(sourceFileName);
            File destinationFile = new File(destFileName
                    + sourceFileName.substring(sourceFileName.lastIndexOf("\\")));

            InputStream in = new FileInputStream(sourceFile);
            OutputStream out = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void copyFile(MultipartFile sourceFile, File destinationPath){
        try {
            sourceFile.transferTo(destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String []args){
        copyFile(Constants.REMOTE_HOSTIP + "\\" + Constants.REMOTE_BASEPATH  + "\\file.txt",
                Constants.REMOTE_HOSTIP + "\\" + Constants.REMOTE_BASEPATH + "\\file");
    }
}
