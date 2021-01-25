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
import com.controle_sedex.model.Regiao;
import com.controle_sedex.repository.RegiaoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/regiao")
public class RegiaoController {
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Regiao>> get() {
		return ResponseEntity.ok(regiaoRepository.findAll());
	}
	
	@PostMapping
	public Regiao addRegiao(@Validated @RequestBody Regiao regiao) {
		return regiaoRepository.save(regiao);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Regiao> getRegiaoById(@PathVariable(value = "id") Long idRegiao)
		throws ResourceNotFoundException{
		Regiao regiao = regiaoRepository.findById(idRegiao)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idRegiao));
		return ResponseEntity.ok().body(regiao);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Regiao> updateRegiao(@PathVariable(value = "id") Long idRegiao,
			@Validated @RequestBody Regiao regiaoDetalhe) throws ResourceNotFoundException{
		Regiao regiao = regiaoRepository.findById(idRegiao)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idRegiao));
		
		regiao.setReo_codigo(regiaoDetalhe.getReo_codigo());
		regiao.setReo_regiao(regiaoDetalhe.getReo_regiao());
		
		final Regiao regiaoT = regiaoRepository.save(regiao);
		return ResponseEntity.ok(regiaoT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarRegiao(@PathVariable(value = "id") Long idRegiao)
		throws ResourceNotFoundException{
		Regiao regiao = regiaoRepository.findById(idRegiao)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe regiao para esse :: " +idRegiao));
		regiaoRepository.delete(regiao);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}