package id.smarta.five.facebook.dao;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import id.smarta.five.facebook.entity.PostEntity;

/**
 * 
 * @author X230
 *
 */
@Repository("postRepository")
public class PostRepository {

	static final Logger LOGGER = LoggerFactory.getLogger(PostRepository.class);

    @Autowired
	private MongoTemplate mongoTemplate;
    
    public void save(PostEntity entity) {
		mongoTemplate.save(entity);
	}
	
    public void saveAll(Set<PostEntity> entities) {
		mongoTemplate.insertAll(entities);
	}
    
	public PostEntity getById(String id) {
		return mongoTemplate.findById(id, PostEntity.class);
	}
}
