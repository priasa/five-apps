package id.smarta.five.security.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="permission")
public class Permission implements Serializable{

    private static final long serialVersionUID = 4282069916304889426L;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    
    private String permissionKey;
    
    public Permission(String permissionKey) {
        this.permissionKey = permissionKey;
    }
    
    public String getPermissionKey() {
        return permissionKey;
    }
    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }
    
}
