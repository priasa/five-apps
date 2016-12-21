package id.smarta.five.twitter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import id.smarta.five.common.entity.AbstractAuditablePersistable;

@Entity
@Table(name = "twitter_stream")
public class TwitterStream extends AbstractAuditablePersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -213352599947345525L;

	public static final String STARTED = "STARTED";
	public static final String RUNNING = "RUNNING";
	public static final String NEED_TO_RESTART = "NEED_TO_RESTART";

	@NotBlank
	@Column(name = "stream_code")
	private String code;
	
	@Column(name = "stream_status")
	private String status =  STARTED;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
