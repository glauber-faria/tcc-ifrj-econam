package br.eco.econam.collector.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eco.econam.collector.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    
}
