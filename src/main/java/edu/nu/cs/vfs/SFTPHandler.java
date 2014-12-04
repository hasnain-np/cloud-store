package edu.nu.cs.vfs;

import edu.nu.cs.utils.Properties;
import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.apache.commons.vfs2.impl.DefaultFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created by Ayaz Ali Qureshi on 12/3/2014.
 */
public class SFTPHandler {


    public String getFTPURL() throws FileSystemException, UnsupportedEncodingException, URISyntaxException {

        String url_s = new java.net.URI("sftp", "root:netpace", "192.168.1.176", 22, "/root/cloud-store/" + Properties.destinationDirectory, null, null).toASCIIString();
        return url_s;
    }

    public FileSystemOptions getOptions() throws FileSystemException {
        FileSystemOptions opts = new FileSystemOptions();

        SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
        SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
        SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);

        return opts;
    }
}
