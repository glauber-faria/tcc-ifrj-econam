package org.econam.api.service;

import java.util.List;
import java.util.Optional;

import org.econam.api.model.Client;
import org.econam.api.model.Device;
import org.econam.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll(){
		return clientRepository.findAll();
	}

	public Optional<Client> findById(Long id){
		return clientRepository.findById(id);
	}

	public Client save(Client d){
		return clientRepository.save(d);
	}

	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}
}
