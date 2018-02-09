/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.repository;

import com.iqbal.salman.aplikasibpr.master.UserSecurity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author iqbal
 */
public interface UserRepository  extends CrudRepository<UserSecurity, String>{
   
    List<UserSecurity> findAll();
    
    UserSecurity findByNama(String username);
}
