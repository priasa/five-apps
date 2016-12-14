package id.kemenkes.sip.provinsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.kemenkes.sip.provinsi.entity.ProvinsiEntity;

@Repository
public interface ProvinsiRepository extends JpaRepository<ProvinsiEntity, Integer>{

}
