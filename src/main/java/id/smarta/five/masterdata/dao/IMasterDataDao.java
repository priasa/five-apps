package id.smarta.five.masterdata.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.smarta.five.masterdata.entity.MasterData;

public interface IMasterDataDao extends JpaRepository<MasterData, String>{
    
    @Query("SELECT md FROM MasterData md WHERE md.name LIKE ?1 ")
    public Page<MasterData> findMDByName(String wildCardName, Pageable page);
    
    @Query("SELECT md FROM MasterData md WHERE md.name = ?1 ")
	public MasterData findMDByName(String name);

}
