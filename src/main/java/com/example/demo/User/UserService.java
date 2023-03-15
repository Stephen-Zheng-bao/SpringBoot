package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
    private final UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(int users) {
        userRepository.deleteById(users);
    }



	public void updateRole(Integer userID, String role) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userID).get();
		String temp = user.getRoles();
		temp=temp+","+role;
		System.out.println(temp);
		user.setRoles(temp);
		userRepository.save(user);
		
	}



	public Integer findByEmail(String userEmail) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(userEmail).get();
		return user.getUserID();
	}

	public boolean checkEmailUnique(String userEmail){
		Optional<User> user = userRepository.findByEmail(userEmail);
		if (user.isPresent()){
			return false;
		}
		else{
			return true;
		}
	}

	public List<User> fetchByName(String name) {
		return userRepository.findByName(name);
		
	}
	public Integer getIDOfCurrentUser(){
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = user.getName();
		return findByEmail(userEmail);
	}
}
