package com.example.demo.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
@Component
public class UserFileDetailsService implements UserDetailsService {
	@Autowired
	private  UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userInfo = repo.findByEmail(username);
		return userInfo.map(UserFileToUserDetails::new)
			.orElseThrow(()->new UsernameNotFoundException("User Not Found"));
	}

}
