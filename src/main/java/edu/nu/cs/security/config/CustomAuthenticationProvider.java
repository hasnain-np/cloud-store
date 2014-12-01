package edu.nu.cs.security.config;

import edu.nu.cs.service.ServiceLocator;
import edu.nu.cs.constants.Constants;
import edu.nu.cs.service.UserService;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * Created by Hasnain on 11/29/2014.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication authentication) {
        if (authentication.getPrincipal() != null && authentication.getCredentials() != null) {
            UserService userService = (UserService)ServiceLocator.getService(Constants.USER_SERVICE);

            UserVO user= new UserVO();
            user.setUserName(authentication.getPrincipal().toString());
            user.setPassword(authentication.getCredentials().toString());
            user = userService.findByUserNameAndPassword(user);

            // if(user!=null && user.getUserId() != null && !user.getUserType().equals(IConstants.User_Type_Blocked))

            if (user != null && user.getUserID() != null) {
                return new UsernamePasswordAuthenticationToken(
                        authentication.getName(),
                        authentication.getCredentials());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
