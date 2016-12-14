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

import id.kemenkes.sip.ukme.entity.UKME7;


/**
 * 
 * @author X230
 *
 */
@Repository("ukme7Repository")
public class UKME7Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKME7Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKME7 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKME7 getById(String id) {
		return mongoTemplate.findById(id, UKME7.class);
	}

	public Page<UKME7> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKME7> content = mongoTemplate.find(query, UKME7.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKME7> result = new PageImpl<UKME7>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKME7.class);

		return counter;
	}
	
	public void deleteById(String id) {
		UKME7 ukme7 = this.getById(id);
		mongoTemplate.remove(ukme7);
	}

}
