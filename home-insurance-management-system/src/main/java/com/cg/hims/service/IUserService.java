 package com.cg.hims.service;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

import com.cg.hims.entities.User;

public interface IUserService {


public User addUser(User user);
public User updateUser(User user);

public Optional<User> findUserById(int id);
public Optional<User> getUser(int id);
public List<User>getUsers();







	

	

}

