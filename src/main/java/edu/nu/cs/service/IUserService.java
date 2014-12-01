package edu.nu.cs.service;

import edu.nu.cs.value.objects.UserVO;

/**
 * Created by Hasnain on 12/1/2014.
 */
public interface IUserService extends IService {
    public UserVO findByUserNameAndPassword(UserVO userVO);
}
