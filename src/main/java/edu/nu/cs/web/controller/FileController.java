package edu.nu.cs.web.controller;

import edu.nu.cs.constants.Constants;
import edu.nu.cs.security.SpringSecurityUtil;
import edu.nu.cs.utils.FileCopyUtil;
import edu.nu.cs.utils.UtilityClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasnain on 12/1/2014.
 */
@Controller
@RequestMapping("/ajax")
public class FileController {

    @Resource
    SpringSecurityUtil springSecurityUtil;

    @RequestMapping(value="file", method = RequestMethod.POST)
    public String uploadFile(Model model, MultipartFile file, String path) {

        String srcDir = UtilityClass.getBaseDirectory() + "/" + springSecurityUtil.getLoginUserName()
                + "/" + path + "/" + file.getOriginalFilename();

        FileCopyUtil.copyFile(file, new java.io.File(srcDir));

//          Commenting out replication code
//        String destDir = Constants.BASE_DIRECTORY + "/" + Constants.DESTINATION_DIRECTORY + "/" + springSecurityUtil.getLoginUserName()
//          + "/" + path;
//        FileCopyUtil.copyFile(srcDir, destDir);

        List<String> files = new ArrayList<String>();
        List<String> folders = new ArrayList<String>();

        UtilityClass.loadFilesAndFolders(files, folders, UtilityClass.getBaseDirectory() + "/" + springSecurityUtil.getLoginUserName());

        model.addAttribute("folders", folders);
        model.addAttribute("files", files);

        model.addAttribute("pathStr", path);

        return "filesList";
    }


    @RequestMapping(value="createFolder", method = RequestMethod.POST)
    public String createFolder(Model model, String pathStr, String folderName){
        String _pathStr = UtilityClass.getBaseDirectory() + "\\" + springSecurityUtil.getLoginUserName()
                + "\\" + pathStr + "\\" + folderName;

        Path path = Paths.get(_pathStr);

        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> files = new ArrayList<String>();
        List<String> folders = new ArrayList<String>();

        UtilityClass.loadFilesAndFolders(files, folders, _pathStr);

        model.addAttribute("folders", folders);
        model.addAttribute("files", files);

        model.addAttribute("pathStr", pathStr + "/" + folderName);

        return "filesList";
    }

    @RequestMapping(value="fileListing", method = RequestMethod.POST)
    public String fileListing(Model model, String path){

        String pathStr = UtilityClass.getBaseDirectory() + "\\" + springSecurityUtil.getLoginUserName() + "\\" + path;

        List<String> files = new ArrayList<String>();
        List<String> folders = new ArrayList<String>();

        UtilityClass.loadFilesAndFolders(files, folders, pathStr);

        model.addAttribute("folders", folders);
        model.addAttribute("files", files);

        model.addAttribute("pathStr", path);


        return "filesList";
    }
}
