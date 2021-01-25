package com.controle_sedex.controller;

import java.util.HashMap;
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
import com.controle_sedex.model.Remetente;
import com.controle_sedex.repository.RemetenteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/remetente")
public class RemetenteController {
	
	@Autowired
	private RemetenteRepository remetenteRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Remetente>> get() {
		return ResponseEntity.ok(remetenteRepository.findAll());
	}
	
	@PostMapping
	public Remetente addRemetente(@Validated @RequestBody Remetente remetente) {
		return remetenteRepository.save(remetente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Remetente> getRemetenteById(@PathVariable(value = "id") Long idRemetente)
		throws ResourceNotFoundException{
		Remetente remetente = remetenteRepository.findById(idRemetente)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idRemetente));
		return ResponseEntity.ok().body(remetente);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Remetente> updateRemetente(@PathVariable(value = "id") Long idRemetente,
			@Validated @RequestBody Remetente remetenteDetalhe) throws ResourceNotFoundException{
		Remetente remetente = remetenteRepository.findById(idRemetente)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idRemetente));
		
		remetente.setRem_codigo(remetenteDetalhe.getRem_codigo());
		remetente.setRem_remetente(remetenteDetalhe.getRem_remetente());
		remetente.setRem_abreviado(remetenteDetalhe.getRem_abreviado());
		remetente.setRem_fixo(remetenteDetalhe.getRem_fixo());
		remetente.setRem_movel(remetenteDetalhe.getRem_movel());
		remetente.setEmp_codigo(remetenteDetalhe.getEmp_codigo());
		remetente.setRem_ativo(remetenteDetalhe.isRem_ativo());
		
		final Remetente remetenteT = remetenteRepository.save(remetente);
		return ResponseEntity.ok(remetenteT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarRemetente(@PathVariable(value = "id") Long idRemetente)
		throws ResourceNotFoundException{
		Remetente remetente = remetenteRepository.findById(idRemetente)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Remetente para esse :: " +idRemetente));
		remetenteRepository.delete(remetente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
