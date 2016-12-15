package id.smarta.five.gnews.dao;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import id.smarta.five.gnews.entity.GoogleNews;

/**
 * 
 * @author X230
 *
 */
@Repository("googleNewsRepository")
public class GoogleNewsRepository {

    static final Logger LOGGER = LoggerFactory.getLogger(GoogleNewsRepository.class);

    @Autowired
	private MongoTemplate mongoTemplate;
    
    public void save(GoogleNews entity) {
		mongoTemplate.save(entity);
	}
	
    public void saveAll(Set<GoogleNews> entities) {
		mongoTemplate.insertAll(entities);
	}
    
	public GoogleNews getById(String id) {
		return mongoTemplate.findById(id, GoogleNews.class);
	}
}
