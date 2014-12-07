package edu.nu.cs.web.controller;

import edu.nu.cs.security.SpringSecurityUtil;
import edu.nu.cs.utils.UtilityClass;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Hasnain on 12/7/2014.
 */
@Controller
@RequestMapping("/")
public class FileDownloadController {
    @Resource
    SpringSecurityUtil springSecurityUtil;


   /* @RequestMapping(value = "downloadFile", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource getFile( String path, String fileName) {
        return new FileSystemResource(UtilityClass.getBaseDirectory() + "/" + springSecurityUtil.getLoginUserName()
                + (StringUtils.isEmpty(path.replace("\"", "")) ? "" : "/" + path)  + "/" + fileName);
    }*/

    @RequestMapping(value = "downloadFile", method = RequestMethod.GET)
    @ResponseBody
    public void getFile( String path, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException{
        // create full filename and get input stream
        File fileToDownload = new File(UtilityClass.getBaseDirectory() + "/" + springSecurityUtil.getLoginUserName()
                + (StringUtils.isEmpty(path.replace("\"", "")) ? "" : "/" + path)  + "/" + fileName);
        InputStream is = new FileInputStream(fileToDownload);

        // set file as attached data and copy file data to response output stream
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName );
        FileCopyUtils.copy(is, response.getOutputStream());
        // close stream and return to view
        response.flushBuffer();
    }
}
