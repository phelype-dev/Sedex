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
import com.controle_sedex.model.Cidade;
import com.controle_sedex.repository.CidadeRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Cidade>> get() {
		return ResponseEntity.ok(cidadeRepository.findAll());
	}
	
	@PostMapping
	public Cidade addCidade(@Validated @RequestBody Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> getCidadeById(@PathVariable(value = "id") Long idCidade)
		throws ResourceNotFoundException{
		Cidade cidade = cidadeRepository.findById(idCidade)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idCidade));
		return ResponseEntity.ok().body(cidade);
	}
	
	@GetMapping("/estados/{est_codigo}")
	public List<Cidade> findByCidadeForEstado(@PathVariable(value = "est_codigo") Long est_codigo){
		return cidadeRepository.findByCidadeForEstado(est_codigo);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Cidade> updateCidade(@PathVariable(value = "id") Long idCidade,
			@Validated @RequestBody Cidade cidadeDetalhe) throws ResourceNotFoundException{
		Cidade cidade = cidadeRepository.findById(idCidade)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idCidade));
		
		cidade.setCid_codigo(cidadeDetalhe.getCid_codigo());
		cidade.setMunicipio(cidadeDetalhe.getMunicipio());
		cidade.setEst_codigo(cidadeDetalhe.getEst_codigo());
		
		final Cidade CidadeT = cidadeRepository.save(cidade);
		return ResponseEntity.ok(CidadeT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idCidade)
		throws ResourceNotFoundException{
		Cidade Cidade = cidadeRepository.findById(idCidade)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Cidade para esse :: " +idCidade));
		cidadeRepository.delete(Cidade);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}