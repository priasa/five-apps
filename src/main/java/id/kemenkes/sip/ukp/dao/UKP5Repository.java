package id.kemenkes.sip.ukp.dao;

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

import id.kemenkes.sip.ukp.entity.UKP5;


/**
 * 
 * @author X230
 *
 */
@Repository("ukp5Repository")
public class UKP5Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKP5Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKP5 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKP5 getById(String id) {
		return mongoTemplate.findById(id, UKP5.class);
	}
	
	public void deleteById(String id) {
		UKP5 ukp5 = this.getById(id);
		mongoTemplate.remove(ukp5);
	}

	public Page<UKP5> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKP5> content = mongoTemplate.find(query, UKP5.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKP5> result = new PageImpl<UKP5>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKP5.class);

		return counter;
	}

}
