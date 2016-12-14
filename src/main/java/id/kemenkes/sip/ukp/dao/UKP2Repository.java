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

import id.kemenkes.sip.ukp.entity.UKP2;


/**
 * 
 * @author X230
 *
 */
@Repository("ukp2Repository")
public class UKP2Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKP2Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKP2 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKP2 getById(String id) {
		return mongoTemplate.findById(id, UKP2.class);
	}

	public Page<UKP2> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKP2> content = mongoTemplate.find(query, UKP2.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKP2> result = new PageImpl<UKP2>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKP2.class);

		return counter;
	}

	public void deleteById(String id) {
		UKP2 ukp2 = this.getById(id);
		mongoTemplate.remove(ukp2);
	}
}
