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

import id.kemenkes.sip.lt.entity.LT1;


/**
 * 
 * @author X230
 *
 */
@Repository("lt1Repository")
public class LT1Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(LT1Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(LT1 entity) {
		mongoTemplate.save(entity);
	}
	
	public LT1 getById(String id) {
		return mongoTemplate.findById(id, LT1.class);
	}

	public Page<LT1> getByFilter(String kodePuskesmas, int tahun, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		query.with(page);

		List<LT1> content = mongoTemplate.find(query, LT1.class);		
		long size = countByFilter(kodePuskesmas, tahun);
		PageImpl<LT1> result = new PageImpl<LT1>(content, page, size);
		
		return result;		
	}

	
	public long countByFilter(String kodePuskesmas, int tahun) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		long counter = mongoTemplate.count(query, LT1.class);

		return counter;
	}

	public void deleteById(String id) {
		LT1 lt1 = this.getById(id);
		mongoTemplate.remove(lt1);
	}
}
