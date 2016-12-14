package id.kemenkes.sip.user.bean;

import id.kemenkes.sip.common.dao.QueryConditionParams;
import id.kemenkes.sip.user.dao.IUserRepository;
import id.kemenkes.sip.user.entity.User;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
	
	static final Logger LOGGER = LoggerFactory.getLogger(UserManager.class);
	
	@Autowired
	private IUserRepository userRepo;
	
	public User getUserByUsername(String username){
		return userRepo.findByUsername(username);
	}
		
	protected QueryConditionParams constructGetUserByUsernameFullnameConditionAndParams(String username, String fullname){
		QueryConditionParams condParam = new QueryConditionParams();
		
		StringBuilder conditions = new StringBuilder("1=1 ");
		List<String> paramList = new ArrayList<String>();
		
		if(!StringUtils.isEmpty(username)){
			conditions.append(" AND username LIKE ? ");
			paramList.add(constructLikeParam(username));
		}
		
		if(!StringUtils.isEmpty(fullname)){
			conditions.append(" AND fullname LIKE ? ");
			paramList.add(constructLikeParam(fullname));
		}
		
		condParam.setCondition(conditions.toString());
		condParam.setParams(paramList.toArray());
		
		return condParam;
	}
	
	protected String constructLikeParam(String param){
		StringBuilder result = new StringBuilder("%");
		result.append(param).append("%");
		return result.toString();
	}
	
	public void deleteUserById(String id){
		userRepo.delete(id);
	}
	
	public void deleteUser(User user){
		userRepo.delete(user);
	}
	
	public void addUser(User user){
		userRepo.save(user);
	}
	
	public void updateUser(User user){
		userRepo.save(user);
	}
	
	public User getUserById(String id){
		return userRepo.findOne(id);
	}
	
}
