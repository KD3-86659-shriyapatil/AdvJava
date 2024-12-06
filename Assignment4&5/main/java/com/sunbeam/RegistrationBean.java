package com.sunbeam;



import java.util.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegistrationBean {
  private String first_name;
  private String last_name;
  private String email;
  private String password;
  private String dob;
  int count;
  
  public RegistrationBean() {

}
  

public RegistrationBean(String first_name, String last_name, String email, String password, String dob, int count) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
	this.password = password;
	this.dob = dob;
	this.count = count;
}


public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}
  
public void registerUser() {
	
	Date d=Date.valueOf(dob);
	
	User u=new User(0,first_name,last_name,email,password,d,0,"voter"); 
	try(UserDao userDao =new UserDaoImpl() ){
		
		count=userDao.save(u);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
