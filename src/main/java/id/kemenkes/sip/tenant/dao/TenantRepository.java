package id.kemenkes.sip.tenant.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.kemenkes.sip.tenant.entity.TenantEntity;

@Repository
public interface TenantRepository extends JpaRepository<TenantEntity, String>{

	public Page<TenantEntity> findByTenantCode(String tenantCode,Pageable page);
	
	@Query("SELECT g FROM TenantEntity g  WHERE g.tenantCode = ?1")
	public TenantEntity findByTenantCode(String requestNumber);
	
	@Query("SELECT g FROM TenantEntity g WHERE g.tenantCode LIKE ?1")
	public Page<TenantEntity> findByLikeTenantCode(String tenantCode, Pageable page);

	@Query("SELECT g FROM TenantEntity g  WHERE g.tokenId = ?1")
	public TenantEntity findByTokenId(String tokenId);

}
