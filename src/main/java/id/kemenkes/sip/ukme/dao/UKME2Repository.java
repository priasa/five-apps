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

import id.kemenkes.sip.ukme.entity.UKME2;


/**
 * 
 * @author X230
 *
 */
@Repository("ukme2Repository")
public class UKME2Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKME2Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKME2 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKME2 getById(String id) {
		return mongoTemplate.findById(id, UKME2.class);
	}

	public Page<UKME2> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKME2> content = mongoTemplate.find(query, UKME2.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKME2> result = new PageImpl<UKME2>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKME2.class);

		return counter;
	}
	
	public void deleteById(String id) {
		UKME2 ukme2 = mongoTemplate.findById(id, UKME2.class);
		mongoTemplate.remove(ukme2);
	}

}
