package edu.nu.cs.security;

import edu.nu.cs.service.interfaces.IUserService;
import edu.nu.cs.service.util.ServiceConstants;
import edu.nu.cs.service.util.ServiceLocator;
import edu.nu.cs.util.UtilityMethods;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Hasnain on 11/29/2014.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication authentication) {
        if (authentication.getPrincipal() != null && authentication.getCredentials() != null) {
            IUserService userService = (IUserService)ServiceLocator.getService(ServiceConstants.USER_SERVICE);

            UserVO user = new UserVO();

            user.setUserName(authentication.getPrincipal().toString());
            user.setPassword(UtilityMethods.getMD5(authentication.getCredentials().toString()));
            user = userService.findByUserNameAndPassword(user);

            // if(user!=null && user.getUserId() != null && !user.getUserType().equals(IConstants.User_Type_Blocked))

            if (user != null && user.getUserID() != null) {
                return new UsernamePasswordAuthenticationToken(
                        authentication.getName(),
                        authentication.getCredentials(), new ArrayList<GrantedAuthority>());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
