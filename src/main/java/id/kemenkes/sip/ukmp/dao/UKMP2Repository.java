package id.kemenkes.sip.ukmp.dao;

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

import id.kemenkes.sip.ukmp.entity.UKMP2;


/**
 * 
 * @author X230
 *
 */
@Repository
public class UKMP2Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKMP2Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKMP2 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKMP2 getById(String id) {
		return mongoTemplate.findById(id, UKMP2.class);
	}

	public Page<UKMP2> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKMP2> content = mongoTemplate.find(query, UKMP2.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKMP2> result = new PageImpl<UKMP2>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKMP2.class);

		return counter;
	}

	public void deleteById(String id) {
		UKMP2 ukmp2 = this.getById(id);
		mongoTemplate.remove(ukmp2);
	}
}
