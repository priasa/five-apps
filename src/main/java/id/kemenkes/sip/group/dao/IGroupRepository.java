package id.kemenkes.sip.group.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.kemenkes.sip.group.entity.Group;

public interface IGroupRepository extends JpaRepository<Group, String>{
	
	public Group findOneByName(String name);
	
	@Query("SELECT COUNT(*) FROM Group WHERE name = ?1")
	public Long countByName(String name);
	
	public List<Group> findAll(Sort sort);
	
	@Query("SELECT g FROM Group g WHERE g.name LIKE ?1")
	public Page<Group> findByLikeName(String name, Pageable page);
}
