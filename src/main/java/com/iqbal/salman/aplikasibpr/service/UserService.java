/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.service;

import com.iqbal.salman.aplikasibpr.master.RoleSecurity;
import com.iqbal.salman.aplikasibpr.master.UserSecurity;
import com.iqbal.salman.aplikasibpr.repository.RoleRepository;
import com.iqbal.salman.aplikasibpr.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author iqbal
 */
@Repository
@Transactional(readOnly = true)
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    public List<RoleSecurity> listRole(){
        return this.roleRepository.findAll();
    }
    
    public List<RoleSecurity> findUser(){
      return this.roleRepository.findAll();
    }
    
        public UserSecurity findByUsername(String username) {
        return this.userRepository.findByNama(username);
    }
    
    
}
