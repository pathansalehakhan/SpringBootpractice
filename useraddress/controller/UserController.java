package org.jsp.useraddress.controller;

import org.jsp.useraddress.dto.User;
import org.jsp.useraddress.service.UserService;
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
@RequestMapping("/user")
public class UserController {
	@Autowired
private UserService userService;
	@PostMapping
	public User saveuser(@RequestBody User user) {
		return userService.saveuser(user);
	}
	@PutMapping
	public User updateuser(@RequestBody User user) {
		return userService.updateuser(user);
	}
	@GetMapping("/{id}")
	public User findByid(@PathVariable int id) {
		return userService.findByid(id);
	}
   @GetMapping
  public User verifyByPhoneAndPassword(@RequestParam long phone,@RequestParam String password) {
	  return userService.verifyByPhoneAndPassword(phone, password);
  }
   @GetMapping("/verify-email-password")
   public User verifyByEmailAndPassword(@RequestParam String email,@RequestParam String password) {
	   return userService.verifyByEmailAndPassword(email, password);
   }
}