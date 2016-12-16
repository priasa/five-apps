package id.smarta.five.youtube.dao;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import id.smarta.five.youtube.entity.YoutubeEntity;


/**
 * 
 * @author X230
 *
 */
@Repository("youtubeRepository")
public class YoutubeRepository {

    static final Logger LOGGER = LoggerFactory.getLogger(YoutubeRepository.class);

    @Autowired
	private MongoTemplate mongoTemplate;
    
    public void save(YoutubeEntity entity) {
		mongoTemplate.save(entity);
	}
	
    public void saveAll(Set<YoutubeEntity> entities) {
		mongoTemplate.insertAll(entities);
	}
    
	public YoutubeEntity getById(String id) {
		return mongoTemplate.findById(id, YoutubeEntity.class);
	}
}
