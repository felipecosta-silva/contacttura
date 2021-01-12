package com.contacttura.contacttura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.contacttura.contacttura.model.ContactturaUser;
import com.contacttura.contacttura.repository.ContactturaUserRepository;

@Component
public class CustomUserDetailService implements UserDetailsService {
	
	private final ContactturaUserRepository contactturaUserRepository;
	
	@Autowired
	public CustomUserDetailService(ContactturaUserRepository contactturaUserRepository) {
		this.contactturaUserRepository = contactturaUserRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ContactturaUser user = Optional.ofNullable(contactturaUserRepository.findBuUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("Usuário ão oencontrado"));
		
		//Lista que retorna as autorizações e premissões para cada tipo de usuário
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		//Inserindo os dados do meu usuário diretamente dentro do model de usuário
		return new org.springframework.security.core.userdetails.User
				(user.getUsername(), user.getPassword(), user.isAdmin()? authorityListAdmin : authorityListUser);
	}

}
