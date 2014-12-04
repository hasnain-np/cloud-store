package edu.nu.cs.web.controller;

        import edu.nu.cs.constants.Constants;
        import edu.nu.cs.utils.FileChangeListener;
        import edu.nu.cs.vfs.GenericDestinationHandler;
        import edu.nu.cs.vfs.SFTPHandler;
        import edu.nu.cs.utils.PropertyUtil;
        import org.apache.commons.vfs2.*;
        import org.apache.commons.vfs2.impl.DefaultFileMonitor;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.RequestMapping;

        import java.io.UnsupportedEncodingException;
        import java.net.URISyntaxException;

/**
 * @author Ayaz Ali Qureshi
 * @version 1.0
 */
@Controller
@RequestMapping("/sync")
public class SyncController {

    @RequestMapping("/file")
    public String file(ModelMap model) throws FileSystemException, UnsupportedEncodingException, URISyntaxException {

        FileSystemManager fsManager = VFS.getManager();
        FileObject cwd = fsManager.resolveFile(Constants.BASE_DIRECTORY);

        FileObject src = fsManager.resolveFile(cwd, Constants.SOURCE_DIRECTORY);

        GenericDestinationHandler.scheme = "sftp";
        
        FileChangeListener fileChangeListener = new FileChangeListener();
        DefaultFileMonitor fm = new DefaultFileMonitor(fileChangeListener);
        fm.setRecursive(true);
        fm.addFile(src);
        fm.start();

        return "monitorStarted";
    }
}
