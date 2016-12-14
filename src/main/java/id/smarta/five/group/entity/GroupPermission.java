package id.kemenkes.sip.group.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import id.kemenkes.sip.common.entity.AbstractPersistable;

@Entity
@Table(name="group_permission")
public class GroupPermission extends AbstractPersistable{
    
    private static final long serialVersionUID = 4282069916304889426L;
    
    public static String ADMIN = "ADMIN";
    
    public static String PREFIX = "ROLE_";
    
    public static final String ACTION_ADD_EDIT = "ADD_EDIT";
    public static final String ACTION_DELETE = "DELETE";
    public static final String ACTION_VIEW = "VIEW";
    public static final String ACTION_PUBLISH = "PUBLISH";
    
    
    public static final String MODULE_DATA = "DATA";
    public static final String MODULE_REPORT = "REPORT";
    public static final String MODULE_GROUP = "GROUP";
    public static final String MODULE_USER = "USER";
    public static final String MODULE_EVENT = "EVENT";

	public static final String MODULE_DESIGN = "FORM_DESIGN";
	public static final String MODULE_MASTER_DATA = "MASTER_DATA";

	public static final String MODULE_TENANT = "TENANT";
	public static final String MODULE_UKME = "UKME";
	public static final String MODULE_UKMP = "UKMP";
	public static final String MODULE_UKP = "UKP";

	public static final String MODULE_LT = "LT";

	public static final String MODULE_LAYANAN = "LAYANAN";
       
    private String permissionKey;
    
    @OneToOne
    private Group group;
    
    public GroupPermission() {
        
    }
    
    public GroupPermission(String permissionKey) {
        this.permissionKey = permissionKey;
    }
    
    public String getPermissionKey() {
        return permissionKey;
    }
    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
}

