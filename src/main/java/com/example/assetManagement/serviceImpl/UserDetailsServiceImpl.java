package com.example.assetManagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.assetManagement.domain.UserDomain;
import com.example.assetManagement.model.UserModel;
import com.example.assetManagement.model.UserPrinciple;
import com.example.assetManagement.repository.UserRepository;
import com.example.assetManagement.service.IUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService,IUserService {

	@Autowired
    UserRepository userRepository;
 
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
      
        UserDomain user = userRepository.findByUsername(username)
                  .orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );
 
        return UserPrinciple.build(user);
    }

	@Override
	public List<UserModel> getAll() {
		List<UserDomain> users=userRepository.findAll();
		List<UserModel> UserModels=new ArrayList<>();
		users.forEach(user->{
			UserModel userModel=new UserModel();
			userModel.setUserId(user.getUserId());
			userModel.setEmail(user.getEmail());
			userModel.setName(user.getName());
			userModel.setUsername(user.getUsername());
			
			userModel.setPassword(user.getPassword());
			UserModels.add(userModel);
			
			
		});
		
		
		
		return UserModels;
	}
}
