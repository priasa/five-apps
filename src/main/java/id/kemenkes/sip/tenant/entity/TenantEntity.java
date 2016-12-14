package id.kemenkes.sip.tenant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import id.kemenkes.sip.common.entity.AbstractAuditablePersistable;


@Entity
@Table(name = "tenant")
public class TenantEntity extends AbstractAuditablePersistable{

	private static final long serialVersionUID = -4861329980236253212L;

	@NotBlank
	@Column(name = "TENANT_CODE")
	private String tenantCode;
	
	@Column(name = "TENANT_NAME")
	private String tenantName;
	
	@Column(name = "TOKEN_ID")
	private String tokenId;
	
	@Column(name = "PROVINSI")
	@NotNull
	private Integer provinsi;
	
	@Column(name = "KABUPATEN")
	@NotNull
	private Integer kabupaten;

	@Column(name = "PROV_NAME")
	private String provinsiName;
	
	@Column(name = "KAB_NAME")
	private String kabupatenName;
	
	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public Integer getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(Integer provinsi) {
		this.provinsi = provinsi;
	}

	public Integer getKabupaten() {
		return kabupaten;
	}

	public void setKabupaten(Integer kabupaten) {
		this.kabupaten = kabupaten;
	}

	public String getProvinsiName() {
		return provinsiName;
	}

	public void setProvinsiName(String provinsiName) {
		this.provinsiName = provinsiName;
	}

	public String getKabupatenName() {
		return kabupatenName;
	}

	public void setKabupatenName(String kabupatenName) {
		this.kabupatenName = kabupatenName;
	}
	
}
