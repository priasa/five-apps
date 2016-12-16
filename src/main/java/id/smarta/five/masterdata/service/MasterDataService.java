package id.smarta.five.masterdata.service;

import id.smarta.five.common.util.CommonUtil;
import id.smarta.five.masterdata.dao.IMasterDataContentDao;
import id.smarta.five.masterdata.dao.IMasterDataDao;
import id.smarta.five.masterdata.entity.MasterData;
import id.smarta.five.masterdata.entity.MasterDataContent;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MasterDataService {
    
    static final Logger LOGGER = LoggerFactory.getLogger(MasterDataService.class);

	public static final String DEFAULT_PRODUCT_TYPE = "DEFAULT_PRODUCT_TYPE";
	public static final String GNEWS = "GNEWS";
	
	public static final String _ADD = "_ADD";
	public static final String _VIEW = "_VIEW";
	public static final String _UPDATE = "_UPDATE";
	public static final String _DELETE = "_DELETE";

	public static final String AVAILABLE_SERVICE_LIST = "AVAILABLE_SERVICE_LIST";

	public static final String YOUTUBE = "YOUTUBE";

	@Autowired
    IMasterDataDao mdDao;
    
    @Autowired
    IMasterDataContentDao mdContentDao;
        
    public Page<MasterData> findAll(Pageable page){
        return mdDao.findAll(page);
    }
    
    public List<MasterData> findAll(){
        return mdDao.findAll();
    }

    public Page<MasterData> getMDByName(String name, Pageable page) {
        String wildCardName = CommonUtil.addWildCard(name);
        return mdDao.findMDByName(wildCardName,page);
    }

    public MasterData findMasterDataByName(String name) {
        return mdDao.findMDByName(name);
    }
    
    public MasterData addData(MasterData mdForm) {
        return mdDao.save(mdForm);
    }

    public void updateData(MasterData mdForm) {
        MasterData md = mdDao.findOne(mdForm.getId());
        if(md!=null && md.getId()!=null){
        	List<MasterDataContent> contents = mdContentDao.getContentByParentId(mdForm.getId());
        	if (contents != null) {
        		for (MasterDataContent content : contents) {
        			mdContentDao.delete(content.getId());
        		}
        	}
            mdDao.save(mdForm);
        }
    }
    
    public MasterData getMDById(String id){
        return mdDao.findOne(id);
    }

    public Page<MasterDataContent> getMDContentParentById(String id, Pageable page) {
        return mdContentDao.findMDContentByParentId(id,page);
    }
    
    public List<MasterDataContent> getMDContentByParentId(String parentId){
        return mdContentDao.getMDContentByParentId(parentId);
    }
    
    public MasterDataContent addContent(MasterDataContent mdcForm){
        return mdContentDao.save(mdcForm);
    }
    
    public void updateContent(MasterDataContent mdcForm) {
        MasterDataContent mdc = mdContentDao.findOne(mdcForm.getId());
        if(mdc!=null && mdc.getId()!=null){
            mdContentDao.save(mdcForm);
        }
    }
    
    public MasterDataContent getContentById(String id, String parentId){
        return mdContentDao.getContentById(id, parentId);
    }

    public void deleteMDById(String id) {
    	List<MasterDataContent> contents = mdContentDao.getContentByParentId(id);
    	if (contents != null) {
    		for (MasterDataContent content : contents) {
    			mdContentDao.delete(content.getId());
    		}
    	}
        mdDao.delete(id);
    }

    public MasterDataContent getMdContentById(String id) {
        return mdContentDao.findOne(id);
    }

	public MasterDataContent findContentByCode(String code, String parentId) {
		return mdContentDao.findContentByCode(code, parentId);
	}

	public List<MasterDataContent> getMDContentParentById(String id) {
		return mdContentDao.getMDContentParentById(id);
	}
}
