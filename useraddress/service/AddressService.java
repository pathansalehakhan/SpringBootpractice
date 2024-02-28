package org.jsp.useraddress.service;

import java.util.List;
import java.util.Optional;

import org.jsp.useraddress.dao.AddressDao;
import org.jsp.useraddress.dao.UserDao;
import org.jsp.useraddress.dto.Address;
import org.jsp.useraddress.dto.User;
import org.jsp.useraddress.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	@Autowired
	 private AddressDao ad;
	@Autowired
	private UserDao ud;
	
	public Address saveAddress(Address adress,int u_id) {
		
		Optional<User> u=ud.findById(u_id);
		if(u.isPresent()) {
			User user=u.get();
			user.getAddress().add(adress);
			adress.setUser(user);
			return ad.save(adress);
		}
		throw new IdNotFoundException();
		
	}
	
public Address updateAddress(Address adress) {
		
		Optional<Address> op=ad.findById(adress.getId());
		if(op.isPresent()) {
			
			Address add=op.get();
			add.setHome(adress.getHome());
			add.setType(adress.getType());
			add.setLandmark(adress.getLandmark());
			add.setCity(adress.getCity());
			add.setState(adress.getState());
			add.setCountry(adress.getCountry());
			add.setPincode(adress.getPincode());
			return ad.save(add);
		}
		throw new IdNotFoundException();
		
	}
      public Address findByid(int id) {
    	  Optional<Address> a = ad.findById(id);
    	  if(a.isPresent()) {
    		  return a.get();
    	  }
    	  throw new IdNotFoundException();
      }
   
      public List<Address> findByCountry(String country) {
    	  Optional<List<Address>> a = ad.findByCountry(country);
    	  if(a.isPresent()) {
    		  return a.get();
    	  }
    	  return null;
      }
      public List<Address> findByUid(int id) {
    	  Optional<List<Address>> a = ad.findByUid(id);
    	  if(a.isPresent()) {
    		  return a.get();
    	  }
    	  return null;
      }
      public List<Address> findByUserEmailAndPassword(String e,String p) {
    	  Optional<List<Address>> a = ad.findByUserEmailAndPassword(e, p);
    	  if(a.isPresent()) {
    		  return a.get();
    	  }
    	  return null;
      }


}
