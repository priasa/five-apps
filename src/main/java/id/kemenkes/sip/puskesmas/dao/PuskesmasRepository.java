package id.kemenkes.sip.puskesmas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.kemenkes.sip.puskesmas.entity.PuskesmasEntity;

@Repository
public interface PuskesmasRepository extends JpaRepository<PuskesmasEntity, String>{

	@Query("SELECT g FROM PuskesmasEntity g WHERE g.provinsi = ?1 and g.kabupaten = ?2")
	List<PuskesmasEntity> findByProvinsiAndKabupaten(int provinsi, int kabupaten);
}
