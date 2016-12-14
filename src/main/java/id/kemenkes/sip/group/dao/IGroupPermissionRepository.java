package id.kemenkes.sip.group.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.kemenkes.sip.group.entity.GroupPermission;

public interface IGroupPermissionRepository extends JpaRepository<GroupPermission, String>{
	
}
