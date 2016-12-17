package id.smarta.five.facebook.service;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Like;
import facebook4j.Post;
import facebook4j.ResponseList;
import id.smarta.five.facebook.dao.CommentRepository;
import id.smarta.five.facebook.dao.LikeRepository;
import id.smarta.five.facebook.dao.PostRepository;
import id.smarta.five.facebook.entity.CommentEntity;
import id.smarta.five.facebook.entity.LikeEntity;
import id.smarta.five.facebook.entity.PostEntity;
import id.smarta.five.masterdata.entity.MasterData;
import id.smarta.five.masterdata.entity.MasterDataContent;
import id.smarta.five.masterdata.service.MasterDataService;

/**
 * 
 * @author X230
 *
 */
@Service
public class FacebookService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5486124761706228312L;

	static final Logger LOGGER = LoggerFactory.getLogger(FacebookService.class);
	
	@Value("${facebook.appId}")
	private String appId;

	@Value("${facebook.appSecret}")
	private String appSecret;
	
	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	LikeRepository likeRepository;
	
	public void doStream() throws InterruptedException {
		MasterData masterData = masterDataService.findMasterDataByName(MasterDataService.FACEBOOK);
		List<MasterDataContent> masterDataContent = masterDataService.getMDContentParentById(masterData.getId());
		if (masterDataContent != null) {
			for (MasterDataContent mdc : masterDataContent) {
				callFacebookPage(mdc);
			}
		}
	}

	private void callFacebookPage(MasterDataContent mdc) {
		try {
			Facebook facebook = new FacebookFactory().getInstance();
	    	facebook.setOAuthAppId(appId, appSecret);
			facebook.getOAuthAppAccessToken();

			ResponseList<Post> posts = facebook.getPosts(mdc.getFieldValue());
			if (posts != null) {
    			for(Post post: posts) {
					processFacebookPost(post, mdc);
					
					ResponseList<Comment> comments = facebook.getPostComments(post.getId());
					processFacebookComment(comments, post.getId(), mdc);
    				
					ResponseList<Like> likes = facebook.getPostLikes(post.getId());
					processFacebookLike(likes, post.getId(), mdc);
					
					Thread.sleep(5000);
    			}
    		}
		} catch (FacebookException e) {
			LOGGER.error(e.getMessage());
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage());
		} 
	}

	private void processFacebookLike(ResponseList<Like> likes, String postId, MasterDataContent mdc) {
		Set<LikeEntity> entities = new HashSet<LikeEntity>();
		LikeEntity entity = null;
		for (Like like : likes) {
			entity = new LikeEntity();
			entity.setCategory(like.getCategory());
			entity.setCreatedDate(like.getCreatedTime());
			entity.setId(like.getId());
			entity.setKeyword(mdc.getCode());
			entity.setName(like.getName());
			entity.setPageId(mdc.getFieldValue());
			entity.setPostId(postId);
			entities.add(entity);
		}
		likeRepository.saveAll(entities);
	}

	private void processFacebookComment(ResponseList<Comment> comments, String postId, MasterDataContent mdc) {
		Set<CommentEntity> entities = new HashSet<CommentEntity>();
		CommentEntity entity = null;
		for (Comment comment : comments) {
			entity = new CommentEntity();
			entity.setCommentCount(comment.getCommentCount());
			entity.setCreatedDate(comment.getCreatedTime());
			if (comment.getFrom() != null) {
				entity.setFromId(comment.getFrom().getId());
				entity.setFromName(comment.getFrom().getName());
			}
			entity.setId(comment.getId());
			entity.setIsUserLikes(comment.isUserLikes());
			entity.setKeyword(mdc.getCode());
			entity.setLikeCount(comment.getLikeCount());
			entity.setMessage(comment.getMessage());
			entity.setPostId(postId);
			entity.setPageId(mdc.getFieldValue());
			entities.add(entity);
		}
		commentRepository.saveAll(entities);
	}

	private void processFacebookPost(Post post, MasterDataContent mdc) {
		PostEntity entity = new PostEntity();
		entity.setId(post.getId());
		entity.setCaption(post.getCaption());
		entity.setCreatedDate(post.getCreatedTime());
		entity.setDescription(post.getDescription());
		if (post.getFrom() != null) {
			entity.setFromId(post.getFrom().getId());
			entity.setFromName(post.getFrom().getName());
		}
		entity.setFullPicture(post.getFullPicture() != null ? post.getFullPicture().toString():null);
		entity.setLink(post.getLink() != null ? post.getLink().toString() : null);
		entity.setMessage(post.getMessage());
		entity.setName(post.getName());
		entity.setPicture(post.getPicture() != null ? post.getPicture().toString() : null);
		entity.setKeyword(mdc.getCode());
		entity.setPageId(mdc.getFieldValue());
		postRepository.save(entity);
	}
}
