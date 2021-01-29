package com.controle_sedex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.controle_sedex.model.Reg_itens;
import com.controle_sedex.repository.RegItensRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/regitens")
public class RegItensController {
	
	@Autowired
	private RegItensRepository regItensRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Reg_itens>> get() {
		return ResponseEntity.ok(regItensRepository.findAll());
	}
	
	@PostMapping
	public Reg_itens addEstado(@Validated @RequestBody Reg_itens regItens) {
		return regItensRepository.save(regItens);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reg_itens> getRegItensById(@PathVariable(value = "id") Long idRegItens)
		throws ResourceNotFoundException{
		Reg_itens regItens = regItensRepository.findById(idRegItens)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idRegItens));
		return ResponseEntity.ok().body(regItens);
	}
	
	@GetMapping("/itens/{sed_codigo}")
	public List<Reg_itens> findByCidadeForEstado(@PathVariable(value = "sed_codigo") Long sed_codigo){
		return regItensRepository.findByRegItensSedex(sed_codigo);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Reg_itens> updateRegItens(@PathVariable(value = "id") Long idRegItens,
			@Validated @RequestBody Reg_itens regItensDetalhe) throws ResourceNotFoundException{
		Reg_itens regitens = regItensRepository.findById(idRegItens)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idRegItens));
		
		regitens.setEqu_codigo(regItensDetalhe.getEqu_codigo());
		regitens.setSed_codigo(regItensDetalhe.getSed_codigo());
		regitens.setTit_codigo(regItensDetalhe.getTit_codigo());
		regitens.setIps_descricao(regItensDetalhe.getIps_descricao());
		regitens.setEqu_codigo(regItensDetalhe.getEqu_codigo());
		regitens.setIps_codigo_equip(regItensDetalhe.getIps_cod());
		regitens.setIps_cod_ra(regItensDetalhe.getIps_cod_ra());
		
		final Reg_itens regItensT = regItensRepository.save(regitens);
		return ResponseEntity.ok(regItensT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarRegItens(@PathVariable(value = "id") Long idRegItens)
		throws ResourceNotFoundException{
		Reg_itens regItens = regItensRepository.findById(idRegItens)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Estado para esse :: " +idRegItens));
		regItensRepository.delete(regItens);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}