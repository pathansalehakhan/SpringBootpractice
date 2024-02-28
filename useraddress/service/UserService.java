package org.jsp.useraddress.service;

import java.util.Optional;

import org.jsp.useraddress.dao.UserDao;
import org.jsp.useraddress.dto.User;
import org.jsp.useraddress.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public User saveuser(User user) {
		return userDao.saveuser(user);
	}
	public User updateuser(User user) {
		Optional<User> u = userDao.findById(user.getId());
		if(u.isPresent()) {


			return userDao.updateuser(user);
		}
		return null;
	}
	public User findByid(int id) {
		Optional<User> u = userDao.findById(id);
		if(u.isPresent()) {
			return u.get();
		}
		throw new  IdNotFoundException();
	}
	public User verifyByPhoneAndPassword(long phone,String password) {
		Optional<User> u = userDao.verify(phone, password);
		if(u.isPresent()) {
			return u.get();
					
		}
		throw new IdNotFoundException();
	}
	public User verifyByEmailAndPassword(String email,String password) {
		Optional<User> u = userDao.verify(email, password);
		if(u.isPresent()) {
			return u.get();
		}
		return null;
	}
}
