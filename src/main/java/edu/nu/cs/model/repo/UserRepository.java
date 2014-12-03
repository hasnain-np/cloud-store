package edu.nu.cs.model.repo;

import edu.nu.cs.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hasnain on 11/26/14.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //@Query("SELECT u FROM User u WHERE u.userName = :user_name AND u.password = :password")
//    public UserVO findByUserAndPassword(@Param("userName") String userName, @Param("password") String password);


    User findByUserNameAndPassword(String username, String password);
}
