package edu.nu.cs.web.controller;

import edu.nu.cs.assembler.UserAssembler;
import edu.nu.cs.constants.Constants;
import edu.nu.cs.model.entity.SharedFiles;
import edu.nu.cs.model.entity.User;
import edu.nu.cs.security.SpringSecurityUtil;
import edu.nu.cs.service.impl.SharedFilesService;
import edu.nu.cs.service.interfaces.ISharedFilesService;
import edu.nu.cs.service.interfaces.IUserService;
import edu.nu.cs.utils.FileCopyUtil;
import edu.nu.cs.utils.UtilityClass;
import edu.nu.cs.value.objects.SharedFilesVO;
import edu.nu.cs.value.objects.StatusObject;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Hasnain on 12/1/2014.
 */
@Controller
@RequestMapping("/ajax")
public class FileController {

    @Resource
    SpringSecurityUtil springSecurityUtil;

    @Resource
    ISharedFilesService sharedFilesService;

    @Resource
    IUserService userService;

    @RequestMapping(value = "file", method = RequestMethod.POST)
    public String uploadFile(Model model, MultipartFile file, String path) {

        String srcDir = UtilityClass.getUserDirectory(springSecurityUtil.getLoginUserName())
                + "/" + path + "/" + file.getOriginalFilename();

        FileCopyUtil.copyFile(file, new java.io.File(srcDir));

//          Commenting out replication code
//        String destDir = Constants.BASE_DIRECTORY + "/" + Constants.DESTINATION_DIRECTORY + "/" + springSecurityUtil.getLoginUserName()
//          + "/" + path;
//        FileCopyUtil.copyFile(srcDir, destDir);

        List<String> files = new ArrayList<String>();
        List<String> folders = new ArrayList<String>();

        UtilityClass.loadFilesAndFolders(files, folders, UtilityClass.getUserDirectory(springSecurityUtil.getLoginUserName()) + "/" + path);

        model.addAttribute("folders", folders);
        model.addAttribute("files", files);

        model.addAttribute("pathStr", path);

        return "filesList";
    }


    @RequestMapping(value = "createFolder", method = RequestMethod.POST)
    public String createFolder(Model model, String pathStr, String folderName) {
        String _pathStr = UtilityClass.getUserDirectory(springSecurityUtil.getLoginUserName())
                + "/" + pathStr + "/" + folderName;

        Path path = Paths.get(_pathStr);

        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> files = new ArrayList<String>();
        List<String> folders = new ArrayList<String>();

        UtilityClass.loadFilesAndFolders(files, folders, _pathStr.replace(folderName,""));

        model.addAttribute("folders", folders);
        model.addAttribute("files", files);

        model.addAttribute("pathStr", pathStr + "/" + folderName);

        return "filesList";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public
    @ResponseBody
    StatusObject delete(Model model, String pathStr, String name) {
        StatusObject object = new StatusObject();

        String _pathStr = UtilityClass.getUserDirectory(springSecurityUtil.getLoginUserName())
                + "/" + pathStr + "/" + name;

        Path path = Paths.get(_pathStr);

        try {
            //path being delete is non empty directory
            if (Files.isDirectory(path) && Files.newDirectoryStream(path).iterator().hasNext()) {
                object.setStatusCode(Constants.STATUS_CODE_ERROR);
                object.setStatusText("Error! Cannot delete non-empty directory!");
            } else {
                Files.delete(path);

                object.setStatusCode(Constants.STATUS_CODE_SUCCESS);
                object.setStatusText("Delete successful");
            }
        } catch (IOException x) {
            x.printStackTrace();
            object.setStatusCode(Constants.STATUS_CODE_ERROR);
            object.setStatusText(x.getMessage());
        }
        return object;
    }

    @RequestMapping(value = "fileListing", method = RequestMethod.POST)
    public String fileListing(Model model, String path) {

        String pathStr = UtilityClass.getUserDirectory(springSecurityUtil.getLoginUserName()) + "/" + path;

        List<String> files = new ArrayList<String>();
        List<String> folders = new ArrayList<String>();

        UtilityClass.loadFilesAndFolders(files, folders, pathStr);

        model.addAttribute("folders", folders);
        model.addAttribute("files", files);

        model.addAttribute("pathStr", path);


        return "filesList";
    }

    @RequestMapping(value = "sharing", method = RequestMethod.POST)
    public @ResponseBody SharedFilesVO sharing(Model model, String path) throws NoSuchAlgorithmException {

        String pathStr = springSecurityUtil.getLoginUserName() + "/" + path;

        List<String> files = new ArrayList<String>();
        List<String> folders = new ArrayList<String>();
        UtilityClass.loadFilesAndFolders(files, folders, pathStr);
        model.addAttribute("folders", folders);
        model.addAttribute("files", files);
        model.addAttribute("pathStr", path);

        SharedFilesVO sharedFilesVO = new SharedFilesVO();
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        sharedFilesVO.setFilename(pathStr);
        sharedFilesVO.setExpiry(date);
        String hash = UUID.randomUUID().toString();
        sharedFilesVO.setHash(hash);

        UserVO userVO = new UserVO();
        userVO.setUserName(springSecurityUtil.getLoginUserName());
        UserVO usr = userService.findByUsername(userVO);

        sharedFilesVO.setUser((User) UserAssembler.getInstance().convertToEntityBean(usr));

        sharedFilesService.save(sharedFilesVO);

        return sharedFilesVO;
    }
}
