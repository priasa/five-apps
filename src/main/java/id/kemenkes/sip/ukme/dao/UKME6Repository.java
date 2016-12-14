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

import id.kemenkes.sip.ukme.entity.UKME6;


/**
 * 
 * @author X230
 *
 */
@Repository("ukme6Repository")
public class UKME6Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKME6Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKME6 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKME6 getById(String id) {
		return mongoTemplate.findById(id, UKME6.class);
	}

	public Page<UKME6> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKME6> content = mongoTemplate.find(query, UKME6.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKME6> result = new PageImpl<UKME6>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKME6.class);

		return counter;
	}

	public void deleteById(String id) {
		UKME6 ukme6 = this.getById(id);
		mongoTemplate.remove(ukme6);
	}

}
