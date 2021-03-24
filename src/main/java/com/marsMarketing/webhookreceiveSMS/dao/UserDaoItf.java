package com.marsMarketing.webhookreceiveSMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marsMarketing.webhookreceiveSMS.entite.User;



public interface UserDaoItf extends JpaRepository <User, String>{
	
}
