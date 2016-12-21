package id.smarta.five.tenant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import id.smarta.five.common.entity.AbstractAuditablePersistable;


@Entity
@Table(name = "tenant")
public class Tenant extends AbstractAuditablePersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6488235555380647564L;

	@NotBlank
	@Column(name = "tenant_name")
	private String name;
	
	@Column(name = "tenant_code")
	private String token;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
