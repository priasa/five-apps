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

import id.kemenkes.sip.ukp.entity.UKP4;


/**
 * 
 * @author X230
 *
 */
@Repository("ukp4Repository")
public class UKP4Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKP4Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKP4 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKP4 getById(String id) {
		return mongoTemplate.findById(id, UKP4.class);
	}

	public Page<UKP4> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKP4> content = mongoTemplate.find(query, UKP4.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKP4> result = new PageImpl<UKP4>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKP4.class);

		return counter;
	}
	
	public void deleteById(String id) {
		UKP4 ukp4 = this.getById(id);
		mongoTemplate.remove(ukp4);
	}

}
