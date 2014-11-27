package edu.nu.cs.model.repo;

import edu.nu.cs.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Hasnain on 11/26/14.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
