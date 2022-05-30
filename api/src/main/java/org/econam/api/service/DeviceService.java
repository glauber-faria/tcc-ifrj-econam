package org.econam.api.service;

import org.econam.api.repository.ClientRepository;
import org.econam.api.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private DeviceRepository deviceRepository;
}
