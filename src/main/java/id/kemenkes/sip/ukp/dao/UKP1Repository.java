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

import id.kemenkes.sip.ukp.entity.UKP1;


/**
 * 
 * @author X230
 *
 */
@Repository("ukp1Repository")
public class UKP1Repository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKP1Repository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKP1 entity) {
		mongoTemplate.save(entity);
	}
	
	public UKP1 getById(String id) {
		return mongoTemplate.findById(id, UKP1.class);
	}

	public Page<UKP1> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKP1> content = mongoTemplate.find(query, UKP1.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKP1> result = new PageImpl<UKP1>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKP1.class);

		return counter;
	}
	
	public void deleteById(String id) {
		UKP1 ukp1 = this.getById(id);
		mongoTemplate.remove(ukp1);
	}

}
