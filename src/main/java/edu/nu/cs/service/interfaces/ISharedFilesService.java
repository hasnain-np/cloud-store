package edu.nu.cs.service.interfaces;

import edu.nu.cs.value.objects.SharedFilesVO;

/**
 * Created by Hasnain on 12/1/2014.
 */
public interface ISharedFilesService extends IService {
    public SharedFilesVO findByHash(SharedFilesVO sharedFilesVO);

    public SharedFilesVO save(SharedFilesVO sharedFilesVO);

}