package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Contacttura;

@Repository
public interface ContactturaRepository extends JpaRepository<Contacttura, Long>{}
