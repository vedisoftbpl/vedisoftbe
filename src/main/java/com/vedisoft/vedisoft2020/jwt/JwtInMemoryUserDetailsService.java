package com.vedisoft.vedisoft2020.jwt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoDAO userInfoDAO;

	@Override
	public CustomUserDetail loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
//		UserDetails userDetails = (UserDetails) new User(activeUserInfo.getUsername(), activeUserInfo.getPassword(),
//				Arrays.asList(authority));

		CustomUserDetail userDetail = new CustomUserDetail();
		userDetail.setUser(activeUserInfo);
		userDetail.setAuthorities(Arrays.asList(authority));
//		System.out.println("LOAD USER BY USERNAME IS WORKING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+userDetails);
		return userDetail;
	}

}
