package edu.nu.cs.service.impl;

import edu.nu.cs.converter.UserConverter;
import edu.nu.cs.model.entity.User;
import edu.nu.cs.model.repo.UserRepository;
import edu.nu.cs.service.util.ServiceConstants;
import edu.nu.cs.service.interfaces.IUserService;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Hasnain on 11/29/2014.
 */

@Repository(value = ServiceConstants.USER_SERVICE)
@Transactional(readOnly = true)
public class UserService implements IUserService {

    @Resource
    UserRepository userRepository;

    public UserVO findByUserNameAndPassword(UserVO userVO){
        User user = userRepository.findByUserNameAndPassword(userVO.getUserName(), userVO.getPassword());

        return (UserVO)UserConverter.getInstance().convertToValueObject(user);
    }
}