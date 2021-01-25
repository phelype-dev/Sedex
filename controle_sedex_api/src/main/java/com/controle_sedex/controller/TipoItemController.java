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
import com.controle_sedex.model.Tipo_Item;
import com.controle_sedex.repository.TipoItemRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipoitem")
public class TipoItemController {
	
	@Autowired
	private TipoItemRepository tpItemRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Tipo_Item>> get() {
		return ResponseEntity.ok(tpItemRepository.findAll());
	}
	
	@PostMapping
	public Tipo_Item addTipoItem(@Validated @RequestBody Tipo_Item tipoItem) {
		return tpItemRepository.save(tipoItem);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tipo_Item> getTipoItemById(@PathVariable(value = "id") Long idTipoItem)
		throws ResourceNotFoundException{
		Tipo_Item tipoItem = tpItemRepository.findById(idTipoItem)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idTipoItem));
		return ResponseEntity.ok().body(tipoItem);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tipo_Item> updateTipoItem(@PathVariable(value = "id") Long idTipoItem,
			@Validated @RequestBody Tipo_Item tipoItemDetalhe) throws ResourceNotFoundException{
		Tipo_Item tipoItem = tpItemRepository.findById(idTipoItem)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idTipoItem));
		
		tipoItem.setTit_codigo(tipoItemDetalhe.getTit_codigo());
		tipoItem.setTit_tipo_item(tipoItemDetalhe.getTit_tipo_item());
		
		final Tipo_Item tipoItemT = tpItemRepository.save(tipoItem);
		return ResponseEntity.ok(tipoItemT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarTipoItem(@PathVariable(value = "id") Long idTipoItem)
		throws ResourceNotFoundException{
		Tipo_Item tipoItem = tpItemRepository.findById(idTipoItem)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Item para esse :: " +idTipoItem));
		tpItemRepository.delete(tipoItem);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}
