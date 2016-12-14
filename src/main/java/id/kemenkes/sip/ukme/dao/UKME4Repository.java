package id.kemenkes.sip.ukme.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import id.kemenkes.sip.ukme.entity.UKME4;


/**
 * 
 * @author X230
 *
 */
@Repository("ukme4Repository")
public class UKME4Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKME4Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKME4 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKME4 getById(String id) {
		return mongoTemplate.findById(id, UKME4.class);
	}

	public Page<UKME4> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKME4> content = mongoTemplate.find(query, UKME4.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKME4> result = new PageImpl<UKME4>(content, page, size);
		
		return result;		
	}

	
	public long countByFilter(String kodePuskesmas, int tahun, int bulan) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		long counter = mongoTemplate.count(query, UKME4.class);

		return counter;
	}

	public void deleteById(String id) {
		UKME4 ukme4 = this.getById(id);
		mongoTemplate.remove(ukme4);
	}
}
