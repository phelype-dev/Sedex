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
import com.controle_sedex.model.Destinatarios;
import com.controle_sedex.repository.DestinatariosRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/destinatario")
public class DestinatarioController {
	
	@Autowired
	private DestinatariosRepository destinatarioRepository;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Destinatarios>> get() {
		return ResponseEntity.ok(destinatarioRepository.findAll());
	}
	
	@PostMapping
	public Destinatarios addDestinatario(@Validated @RequestBody Destinatarios destinatario) {
		return destinatarioRepository.save(destinatario);
	}
	
	@GetMapping("/cidade/{cid_codigo}")
	public List<Destinatarios> getAllDestCidade(@PathVariable(value = "cid_codigo") Long cid_codigo){
		return destinatarioRepository.getAllDestInCidade(cid_codigo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Destinatarios> getDestinatarioById(@PathVariable(value = "id") Long idDestinatario)
		throws ResourceNotFoundException{
		Destinatarios Destinatario = destinatarioRepository.findById(idDestinatario)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar o ID ::"+idDestinatario));
		return ResponseEntity.ok().body(Destinatario);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Destinatarios> updateDestinatario(@PathVariable(value = "id") Long idDestinatario,
			@Validated @RequestBody Destinatarios destinatarioDetalhe) throws ResourceNotFoundException{
		Destinatarios destinatario = destinatarioRepository.findById(idDestinatario)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possi ::"+idDestinatario));
		
		destinatario.setDes_codigo(destinatarioDetalhe.getDes_codigo());
		destinatario.setDes_destinatario(destinatarioDetalhe.getDes_destinatario());
		destinatario.setDes_aos_cuidados_abrev(destinatarioDetalhe.getDes_aos_cuidados_abrev());
		destinatario.setDes_aos_cuidados_abrev(destinatarioDetalhe.getDes_aos_cuidados_abrev());
		destinatario.setDes_cpf(destinatarioDetalhe.getDes_cpf());
		destinatario.setDes_logradouro(destinatarioDetalhe.getDes_logradouro());
		destinatario.setDes_numero(destinatarioDetalhe.getDes_numero());
		destinatario.setDes_complemento(destinatarioDetalhe.getDes_complemento());
		destinatario.setDes_bairro(destinatarioDetalhe.getDes_bairro());
		destinatario.setCid_cidade(destinatarioDetalhe.getCid_cidade());
		destinatario.setEst_estado(destinatarioDetalhe.getEst_estado());
		destinatario.setDes_cep(destinatarioDetalhe.getDes_cep());
		destinatario.setDes_fixo(destinatarioDetalhe.getDes_fixo());
		destinatario.setDes_movel(destinatarioDetalhe.getDes_movel());
		destinatario.setDes_transpotadora(destinatarioDetalhe.getDes_transpotadora());
		destinatario.setDes_ativo(destinatarioDetalhe.isDes_ativo());
		destinatario.setDes_data_alteracao(destinatarioDetalhe.getDes_data_alteracao());
		destinatario.setDes_latitude(destinatarioDetalhe.getDes_latitude());
		destinatario.setDes_longitude(destinatarioDetalhe.getDes_longitude());
		
		
		
		final Destinatarios destinatarioT = destinatarioRepository.save(destinatario);
		return ResponseEntity.ok(destinatarioT);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletarVendas(@PathVariable(value = "id") Long idDestinatario)
		throws ResourceNotFoundException{
		Destinatarios Destinatario = destinatarioRepository.findById(idDestinatario)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe Destinatario para esse :: " +idDestinatario));
		destinatarioRepository.delete(Destinatario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado com sucesso !", Boolean.TRUE);
		return response;
	}
}