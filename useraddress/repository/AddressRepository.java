package org.jsp.useraddress.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.useraddress.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	@Query("select a from Address a where a.country=?1")
	Optional<List<Address>> findByCountry(String country);
	@Query("select u.address from User u where u.id=?1")
	Optional<List<Address>> findByUid(int id);
	@Query("select u.address from User u where u.email=?1 and u.password=?2")
	Optional<List<Address>> findByUserEmailAndPassword(String email, String password);



}
