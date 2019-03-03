package com.viettel.services.sso.auth.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.viettel.services.sso.auth.config.CustomUserDetail;
import com.viettel.services.sso.auth.model.UsersEntity;
import com.viettel.services.sso.auth.repository.UserRepository;

/**
 * @author TungBoom
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetail customUserDetail = new CustomUserDetail();
	    UsersEntity userFromDataBase = userRepository.findOneByUsername(username);
	    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (userFromDataBase == null) {
			LOGGER.info("User " + username + " was not found in the database");
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        } else {
        	grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
			customUserDetail.setUsersEntity(userFromDataBase);
			customUserDetail.setAuthorities(grantedAuthorities);
			customUserDetail.setAccountNonLocked(true);
			customUserDetail.setAccountNonExpired(true);
			customUserDetail.setCredentialsNonExpired(true);
        }
        return customUserDetail;
	}
}