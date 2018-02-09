/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.master;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author iqbal
 */
@Entity
@Table(name = "roles" , schema = "security")
public class RoleSecurity {
  @Id
    @SequenceGenerator(
            name = "role_security_seq",
            schema = "security",
            allocationSize = 1,
            initialValue = 1,
            sequenceName = "role_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_security_seq")
    @Column(name = "role_id", nullable = false, unique = true)
    private Long id;
    @Column(name = "rolename", nullable = false, unique = true, length = 20)
    private String nama;
    @Column(name = "created_by", length = 50)
    private String createdBy;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
 
    
}