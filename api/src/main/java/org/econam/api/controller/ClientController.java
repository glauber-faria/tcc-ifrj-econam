package org.econam.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.econam.api.model.Client;
import org.econam.api.repository.ClientRepository;
import org.econam.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<Client>> getAll() {
		try {
			List<Client> items = new ArrayList();

			service.findAll().forEach(items::add);

			if (items.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("{id}")
	public ResponseEntity<Client> getById(@PathVariable("id") Long id) {
			Optional<Client> existingItemOptional = service.findById(id);

			if (existingItemOptional.isPresent()) {
					return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
			} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}

	@PostMapping
	public ResponseEntity<Client> create(@RequestBody Client item) {
		try {
			Client savedItem = service.save(item);
			return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody Client item) {
			Optional<Client> existingItemOptional = service.findById(id);
			if (existingItemOptional.isPresent()) {
					Client existingItem = existingItemOptional.get();
					System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
					//existingItem.setSomeField(item.getSomeField());
					return new ResponseEntity<>(service.save(existingItem), HttpStatus.OK);
			} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
			try {
					service.deleteById(id);
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
					return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
			}
	}

}
