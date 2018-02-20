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

    public List<RoleSecurity> listRole() {
        return this.roleRepository.findAll();
    }

    public List<UserSecurity> findUser() {
        return this.userRepository.findAll();
    }

    @Transactional(readOnly = false)
    public UserSecurity save(UserSecurity x) {
        return userRepository.save(x);
    }
    @Transactional(readOnly = false)
    public void delete(List<UserSecurity> list) {
        this.userRepository.delete(list);
    }
    @Transactional(readOnly = false)
    public void delete(UserSecurity x) {
        this.userRepository.delete(x);
    }

    @Transactional(readOnly = false)
    public void delete(String x) {
        this.userRepository.delete(x);
    }

        public UserSecurity findByUsername(String username) {
        return this.userRepository.findByNama(username);
    }

//    @Transactional(readOnly = false)
//    public  void UpdateByid(String id, String nama, String password,String biodata, String nama_lengkap,boolean active){
//       this.userRepository.updateNamaUser(id,nama,password,biodata,nama_lengkap,active);
//    }

    public UserSecurity findById(String kode) {
        return userRepository.findOne(kode);
    }

}
