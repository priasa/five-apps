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

import id.kemenkes.sip.lt.entity.LT2;


/**
 * 
 * @author X230
 *
 */
@Repository("lt2Repository")
public class LT2Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(LT2Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(LT2 entity) {
		mongoTemplate.save(entity);
	}
	
	public LT2 getById(String id) {
		return mongoTemplate.findById(id, LT2.class);
	}

	public Page<LT2> getByFilter(String kodePuskesmas, int tahun, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		query.with(page);

		List<LT2> content = mongoTemplate.find(query, LT2.class);		
		long size = countByFilter(kodePuskesmas, tahun);
		PageImpl<LT2> result = new PageImpl<LT2>(content, page, size);
		
		return result;		
	}

	
	public long countByFilter(String kodePuskesmas, int tahun) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		long counter = mongoTemplate.count(query, LT2.class);

		return counter;
	}

	public void deleteById(String id) {
		LT2 lt2 = this.getById(id);
		mongoTemplate.remove(lt2);
	}
}
