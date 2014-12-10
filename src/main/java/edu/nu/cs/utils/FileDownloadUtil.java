package edu.nu.cs.utils;

import edu.nu.cs.value.objects.SharedFilesVO;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLConnection;

/**
 * Utility Class for File downloading
 *
 * @author Ayaz Ali Qureshi
 * @version 1.0
 */
public class FileDownloadUtil {

    /**
     * Utility method which will download file on server
     *
     * @param res           HttpServletResponse
     * @param sharedFilesVO SharedFilesVO
     * @throws IOException
     */
    public static void download(HttpServletResponse res, SharedFilesVO sharedFilesVO) throws IOException {

        boolean isExpired = isSharingExpired(sharedFilesVO);
        File f = new File(UtilityClass.getBaseDirectory() + "\\" + sharedFilesVO.getFilename());

        /* Check if the file exists and the time current time is < expiry time */
        if (f.exists() && !isExpired) {
            String contentType = URLConnection.guessContentTypeFromName(f.getName());
            res.setContentType(contentType);
            res.setContentLength(new Long(f.length()).intValue());
            res.setHeader("Content-Disposition", "attachment; " + f.getName());
            FileCopyUtils.copy(new FileInputStream(f), res.getOutputStream());
        } else {
            res.sendError(500, "File not found");
        }

    }

    /**
     * Check date to evaluate if file has expired or not.
     *
     * @param sharedFilesVO
     * @return
     */
    private static boolean isSharingExpired(SharedFilesVO sharedFilesVO) {

        java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());
        return sharedFilesVO.getExpiry().before(dateNow);
    }


}
