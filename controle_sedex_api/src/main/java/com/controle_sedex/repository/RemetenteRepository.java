package com.controle_sedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle_sedex.model.Remetente;

@Repository
public interface RemetenteRepository extends JpaRepository<Remetente, Long>{

}
