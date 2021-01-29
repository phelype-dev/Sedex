package com.controle_sedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controle_sedex.model.Reg_itens;

@Repository
public interface RegItensRepository extends JpaRepository<Reg_itens, Long>{
	
	@Query(value = "select * from cad_reg_itens where sed_codigo  = :sed_codigo", nativeQuery = true)
	List<Reg_itens> findByRegItensSedex(@Param("sed_codigo") Long sed_codigo);

}
