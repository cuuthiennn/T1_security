package javasecurity.t1_security.dbo;

import javasecurity.t1_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return CustomUserDetails.convert(userService.getAllUser().stream()
                .filter(user -> user.getMail().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Email not exis!")));
    }
}
