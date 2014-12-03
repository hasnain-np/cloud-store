package edu.nu.cs.utils;

import edu.nu.cs.constants.Constants;
import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.impl.SynchronizedFileObject;

/**
 * @author Ayaz Ali Qureshi
 * @version 1.0
 * @see org.apache.commons.vfs2.FileListener
 * <p/>
 * Implementation of FileListener, this class is basically responsible for copying and deleting files once a change is detected in the
 * corresponding filesystem
 */
public class FileChangeListener implements FileListener {

    private FileSystemManager fsManager;
    private SynchronizedFileObject cwd;
    private SynchronizedFileObject dest;
    private SynchronizedFileObject src;

    /**
     * Initialize all variables
     *
     * @throws FileSystemException
     */
    public FileChangeListener() throws FileSystemException {
        this.fsManager = VFS.getManager();
        this.cwd = new SynchronizedFileObject(fsManager.resolveFile(Constants.BASE_DIRECTORY));
        this.dest = new SynchronizedFileObject(fsManager.resolveFile(cwd, Constants.DESTINATION_DIRECTORY));
        this.src = new SynchronizedFileObject(fsManager.resolveFile(cwd, Constants.SOURCE_DIRECTORY));

    }

    /**
     * Invoke copy operation from SRC ==> DEST
     *
     * @param event
     * @throws Exception
     */
    @Override
    public void fileCreated(org.apache.commons.vfs2.FileChangeEvent event) throws Exception {

        String fileName = UtilityClass.getRelPathToFile(event.getFile().getName().getFriendlyURI());
        System.out.println("file created : " + UtilityClass.getRelPathToFile(event.getFile().getName().getFriendlyURI()));
        dest.copyFrom(src, Selectors.SELECT_ALL);
    }

    /**
     * Delete file if-exists SRC ==> DEST
     *
     * @param event
     * @throws Exception
     */
    @Override
    public void fileDeleted(org.apache.commons.vfs2.FileChangeEvent event) throws Exception {
        System.out.println("file deleted : "
                + event.getFile().getName());

        String fileName = UtilityClass.getRelPathToFile(event.getFile().getName().getFriendlyURI());
        SynchronizedFileObject newDest = new SynchronizedFileObject(fsManager.resolveFile(cwd, Constants.DESTINATION_DIRECTORY + fileName));
        if (newDest.exists()) {
            newDest.delete(Selectors.SELECT_SELF);
        }

    }

    /**
     * Invoke copy operation from SRC ==> DEST
     *
     * @param event
     * @throws Exception
     */
    @Override
    public void fileChanged(org.apache.commons.vfs2.FileChangeEvent event) throws Exception {
        System.out.println(String.format(
                "File [%s] changed event from [%s]", event
                        .getFile().getName(), this));

        System.out.println("file created : " + UtilityClass.getRelPathToFile(event.getFile().getName().getFriendlyURI()));
        dest.copyFrom(src, Selectors.SELECT_ALL);
    }
}