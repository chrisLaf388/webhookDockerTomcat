package com.marsMarketing.webhookreceiveSMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marsMarketing.webhookreceiveSMS.entite.UserRole;


public interface UserRoleDaoItf extends JpaRepository <UserRole, String>{

}
