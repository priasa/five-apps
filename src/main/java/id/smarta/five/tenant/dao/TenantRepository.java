package id.smarta.five.tenant.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.smarta.five.tenant.entity.Tenant;

/**
 * 
 * @author X230
 *
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, String>{
	
	@Query("SELECT g FROM Tenant g WHERE g.name LIKE ?1")
	public Page<Tenant> findByLikeName(String name, Pageable page);

	@Query("SELECT g FROM Tenant g WHERE g.token = ?1")
	public Tenant findByToken(String token);

}
