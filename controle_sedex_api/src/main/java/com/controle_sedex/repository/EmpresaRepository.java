package com.controle_sedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controle_sedex.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	@Query(value = "select * from cad_empresa where tem_codigo = 1", nativeQuery = true)
	List<Empresa> findEmpresaByTransp();
	
}
