package com.vedisoft.vedisoft2020.jwt;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vedisoft.vedisoft2020.daos.IUserDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Person;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDetailsDao userDetailsDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Person activePerson = userDetailsDao.getActiveUser(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(activePerson.getKey1());
		UserDetails userDetails = (UserDetails)new User(activePerson.getUsername(),
				activePerson.getPassword(), Arrays.asList(authority));
		System.out.println("Person Details are " + activePerson.getUsername() + activePerson.getPassword()) ;
		return userDetails;
	}
	
//	@Autowired
//	private UserInfoDAO userInfoDAO;
//
//	@Override
//	public CustomUserDetail loadUserByUsername(String userName) throws UsernameNotFoundException {
//		UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
//		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
////		UserDetails userDetails = (UserDetails) new User(activeUserInfo.getUsername(), activeUserInfo.getPassword(),
////				Arrays.asList(authority));
//
//		CustomUserDetail userDetail = new CustomUserDetail();
//		userDetail.setUser(activeUserInfo);
//		userDetail.setAuthorities(Arrays.asList(authority));
////		System.out.println("LOAD USER BY USERNAME IS WORKING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+userDetails);
//		return userDetail;
//	}
//	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
//	
//	@Override
//	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//	        .filter(user -> user.getUsername().equals(username)).findFirst();
//
//	    if (!findFirst.isPresent()) {
//	      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
//	    }
//
//	    return findFirst.get();
//	  }

}
