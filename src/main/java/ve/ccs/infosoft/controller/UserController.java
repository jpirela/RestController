package ve.ccs.infosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ve.ccs.infosoft.model.User;
import ve.ccs.infosoft.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("/usuarios")
	public ResponseEntity<?> getAllUser(){
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
		
	
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> finById(@PathVariable("id") Long id){
		
		 if (userService.finById(id).isPresent()) {
			 return new ResponseEntity<>(userService.finById(id), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }	
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		
		try {
			return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
			
		} catch (Exception e) {
			 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<?>updateUser(@PathVariable("id") Long id, @RequestBody User user){
		
		user.setId(id);
		User updateUser= userService.updateUser(user);
		return new ResponseEntity<>(updateUser,HttpStatus.OK);
		

		
	}
	
	@DeleteMapping("/usuario/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

	
	
}
