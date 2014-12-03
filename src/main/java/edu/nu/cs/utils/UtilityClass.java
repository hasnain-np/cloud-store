package edu.nu.cs.utils;

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

}
