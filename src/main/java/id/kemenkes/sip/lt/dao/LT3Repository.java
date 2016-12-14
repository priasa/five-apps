package id.kemenkes.sip.lt.dao;

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

import id.kemenkes.sip.lt.entity.LT3;


/**
 * 
 * @author X230
 *
 */
@Repository("lt3Repository")
public class LT3Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(LT3Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(LT3 entity) {
		mongoTemplate.save(entity);
	}
	
	public LT3 getById(String id) {
		return mongoTemplate.findById(id, LT3.class);
	}

	public Page<LT3> getByFilter(String kodePuskesmas, int tahun, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		query.with(page);

		List<LT3> content = mongoTemplate.find(query, LT3.class);		
		long size = countByFilter(kodePuskesmas, tahun);
		PageImpl<LT3> result = new PageImpl<LT3>(content, page, size);
		
		return result;		
	}

	
	public long countByFilter(String kodePuskesmas, int tahun) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		long counter = mongoTemplate.count(query, LT3.class);

		return counter;
	}

	public void deleteById(String id) {
		LT3 lt3 = this.getById(id);
		mongoTemplate.remove(lt3);
	}
}
