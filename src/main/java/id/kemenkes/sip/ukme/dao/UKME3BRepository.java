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

import id.kemenkes.sip.ukme.entity.UKME3B;


/**
 * 
 * @author X230
 *
 */
@Repository("ukme3bRepository")
public class UKME3BRepository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKME3BRepository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKME3B entity) {
		mongoTemplate.save(entity);
	}
	
	public UKME3B getById(String id) {
		return mongoTemplate.findById(id, UKME3B.class);
	}

	public Page<UKME3B> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKME3B> content = mongoTemplate.find(query, UKME3B.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKME3B> result = new PageImpl<UKME3B>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKME3B.class);

		return counter;
	}
	
	public void deleteById(String id) {
		UKME3B ukme3b = this.getById(id);
		mongoTemplate.remove(ukme3b);
	}

}
