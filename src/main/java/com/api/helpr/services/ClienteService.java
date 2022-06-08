package com.api.helpr.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.helpr.domain.Cliente;
import com.api.helpr.domain.Tecnico;
import com.api.helpr.domain.dtos.ClienteDTO;
import com.api.helpr.domain.dtos.TecnicoDTO;
import com.api.helpr.repositories.ClienteRepository;
import com.api.helpr.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado: " + id));
	}

	public List<Cliente> findAllClientes() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDto) {
		objDto.setId(null);
		validaCpfEEmail(objDto);
		Cliente newObj = new Cliente(objDto);
		return repository.save(newObj);
	}

	private void validaCpfEEmail(ClienteDTO objDto) {

	}

	public Cliente update(Integer id, ClienteDTO objDto) {
		objDto.setId(id);
		Cliente oldObj = findById(id);
		validaCpfEEmail(objDto);
		oldObj = new Cliente(objDto);
		return repository.save(oldObj);
	}

	public Tecnico create(@Valid TecnicoDTO objDto) {
		return null;
	}

	public List<Cliente> findAllCliente() {
		return null;
	}

}
