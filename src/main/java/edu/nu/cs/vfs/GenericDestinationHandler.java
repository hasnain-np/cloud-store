package edu.nu.cs.vfs;

import edu.nu.cs.utils.Properties;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.impl.SynchronizedFileObject;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

/**
 * Created by Ayaz Ali Qureshi on 12/3/2014.
 */
public class GenericDestinationHandler {

    public static String scheme = null;


    public org.apache.commons.vfs2.FileObject getDestinationObject(FileSystemManager fsManager) throws FileSystemException, UnsupportedEncodingException, URISyntaxException {

        SynchronizedFileObject cwd = new SynchronizedFileObject(fsManager.resolveFile(Properties.baseDirectory));

        if (this.scheme.equals("sftp")) {

            SFTPHandler sftpHandler = new SFTPHandler();

            return fsManager.resolveFile(sftpHandler.getFTPURL(), sftpHandler.getOptions());
        } else {

            return fsManager.resolveFile(cwd, Properties.destinationDirectory);
        }

    }


}
