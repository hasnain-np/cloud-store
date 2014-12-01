package edu.nu.cs.service;

import edu.nu.cs.constants.Constants;
import edu.nu.cs.model.entity.User;
import edu.nu.cs.model.repo.UserRepository;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Hasnain on 11/29/2014.
 */
@Repository(value = Constants.USER_SERVICE)
@Transactional(readOnly = true)
public class UserService implements IService{

    @Resource
    UserRepository userRepository;

    public User findByUserNameAndPassword(UserVO user){
        return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
    }
}
