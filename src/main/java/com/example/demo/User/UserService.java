package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
