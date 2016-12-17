package id.smarta.five.facebook.dao;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import id.smarta.five.facebook.entity.CommentEntity;

/**
 * 
 * @author X230
 *
 */
@Repository("commentRepository")
public class CommentRepository {

	static final Logger LOGGER = LoggerFactory.getLogger(CommentRepository.class);

    @Autowired
	private MongoTemplate mongoTemplate;
    
    public void save(CommentEntity entity) {
		mongoTemplate.save(entity);
	}
	
    public void saveAll(Set<CommentEntity> entities) {
		mongoTemplate.insertAll(entities);
	}
    
	public CommentEntity getById(String id) {
		return mongoTemplate.findById(id, CommentEntity.class);
	}
}
