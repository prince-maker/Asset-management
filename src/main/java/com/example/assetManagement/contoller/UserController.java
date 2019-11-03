package com.example.assetManagement.contoller;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assetManagement.domain.Role;
import com.example.assetManagement.domain.UserDomain;
import com.example.assetManagement.model.EquipmentMasterModel;
import com.example.assetManagement.model.JwtResponse;
import com.example.assetManagement.model.LoginForm;
import com.example.assetManagement.model.UserModel;
import com.example.assetManagement.model.UserPrinciple;
import com.example.assetManagement.repository.RoleRepository;
import com.example.assetManagement.repository.UserRepository;
import com.example.assetManagement.securityConfig.JwtProvider;
import com.example.assetManagement.service.IUserService;
import com.example.assetManagement.utlis.RoleName;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/auth")
public class UserController {
	
	@Autowired
    AuthenticationManager authenticationManager;
 
    @Autowired
    UserRepository userRepository;
 
    @Autowired
    RoleRepository roleRepository;
 
    @Autowired
    PasswordEncoder encoder;
 
    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    IUserService userService;
    
   
    
    
    
 
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser( @RequestBody LoginForm loginRequest) {
 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
 
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        String jwt = jwtProvider.generateJwtToken(userPrincipal);
        return ResponseEntity.ok(new JwtResponse(jwt,userPrincipal.getId()));
    }
 
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody UserModel signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
 
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        UserDomain user = new UserDomain(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
 
       
       // Role roles = new Role();
 
    
          switch(signUpRequest.getRole()) {
          case "CENTRAL_OFFICER":
            Role adminRole = roleRepository.findByName(RoleName.CENTRAL_OFFICER)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
            user.setRoles(adminRole);
            break;
          case "REGIONAL_OFFICER":
                Role pmRole = roleRepository.findByName(RoleName.STORE_MANAGER)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                user.setRoles(pmRole);
                
            break;
          default:
              Role userRole = roleRepository.findByName(RoleName.STORE_MANAGER)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
              user.setRoles(userRole);              
          }
      
        
       
        userRepository.save(user);
 
        return ResponseEntity.ok().body("User registered successfully!");
    }
	
	@GetMapping("/getall")
	 public ResponseEntity<?> getAll() {
		List<UserModel> userModel=userService.getAll();
	    
        
 
        
        return new ResponseEntity<>(userModel,HttpStatus.OK);
    }
 
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getByUserId(@PathVariable("id") Long id){
		UserModel userModel=userService.getByUserId(id);
		
		return new ResponseEntity<>(userModel,HttpStatus.OK);
		
	}
	

}
