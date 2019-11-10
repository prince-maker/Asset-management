package com.example.assetManagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.assetManagement.domain.EquipmentMaster;
import com.example.assetManagement.domain.Role;
import com.example.assetManagement.domain.UserDomain;
import com.example.assetManagement.model.AccessPolicyModel;
import com.example.assetManagement.model.EquipmentMasterModel;
import com.example.assetManagement.model.RoleModel;
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
			//UserModels.add(userModel);
			if(user.getReportingTo()!=null) {
			UserDomain user1 = userRepository.findById(user.getReportingTo()).orElseThrow(()->new RuntimeException("ReportingTo id not found"));

			userModel.setReportingId(user1.getUserId());
			userModel.setReportingTo(user1.getUsername());
			}
			RoleModel roleModel=new RoleModel();
			List<AccessPolicyModel> accessPolicyModels=new ArrayList<>();
			BeanUtils.copyProperties(user.getRoles(), roleModel);
			userModel.setRoles(roleModel);
			user.getRoles().getAccessPolicyDomain().forEach(f->{
				AccessPolicyModel accessPolicyModel=new AccessPolicyModel();
				accessPolicyModel.setAccessPolicyId(f.getAccessPolicyId());
				accessPolicyModel.setAccessPolicyname(f.getAccessPolicyname());
				accessPolicyModel.setDescription(f.getDescription());
				accessPolicyModels.add(accessPolicyModel);
			
			});
			
			
			
			userModel.getRoles().setAccessPolicyModel(accessPolicyModels);
			UserModels.add(userModel);
			
		});
		
		
		
		return UserModels;
	}

	@Override
	public UserDomain findByUserName(String name) {
		UserDomain user = userRepository.findByUsername(name)
                .orElseThrow(() -> 
                      new UsernameNotFoundException("User Not Found with -> username or email : " + name)
      );
		return user;
	}

	@Override
	public UserModel getByUserId(Long id) {
		
		UserDomain user;
		try {
			user = userRepository.findById(id).orElseThrow(()->new RuntimeException("user id not found"));
			//UserDomain user1 = userRepository.findById(user.getReportingTo()).orElseThrow(()->new RuntimeException("ReportingTo id not found"));
			UserModel userModel=new UserModel();
			BeanUtils.copyProperties(user, userModel);
			if(user.getReportingTo()!=null) {
				UserDomain user1 = userRepository.findById(user.getReportingTo()).orElseThrow(()->new RuntimeException("ReportingTo id not found"));

			userModel.setReportingId(user1.getUserId());
			userModel.setReportingTo(user1.getUsername());

			}
			RoleModel roleModel=new RoleModel();
			List<AccessPolicyModel> accessPolicyModels=new ArrayList<>();
			BeanUtils.copyProperties(user.getRoles(), roleModel);
			userModel.setRoles(roleModel);
			user.getRoles().getAccessPolicyDomain().forEach(f->{
				AccessPolicyModel accessPolicyModel=new AccessPolicyModel();
				accessPolicyModel.setAccessPolicyId(f.getAccessPolicyId());
				accessPolicyModel.setAccessPolicyname(f.getAccessPolicyname());
				accessPolicyModel.setDescription(f.getDescription());
				accessPolicyModels.add(accessPolicyModel);
			
			});
			
			
			
			userModel.getRoles().setAccessPolicyModel(accessPolicyModels);
		
			return userModel;
			} catch (RuntimeException e) {
	
				throw e;
	}
	}
}
