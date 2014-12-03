package edu.nu.cs.web.controller;

        import edu.nu.cs.utils.FileChangeListener;
        import edu.nu.cs.utils.Properties;
        import org.apache.commons.vfs2.*;
        import org.apache.commons.vfs2.impl.DefaultFileMonitor;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ayaz Ali Qureshi
 * @version 1.0
 */
@Controller
@RequestMapping("/sync")
public class SyncController {

    @RequestMapping("/file")
    public String file(ModelMap model) throws FileSystemException {

        FileSystemManager fsManager = VFS.getManager();
        FileObject cwd = fsManager.resolveFile(Properties.baseDirectory);

        FileObject src = fsManager.resolveFile(cwd, Properties.sourceDirectory);

        FileChangeListener fileChangeListener = new FileChangeListener();
        DefaultFileMonitor fm = new DefaultFileMonitor(fileChangeListener);
        fm.setRecursive(true);
        fm.addFile(src);
        fm.start();

        return "monitorStarted";
    }
}
