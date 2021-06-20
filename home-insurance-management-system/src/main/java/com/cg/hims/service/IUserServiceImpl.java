 package com.cg.hims.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.hims.entities.User;
import com.cg.hims.repository.IUserRepository;




@Service
public class IUserServiceImpl implements IUserService{

@Autowired
private IUserRepository userRepo;



@Override
public User addUser(User newuser) {
	return userRepo.save(newuser);
}

public User updateUser(User user) {
	return userRepo.save(user);
}



@Override
public Optional<User> getUser(int id) {
    return  userRepo.findById(id);
}

@Override
public Optional<User> findUserById(int id) {
	// TODO Auto-generated method stub
	return userRepo.findById(id);
}
@Override
public List<User> getUsers() {
	// TODO Auto-generated method stub
	return userRepo.findAll();
}









}

