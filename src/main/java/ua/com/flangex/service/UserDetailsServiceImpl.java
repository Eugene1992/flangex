package ua.com.flangex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.flangex.model.User;
import ua.com.flangex.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link UserDetailsService} implementation which allows to perform user
 * authentication on the basis of data obtained from {@link UserService}
 *
 * @author Evgeniy Deyneka
 * @version 1.0
 * @see UserDetailsService
 * @see UserRepository
 */
@Service("user-details")
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    /**
     * On the basis of the user credentials create {@link UserDetails} object which
     * will check the entered user login and password, and then authenticate the user or not.
     * @param username - username credential. {@link User#email} in our case.
     * @return {@link UserDetails} instance
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(username);
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        roles);

        return userDetails;
    }
}
