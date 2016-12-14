package id.kemenkes.sip.laporan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.kemenkes.sip.laporan.entity.LaporanEntity;

@Repository
public interface LaporanRepository extends JpaRepository<LaporanEntity, String>{
	
}
