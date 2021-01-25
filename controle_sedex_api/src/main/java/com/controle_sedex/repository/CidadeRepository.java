package com.controle_sedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controle_sedex.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	@Query(value = "select * from cad_cidade where est_codigo = :est_codigo", nativeQuery = true)
	List<Cidade> findByCidadeForEstado(@Param("est_codigo") Long est_codigo);
}
