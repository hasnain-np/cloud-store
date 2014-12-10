package edu.nu.cs.web.controller;

import edu.nu.cs.service.interfaces.ISharedFilesService;
import edu.nu.cs.utils.FileDownloadUtil;
import edu.nu.cs.value.objects.SharedFilesVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Ayaz Ali Qureshi
 * @version 1.0
 */
@Controller
@RequestMapping("/sharing")
public class SharingController {

    @Resource
    ISharedFilesService sharedFilesService;

    @RequestMapping(value = "/dl/{hash}", method = RequestMethod.GET)
    public void dl(HttpServletResponse res, @PathVariable(value = "hash") String hash) throws IOException, URISyntaxException {

        SharedFilesVO sharedFilesVO = new SharedFilesVO();
        sharedFilesVO.setHash(hash);

        SharedFilesVO downloadFile = sharedFilesService.findByHash(sharedFilesVO);

        /* Download file or throw error if problem */

        FileDownloadUtil.download(res, downloadFile);

    }
}
