package com.contacttura.contacttura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacttura.contacttura.model.ContactturaUser;

@Repository 
public interface ContactturaUserRepository extends JpaRepository<ContactturaUser, Long> {
	
	//busca pelo nome de usuário
	ContactturaUser findBuUsername(String username);
}
