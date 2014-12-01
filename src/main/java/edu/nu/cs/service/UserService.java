package edu.nu.cs.service;

import edu.nu.cs.constants.Constants;
import edu.nu.cs.model.repo.UserRepository;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hasnain on 11/29/2014.
 */
@Service(value = Constants.USER_SERVICE)
public class UserService implements IService{
    @Autowired
    UserRepository userRepository;

    public UserVO findByUserNameAndPassword(UserVO user){
        return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
    }
}
