package com.findbook.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*    String token = getJWTToken(username);*/
    private long roleId;
    private Roles roleName;

    public Role() {
    }

    // <editor-fold defaultstate="collapsed" desc=" GETTERS AND SETTERS ">
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public Roles getRoleName() {
        return roleName;
    }

    public void setRoleName(Roles roleName) {
        this.roleName = roleName;
    }
    // </editor-fold>
}

//Predefined roles
enum Roles {
    ROLE_USER, ROLE_ADMIN;

}