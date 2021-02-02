package com.controle_sedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controle_sedex.model.Destinatarios;

@Repository
public interface DestinatariosRepository extends JpaRepository<Destinatarios, Long>{
	
	@Query(value = "select * from cad_destinatarios where cid_cidade = :cid_codigo", nativeQuery = true)
	List<Destinatarios> getAllDestInCidade(@Param("cid_codigo") Long cid_codigo);

}
