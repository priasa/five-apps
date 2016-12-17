package id.smarta.five.facebook.dao;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import id.smarta.five.facebook.entity.LikeEntity;

@Repository("likeRepository")
public class LikeRepository {

	static final Logger LOGGER = LoggerFactory.getLogger(CommentRepository.class);

    @Autowired
	private MongoTemplate mongoTemplate;
    
    public void save(LikeEntity entity) {
		mongoTemplate.save(entity);
	}
	
    public void saveAll(Set<LikeEntity> entities) {
		mongoTemplate.insertAll(entities);
	}
    
	public LikeEntity getById(String id) {
		return mongoTemplate.findById(id, LikeEntity.class);
	}
}
