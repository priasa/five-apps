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

import id.kemenkes.sip.ukme.entity.UKME3A;


/**
 * 
 * @author X230
 *
 */
@Repository("ukme3aRepository")
public class UKME3ARepository {
	
    static final Logger LOGGER = LoggerFactory.getLogger(UKME3ARepository.class);
    
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(UKME3A entity) {
		mongoTemplate.save(entity);
	}
	
	public UKME3A getById(String id) {
		return mongoTemplate.findById(id, UKME3A.class);
	}

	public Page<UKME3A> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}
		
		if(bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<UKME3A> content = mongoTemplate.find(query, UKME3A.class);		
		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<UKME3A> result = new PageImpl<UKME3A>(content, page, size);
		
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
		long counter = mongoTemplate.count(query, UKME3A.class);

		return counter;
	}

	public void deleteById(String id) {
		UKME3A ukme3a = this.getById(id);
		mongoTemplate.remove(ukme3a);
	}

}
