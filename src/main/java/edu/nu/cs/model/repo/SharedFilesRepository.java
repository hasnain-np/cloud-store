package edu.nu.cs.model.repo;

import edu.nu.cs.model.entity.SharedFiles;
import edu.nu.cs.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Shared Files Repository
 *
 * @author Ayaz Ali Qureshi
 * @version 1.0
 */
@Repository
public interface SharedFilesRepository extends JpaRepository<SharedFiles, Long> {

    SharedFiles findByHash(String hash);
}
