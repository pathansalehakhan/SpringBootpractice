package org.jsp.useraddress.controller;

import java.util.List;

import org.jsp.useraddress.dto.Address;
import org.jsp.useraddress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService as;

	@PostMapping("/{u_id}")
	public Address saveAddress(@RequestBody Address adress,@PathVariable int u_id) {
		return as.saveAddress(adress, u_id);
	}
	@PutMapping
	public Address updateAddress( @RequestBody Address adress) {
		return as.updateAddress(adress);
	}
	@GetMapping("/{id}")
	public Address findByid(@PathVariable int id) {
		return as.findByid(id);
	}
	@GetMapping("/find-by-country")
	public List<Address> findByCountry(@RequestParam String country) {
		return as.findByCountry(country);
	}
	@GetMapping("/find-by-uid")
	public List<Address> findByUid(@RequestParam int u_id) {
		return as.findByUid(u_id);
	}
	@GetMapping("/f-u-e-p")
	public List<Address> findByUserEmailAndPassword(@RequestParam String e,@RequestParam String p) {
	return as.findByUserEmailAndPassword(e, p);
	}

}
