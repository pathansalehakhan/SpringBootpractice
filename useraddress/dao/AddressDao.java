package org.jsp.useraddress.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.useraddress.dto.Address;
import org.jsp.useraddress.dto.User;
import org.jsp.useraddress.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
public class AddressDao {
	@Autowired
	private AddressRepository ar;
	
	public Address save(Address ad) {
		return ar.save(ad);
	}
	public Optional<Address> findById(int id) {
		return ar.findById(id);
	}
	public Optional<List<Address>> findByCountry(String country) {
		return ar.findByCountry(country);
	}
	
	public Optional<List<Address>> findByUid(int id) {
		return ar.findByUid(id);
	}
	
	public Optional<List<Address>> findByUserEmailAndPassword(String email,String password) {
		return ar.findByUserEmailAndPassword(email,password);
	}
	

	

}
