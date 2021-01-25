package com.controle_sedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controle_sedex.model.Reg_Sedex;

@Repository
public interface RegSedexRepository extends JpaRepository<Reg_Sedex, Long>{
	
	@Query(value = "select * from cad_reg_sedex where sed_pago = false order by sed_data_postagem desc", nativeQuery = true)
	List<Reg_Sedex> findByRegNãoListado();

}
