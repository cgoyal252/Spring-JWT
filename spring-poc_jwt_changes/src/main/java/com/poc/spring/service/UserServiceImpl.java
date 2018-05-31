package com.poc.spring.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.poc.spring.model.User;






@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	/*static{
		users= populateDummyUsers();
	}
*/
	/*public List<User> findAllUsers() {
		return users;
	}*/
	
	/*public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}*/
	
	/*public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}*/
	
	public void saveUser(com.poc.spring.model.User user) {

		
		users.add(user);
	}

	/*public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}*/

	/*public void deleteUserById(long id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}*/

	/*public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	*/
/*	public void deleteAllUsers(){
		users.clear();
	}*/

/*	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Sam",30, 70000));
		users.add(new User(counter.incrementAndGet(),"Tom",40, 50000));
		users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));
		users.add(new User(counter.incrementAndGet(),"Silvia",50, 40000));
		return users;
	}
*/
	@Override
	public com.poc.spring.model.User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}


}
