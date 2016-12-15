package id.smarta.five.user.service;

import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import id.smarta.five.common.security.util.HashSalt;
import id.smarta.five.common.security.util.PasswordGeneratorUtil;
import id.smarta.five.common.util.CommonUtil;
import id.smarta.five.group.entity.Group;
import id.smarta.five.group.service.GroupService;
import id.smarta.five.home.ResetPasswordForm;
import id.smarta.five.user.dao.IUserRepository;
import id.smarta.five.user.dao.UserSpecifications;
import id.smarta.five.user.entity.User;
import id.smarta.five.user.entity.UserDTO;
import id.smarta.five.user.entity.UserProfileDTO;

@Service
public class UserService {
	
	static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	public static String ADMIN_USER_NAME = "admin";
	public static final int DEFAULT_PASSWORD_LENGTH = 8;
	public static final String ADMIN_EMAIL = "admin@admin.com";
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private GroupService groupService;
	
	public Page<User> getUserByUsernameFirstnameLastnameGroup(String username, String firstname, String lastname, String groupId, Pageable page){
		String usernameWc = CommonUtil.addWildCard(username);
		String firstnameWc = CommonUtil.addWildCard(firstname);
		String lastnameWc = CommonUtil.addWildCard(lastname);
		
		return userRepo.findAll(UserSpecifications.byLikeUsernameFirstnameLastnameGroupId(usernameWc, firstnameWc, lastnameWc, groupId), page);
	}
	
	public User addUser(UserDTO form) {
		User savedUser = null;
		HashSalt hashSalt = null;
		try {
	    	User user = new User();
			PropertyUtils.copyProperties(user, form);
			user.setId(null);
		    user.setEmail(user.getUsername());
		    
		    Group group = groupService.getGroupById(form.getGroupId());
	        user.setGroup(group);
		    
		    hashSalt = PasswordGeneratorUtil.createNewHashWithSalt(form.getPassword());
		    user.setPassword(hashSalt.getHash());
		    user.setRandomSalt(hashSalt.getSalt());
		    user.setStatus(form.getStatus());
		    savedUser = userRepo.save(user);
		} catch (IllegalAccessException e) {
			LOGGER.error(e.getMessage());
		} catch (InvocationTargetException e) {
			LOGGER.error(e.getMessage());
		} catch (NoSuchMethodException e) {
			LOGGER.error(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.getMessage());
		} catch (InvalidKeySpecException e) {
			LOGGER.error(e.getMessage());
		} 
	    
	    return savedUser;
	}
	
	public void updateUserProfile(UserProfileDTO form) throws DataIntegrityViolationException, Exception{
        
        User user = userRepo.findOne(form.getId());
        user.setAddress(form.getAddress());
        user.setFirstname(form.getFirstname());
        user.setLastname(form.getLastname());
        user.setNickname(form.getNickname());
        
        //update password
        HashSalt hashSalt = null;
        if(!StringUtils.isEmpty(form.getPassword())){
            hashSalt = PasswordGeneratorUtil.createNewHashWithSalt(form.getPassword());
            user.setPassword(hashSalt.getHash());
            user.setRandomSalt(hashSalt.getSalt());
        }
        
        userRepo.save(user);
    } 
	
	public User updateUser(UserDTO form) throws DataIntegrityViolationException, Exception{
	    
		User user = userRepo.findOne(form.getId());
	    
	    user.setAddress(form.getAddress());
	    user.setFirstname(form.getFirstname());
        user.setLastname(form.getLastname());
	    user.setNickname(form.getNickname());
	    user.setStatus(form.getStatus());
	   
	    //update password
	    HashSalt hashSalt = null;
        if(!StringUtils.isEmpty(form.getPassword())){
        	hashSalt = PasswordGeneratorUtil.createNewHashWithSalt(form.getPassword());
            user.setPassword(hashSalt.getHash());
            user.setRandomSalt(hashSalt.getSalt());
        }
        
	    Group group = groupService.getGroupById(form.getGroupId());
	    user.setGroup(group);
	    
	    User savedUser = userRepo.save(user);
	    return savedUser;
	}
	
	public User getUserByUsername(String username){
	    return userRepo.findByUsername(username);
	}
	
	public User getActiveUserByUsername(String username){
	    return userRepo.findByUsernameAndStatus(username, User.STATUS.ACTIVE.getValue());
	}
	
	public void deleteUserById(String id){
		userRepo.delete(id);
	}
	
	public void deleteUser(User user){
		userRepo.delete(user);
	}
	
	public User addUser(User user){
		return userRepo.save(user);
	}
	
	public User updateUser(User user){
		return userRepo.save(user);
	}
	
	public User getUserById(String id){
		return userRepo.findOne(id);
	}
	
	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public User getActiveUserByEmail(String email) {
		return userRepo.findByEmailAndStatus(email, User.STATUS.ACTIVE.getValue());
	}

	public void updatePassword(ResetPasswordForm resetPasswordForm) throws NoSuchAlgorithmException, InvalidKeySpecException {
		User user = getUserByUsername(resetPasswordForm.getUsername());
		if (user != null) {
			HashSalt hashSalt = PasswordGeneratorUtil.createNewHashWithSalt(resetPasswordForm.getPassword());
			user.setPassword(hashSalt.getHash());
			user.setRandomSalt(hashSalt.getSalt());
			user.setNeedToActivation("NO NEEDED");
			userRepo.save(user);
		}
	}

	public List<User> getAllActiveUsers() {
		return userRepo.findAllActiveUser();
	}
	
	public void saveUserList(List<User> userList) {
		userRepo.save(userList);
	}
	
}
