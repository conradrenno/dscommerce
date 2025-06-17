package com.devrenno.dscommerce.services;

import com.devrenno.dscommerce.dto.UserDetailsProjection;
import com.devrenno.dscommerce.entities.Authority;
import com.devrenno.dscommerce.entities.User;
import com.devrenno.dscommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetailsProjection> result = repository.searchUserAndAuthoritiesByEmail(username);

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("Email not found");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());
        for (UserDetailsProjection u : result) {
            user.addAuthorities(new Authority(u.getAuthorityId(), u.getAuthority()));
        }

        return user;
    }
}
