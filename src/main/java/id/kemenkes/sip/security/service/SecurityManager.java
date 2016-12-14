package id.kemenkes.sip.security.service;

import id.kemenkes.sip.common.security.util.HashSalt;
import id.kemenkes.sip.common.security.util.PasswordGeneratorUtil;
import id.kemenkes.sip.common.security.util.PasswordSalt;
import id.kemenkes.sip.common.user.util.UserUtils;
import id.kemenkes.sip.group.entity.Group;
import id.kemenkes.sip.group.entity.GroupPermission;
import id.kemenkes.sip.group.entity.PermissionDTO;
import id.kemenkes.sip.group.service.GroupService;
import id.kemenkes.sip.masterdata.entity.MasterData;
import id.kemenkes.sip.masterdata.service.MasterDataService;
import id.kemenkes.sip.user.entity.User;
import id.kemenkes.sip.user.service.UserService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service
public class SecurityManager {
    
	static final Logger LOGGER = LoggerFactory.getLogger(SecurityManager.class);
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private GroupService groupService;
    
    @Autowired
    private MasterDataService masterDataService; 
    
    @Autowired 
    private MessageSource messageSource;
    
    @PostConstruct
    public void init(){
        initAdminGroup();
        initUserGroup();
        initAdminUser();
        initAvailableServiceList();
    }
      
	@Transactional
    public void initAdminGroup(){
        
        Group adminGroup = groupService.getGroupByName(GroupService.ADMIN_GROUP_NAME);
        
        if(adminGroup == null){
            
            adminGroup = new Group();
            adminGroup.setName(GroupService.ADMIN_GROUP_NAME);
            
            for(String permission: groupService.getAllPermissionList()){
                GroupPermission adminPermission = new GroupPermission(permission);
                adminGroup.addPermission(adminPermission);
            }
            
            groupService.addGroup(adminGroup);
        }
    }
	
	@Transactional
    public void initUserGroup(){
        
        Group userGroup = groupService.getGroupByName(GroupService.USER_GROUP_NAME);
        
        if(userGroup == null){    
        	userGroup = new Group();
        	userGroup.setName(GroupService.USER_GROUP_NAME);
            
            groupService.addGroup(userGroup);
        }
    }
    
    @Transactional
    public void initAdminUser(){
        User adminUser = userService.getUserByUsername(UserService.ADMIN_EMAIL);
        
        if(adminUser == null){
            //create admin user with password admin
            adminUser = new User();
            adminUser.setUsername(UserService.ADMIN_EMAIL);
            adminUser.setFirstname(UserService.ADMIN_USER_NAME);
            adminUser.setLastname(UserService.ADMIN_USER_NAME);
            adminUser.setNickname(UserService.ADMIN_USER_NAME);
            adminUser.setStatus(User.STATUS.ACTIVE.getValue());
            adminUser.setEmail(UserService.ADMIN_EMAIL);
            
            Group adminGroup = groupService.getGroupByName(GroupService.ADMIN_GROUP_NAME);
            adminUser.setGroup(adminGroup);
            
            try{
                HashSalt hashSalt = PasswordGeneratorUtil.createNewHashWithSalt("admin");
                adminUser.setPassword(hashSalt.getHash());
                adminUser.setRandomSalt(hashSalt.getSalt());
            }
            catch(Exception e){
                LOGGER.error("Error in generating hash ", e);
            }
            
            userService.addUser(adminUser);
        }
        
    }
	
    @Transactional
    public void initAvailableServiceList() {
    	MasterData masterData = masterDataService.findMasterDataByName(MasterDataService.AVAILABLE_SERVICE_LIST);
    	if (masterData == null) {
    		masterData = new MasterData();
    		masterData.setName(MasterDataService.AVAILABLE_SERVICE_LIST);
    		
    		masterDataService.addData(masterData);
    	}
    }
    
    @Transactional
    public User authenticateUser(String username, String password) throws BadCredentialsException{
        
    	User user = userService.getActiveUserByUsername(username);
    	
        if(user == null){
            String errMsg = messageSource.getMessage("error.login.nonUser.error", null, "No user found", null);
            throw new BadCredentialsException(errMsg);
        }
        
        try{
            String hash  = PasswordGeneratorUtil.hashPassword(new PasswordSalt(user.getRandomSalt(), password));
            
            if(!StringUtils.equals(hash, user.getPassword())){
            	String errMsg = messageSource.getMessage("error.login.invalid", null, "Login invalid", null);
                throw new BadCredentialsException(errMsg);
            }
        }
        catch(NoSuchAlgorithmException e){
            LOGGER.error("Error in comparing user password", e);
            String errMsg = messageSource.getMessage("error.login.error", null, "Login error", null);
            throw new BadCredentialsException(errMsg);
        }
        catch(InvalidKeySpecException e){
            LOGGER.error("Error in comparing user password", e);
            String errMsg = messageSource.getMessage("error.login.error", null, "Login error", null);
            throw new BadCredentialsException(errMsg);
        }
        
        user.setPermissionList(convertPermissionListToDTO(user.getGroup().getPermissionList()));
        
        return user;
        
    }
    
    protected List<PermissionDTO> convertPermissionListToDTO(List<GroupPermission> permissionList){
        
        List<PermissionDTO> permissionDtoList = Lists.newArrayList();
        for(GroupPermission permission: permissionList){
            permissionDtoList.add(new PermissionDTO(permission.getPermissionKey()));
        }
        
        return permissionDtoList;
    }

    @Transactional
	public User findUserByUsername(String username) {
    	User user = userService.getActiveUserByUsername(username);
        if(user == null){
            String errMsg = messageSource.getMessage("error.login.nonUser.error", null, "No user found", null);
            throw new BadCredentialsException(errMsg);
        }
        
        return user;
	}

    @Transactional
	public User authenticateRestUser(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
    	User user = null;
    	String hashPassword = "";
    	if (UserUtils.isLoginByEmail(username)) {
    		user = userService.getActiveUserByEmail(username);
    	} else {
    		user = userService.getActiveUserByUsername(username);
    	}
        
        if(user == null){
            String errMsg = messageSource.getMessage("error.login.nonUser.error", null, "No user found", null);
            throw new BadCredentialsException(errMsg);
        } else {
        	hashPassword = PasswordGeneratorUtil.hashPassword(new PasswordSalt(user.getRandomSalt(), password));
        }
        
		if (!StringUtils.equals(hashPassword, user.getPassword())) {
			String errMsg = messageSource.getMessage("error.login.invalid", null, "Login invalid", null);
			throw new BadCredentialsException(errMsg);
		}
		
		user.setPermissionList(convertPermissionListToDTO(user.getGroup().getPermissionList()));
        
        return user;
	}

    @Transactional
	public User findUserByEmail(String email) {
    	User user = userService.getActiveUserByEmail(email);
        if(user == null){
            String errMsg = messageSource.getMessage("error.login.nonUser.error", null, "No user found", null);
            throw new BadCredentialsException(errMsg);
        }
        
        return user;
	}
    
}
