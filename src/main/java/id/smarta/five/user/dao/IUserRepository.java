package id.smarta.five.user.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.smarta.five.user.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String>{
	
	public User findByUsernameAndStatus(String username, Integer status);
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	public Page<User> findAll(Specification<User> spec, Pageable page);

	public User findByEmailAndStatus(String email, Integer status);
	
	@Query("Select u from User u where u.status = 1")
	public List<User> findAllActiveUser();
	
}
