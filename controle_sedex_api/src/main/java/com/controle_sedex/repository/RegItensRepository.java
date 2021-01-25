package com.controle_sedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle_sedex.model.Reg_itens;

@Repository
public interface RegItensRepository extends JpaRepository<Reg_itens, Long>{

}
