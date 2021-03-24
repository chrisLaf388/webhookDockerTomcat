package com.marsMarketing.webhookreceiveSMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.marsMarketing.webhookreceiveSMS.dao.UserDaoItf;
import com.marsMarketing.webhookreceiveSMS.dao.UserRoleDaoItf;
import com.marsMarketing.webhookreceiveSMS.entite.User;
import com.marsMarketing.webhookreceiveSMS.entite.UserRole;


@SpringBootApplication
public class WebhookReceiveSmsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WebhookReceiveSmsApplication.class, args);
		
		UserDaoItf userDao = ctx.getBean(UserDaoItf.class);
		userDao.save(new User("uadmin", "padmin"));
		
		
		UserRoleDaoItf userRoleDao = ctx.getBean(UserRoleDaoItf.class);
		userRoleDao.save(new UserRole("uadmin","ADMIN"));
	}

}
