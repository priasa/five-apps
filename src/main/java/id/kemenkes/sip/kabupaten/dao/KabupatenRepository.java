package id.kemenkes.sip.kabupaten.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.kemenkes.sip.kabupaten.entity.KabupatenEntity;

@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer>{
	
	List<KabupatenEntity> findByProvinsi(Integer provinsi);

}
