package com.controle_sedex.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle_sedex.exception.ResourceNotFoundException;
import com.controle_sedex.model.Reg_Sedex;
import com.controle_sedex.repository.RegSedexRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/regsedex")
public class RegSedexController {
	
	@Autowired
	private RegSedexRepository regSedexRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Reg_Sedex>> get() {
		return ResponseEntity.ok(regSedexRepository.findAll());
	}
	
	@GetMapping("/semdespacho")
	public List<Reg_Sedex> findByNaoPostado(){
		return regSedexRepository.findByRegNãoListado();
	}
	
	@PostMapping
	public Reg_Sedex addRegSedex(@Validated @RequestBody Reg_Sedex regSedex) {
		return regSedexRepository.save(regSedex);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reg_Sedex> getRegSedexById(@PathVariable(value = "id") Long idRegSedex)
		throws ResourceNotFoundException{
		Reg_Sedex regSedex = regSedexRepository.findById(idRegSedex)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idRegSedex));
		return ResponseEntity.ok().body(regSedex);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Reg_Sedex> updateRegSedex(@PathVariable(value = "id") Long idRegSedex,
			@Validated @RequestBody Reg_Sedex regSedexDetalhe) throws ResourceNotFoundException{
		Reg_Sedex regSedex = regSedexRepository.findById(idRegSedex)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idRegSedex));
		
		regSedex.setSed_codigo(regSedexDetalhe.getSed_codigo());
		regSedex.setSed_data_postagem(regSedexDetalhe.getSed_data_postagem());
		regSedex.setEmp_codigo(regSedexDetalhe.getEmp_codigo());
		regSedex.setRem_codigo(regSedexDetalhe.getRem_codigo());
		regSedex.setCid_codigo(regSedexDetalhe.getCid_codigo());
		regSedex.setEst_codigo(regSedexDetalhe.getEst_codigo());
		regSedex.setDes_codigo(regSedexDetalhe.getDes_codigo());
		regSedex.setSed_codigo_rastreio(regSedexDetalhe.getSed_codigo_rastreio());
		regSedex.setSed_valor(regSedexDetalhe.getSed_valor());
		regSedex.setSed_pago(regSedexDetalhe.isSed_pago());
		regSedex.setSed_extraviou(regSedexDetalhe.isSed_extraviou());
		regSedex.setSed_operador(regSedexDetalhe.getSed_operador());
		regSedex.setSed_data_modificacao(regSedexDetalhe.getSed_data_modificacao());
		
		final Reg_Sedex regSedexT = regSedexRepository.save(regSedex);
		return ResponseEntity.ok(regSedexT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarRegSedex(@PathVariable(value = "id") Long idRegSedex)
		throws ResourceNotFoundException{
		Reg_Sedex regSedex = regSedexRepository.findById(idRegSedex)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Estado para esse :: " +idRegSedex));
		regSedexRepository.delete(regSedex);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}