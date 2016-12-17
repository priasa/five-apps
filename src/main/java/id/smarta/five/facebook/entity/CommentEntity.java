package id.smarta.five.facebook.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author X230
 *
 */
@Document(collection="FB_COMMENT")
public class CommentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5866848202454644190L;

	@Id
	private String id;
	private String postId;
	private Date createdDate;
	private String message;
	private String fromId;
	private String fromName;
	private Integer likeCount;
    private Integer commentCount;
    private Boolean isUserLikes;
    private String keyword;
    private String pageId;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Boolean getIsUserLikes() {
		return isUserLikes;
	}
	public void setIsUserLikes(Boolean isUserLikes) {
		this.isUserLikes = isUserLikes;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
  
}
