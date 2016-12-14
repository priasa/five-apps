package id.kemenkes.sip.icd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.kemenkes.sip.icd.entity.BpjsIcdEntity;

@Repository
public interface BpjsIcdRepository extends JpaRepository<BpjsIcdEntity, String>{

	@Query("SELECT p FROM BpjsIcdEntity p WHERE p.namaDiagnosa LIKE :diagnosa%")
	public Page<BpjsIcdEntity> findLikeNamaDiagnosa(@Param("diagnosa") String diagnosa, Pageable page);

}

