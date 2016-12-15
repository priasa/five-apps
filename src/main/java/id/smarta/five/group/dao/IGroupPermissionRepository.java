package id.smarta.five.group.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.smarta.five.group.entity.GroupPermission;

public interface IGroupPermissionRepository extends JpaRepository<GroupPermission, String>{
	
}
