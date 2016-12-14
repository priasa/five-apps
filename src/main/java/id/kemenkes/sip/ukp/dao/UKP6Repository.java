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

import id.kemenkes.sip.ukp.entity.UKP6;


/**
 * 
 * @author X230
 *
 */
@Repository("ukp6Repository")
public class UKP6Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKP6Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKP6 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKP6 getById(String id) {
		return mongoTemplate.findById(id, UKP6.class);
	}
	
	public void deleteById(String id) {
		UKP6 ukp6 = this.getById(id);
		mongoTemplate.remove(ukp6);
	}

	public Page<UKP6> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKP6> content = mongoTemplate.find(query, UKP6.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKP6> result = new PageImpl<UKP6>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKP6.class);

		return counter;
	}

}
