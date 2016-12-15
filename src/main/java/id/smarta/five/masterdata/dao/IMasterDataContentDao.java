package id.smarta.five.masterdata.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.smarta.five.masterdata.entity.MasterDataContent;

public interface IMasterDataContentDao extends JpaRepository<MasterDataContent, String>{

    @Query("SELECT mdc FROM MasterDataContent mdc WHERE mdc.parentId.id = ?1 ")
    public Page<MasterDataContent> findMDContentByParentId(String id, Pageable page);

    @Query("SELECT mdc FROM MasterDataContent mdc WHERE mdc.parentId.id = ?1 ")
    public List<MasterDataContent> getMDContentByParentId(String parentId);
    
    @Query("SELECT mdc FROM MasterDataContent mdc WHERE mdc.id = ?1 AND mdc.parentId.id = ?2")
    public MasterDataContent getContentById(String id, String parentId);

    @Query("SELECT mdc FROM MasterDataContent mdc WHERE mdc.parentId.id = ?1 ")
    public List<MasterDataContent> getContentByParentId(String parentId);

    @Query("SELECT mdc FROM MasterDataContent mdc WHERE mdc.code = ?1 AND mdc.parentId.id = ?2")
	public MasterDataContent findContentByCode(String code, String parentId);

    @Query("SELECT mdc FROM MasterDataContent mdc WHERE mdc.parentId.id = ?1 ")
	public List<MasterDataContent> getMDContentParentById(String id);
    
}
