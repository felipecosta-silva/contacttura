package com.contacttura.contacttura.repository;

import com.contacttura.contacttura.model.Contacttura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactturaRepository extends JpaRepository<Contacttura, Long>{}
