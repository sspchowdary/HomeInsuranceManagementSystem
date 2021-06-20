 package com.cg.hims.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hims.entities.User;
import com.cg.hims.service.IUserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class IUserController {

@Autowired
private IUserService  userservice;


@RequestMapping(value= "/user/{id}", method= RequestMethod.GET)
public User getUser(@PathVariable int id)  {
Optional<User> user =  userservice.findUserById(id);
     
         return user.get();       
}
@RequestMapping(value= "/getUsers", method= RequestMethod.GET)
public List<User>getUsers()  {
List<User> user =  userservice.getUsers();
     
         return user;       
}



@RequestMapping(value= "/adduser", method= RequestMethod.POST)
public User addUser(@Valid @RequestBody User user) {       
      return userservice.addUser(user);
}

@RequestMapping(value= "/user/update/{id}", method= RequestMethod.PUT)
public User updateUser(@Valid @RequestBody User upduser, @PathVariable int id) {
    Optional<User> user =  userservice.getUser(id);
	  
                 return userservice.updateUser(upduser);
    }

 
}
