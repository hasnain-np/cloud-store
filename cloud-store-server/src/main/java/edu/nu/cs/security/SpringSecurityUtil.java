package edu.nu.cs.security;

import edu.nu.cs.service.util.ServiceConstants;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hasnain on 12/4/14.
 */

@Repository(value = ServiceConstants.SPRING_SECURITY_UTIL)
@Transactional(readOnly = true)
public class SpringSecurityUtil {
    public static final String ANONYMOUS_USER = "anonymousUser";
    public boolean isAuthenticated(){
        return SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                !ANONYMOUS_USER.equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
